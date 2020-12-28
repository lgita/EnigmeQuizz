/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Agent;
import Entite.Assurance;
import Entite.Client;
import Entite.Location;
import Entite.Reservation;
import Entite.Statut;
import Entite.Vehicule;
import Entite.Vol;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author tahri
 */
@Stateless
public class LocationFacade extends AbstractFacade<Location> implements LocationFacadeLocal {

    @PersistenceContext(unitName = "Location_vehicules_JOURNET_TAHRI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocationFacade() {
        super(Location.class);
    }

    @Override
    public void CreerLocationSansReservation(String num, String etat, Assurance assur, double mtrestant, double caution, Date datedebut, Date datefinprevue, Vehicule leVehicule, Client leClient, Agent Leagent, Double nbkm) {
        Location l = new Location();
        int nbjours = datedebut.compareTo(datefinprevue);
        l.setNum_location(num);
        l.setEtat_voiture_début(etat);
        l.setAssurance(assur);
        //Calcul du prix initial sur le prix journalier du véhicule et le nombre de jours initial
        l.setPrix_initial(leVehicule.getPrix_jour() * nbjours);
        l.setDate_debut_reel(datedebut);
        //Date de fin sous réserve de modification par le client
        l.setDate_fin_prevue(datefinprevue);
        l.setLevehicule(leVehicule);
        l.setLeclient(leClient);
        l.setLeagent(Leagent);
        getEntityManager().persist(l);
        //Modification du kilométrage à la récupération du véhicule
        Vehicule v = leVehicule;
        leVehicule.setNb_km(nbkm);
        getEntityManager().persist(v);
        //Création automatique d'un nouveau statut pour marquer la location du véhicule
        Statut s = new Statut();
        s.setNum_statut(num);
        s.setVehicule(leVehicule);
        s.setDateDebut(datedebut);
        s.setDateFin(datefinprevue);
        //sera prolonger si besoin par l'Agent
        s.setLibelle("en location");
        getEntityManager().persist(s);

    }

    @Override
    public void CreerLocationAvecReservation(String etat, Assurance assur, Reservation laReservation, Agent leAgent, Double nbkm) {
        Location l = new Location();
        l.setLeagent(leAgent);
        //------------------------------------------------------------------------------------------//
        //Initialisation des variables pour calcul nombre de jours
        //------------------------------------------------------------------------------------------//
        Date datedebut = laReservation.getDate_debut_reservation();
        Date datefinprevue = laReservation.getDate_fin_reservation();
        //Calcul du nbjours
        int nbjours = datedebut.compareTo(datefinprevue);
        //------------------------------------------------------------------------------------------//
        //Recupération des variables à partir de la réservation
        //------------------------------------------------------------------------------------------//
        l.setNum_location(laReservation.getNum_reservation());
        l.setLevehicule(laReservation.getLeVehicule());
        //Calcul du prix initial sur le prix journalier du véhicule et le nombre de jours initial
        l.setPrix_initial(laReservation.getLeVehicule().getPrix_jour() * nbjours);
        l.setDate_debut_reel(datedebut);
        //Date de fin sous réserve de modification par le client
        l.setDate_fin_prevue(datefinprevue);
        l.setLeclient(laReservation.getLecompte().getLeclient());
        //Recupération de l'état
        l.setEtat_voiture_début(etat);
        getEntityManager().persist(l);
        //------------------------------------------------------------------------------------------//
        //Modification du kilométrage à la récupération du véhicule
        //------------------------------------------------------------------------------------------//
        Vehicule v = laReservation.getLeVehicule();
        v.setNb_km(nbkm);
        getEntityManager().persist(v);
        //------------------------------------------------------------------------------------------//
        //Création automatique d'un nouveau statut pour marquer la location du véhicule
        //------------------------------------------------------------------------------------------//
        Statut s = new Statut();
        s.setNum_statut(laReservation.getNum_reservation());
        s.setVehicule(laReservation.getLeVehicule());
        s.setDateDebut(datedebut);
        //sera prolongé si besoin par l'Agent
        s.setDateFin(datefinprevue);
        s.setLibelle("en location");
        getEntityManager().persist(s);

    }

    @Override
    public void ModifierDateFinReel(Location l, Date datefinreel) {
        l.setDate_fin_reel(datefinreel);
        getEntityManager().merge(l);
    }

    @Override
    public Location RechercherLocationNum(String num) {
        Location l;
        Query req = getEntityManager().createQuery("SELECT l FROM Location AS l WHERE l.Num_location=:nu");
        req = req.setParameter("nu", num);
        l = (Location) req.getSingleResult();
        return l;
    }

    @Override
    public Location RechercherLocationDateID(Date datedebut, Date datefin, String idclient) {
        Location l;
        Query req = getEntityManager().createQuery("SELECT l FROM Location AS l WHERE l.Leclient.id=:id AND l.Date_debut_reel=:dated AND l.Date_fin_prevue=:datef");
        req = req.setParameter("id", idclient);
        req = req.setParameter("dated", datedebut);
        req = req.setParameter("datef", datefin);
        l = (Location) req.getSingleResult();
        return l;
    }

    @Override
    public void SaisiVol(Location l) {
        l.setVol(Vol.Oui);
        String num = l.getNum_location();
        Vehicule leVehicule = l.getLevehicule();
        Date datedebut = new Date();
        //------------------------------------------------------------------------------------------//
        // Création automatique pour indiquer que le véhicule est volé sans date de fin
        //------------------------------------------------------------------------------------------//
        Statut s = new Statut();
        s.setNum_statut(num);
        s.setVehicule(leVehicule);
        s.setDateDebut(datedebut);
        s.setLibelle("volé");
        getEntityManager().merge(s);
        getEntityManager().merge(l);
    }

    @Override
    public void RetourLocation(Location l, String etat) {
        l.setEtat_voiture_retour(etat);
        //------------------------------------------------------------------------------------------//
        // Pour éviter toute fraude, le retour de la location devra être effectuée au moment de l'état des lieux du retour avec le locataire
        //------------------------------------------------------------------------------------------//
        Date datefinlocation = new Date();
        l.setDate_fin_reel(datefinlocation);
        getEntityManager().merge(l);
        //------------------------------------------------------------------------------------------//
        // Modification de l'état du véhicule pour le rendre disponible
        //------------------------------------------------------------------------------------------//
        Statut s = new Statut();
        s.setNum_statut(l.getNum_location());
        s.setVehicule(l.getLevehicule());
        s.setDateDebut(datefinlocation);
        s.setLibelle("disponible");
        getEntityManager().merge(s);
    }

    @Override
    public Collection<Location> RechercherLocationRetard(Date datefinprevu) {
        Query req = getEntityManager().createNativeQuery("SELECT l FROM Location AS l WHERE datediff(dd,nu,dd) <0");
        req.setParameter("nu", new Date(), TemporalType.DATE);
        req.setParameter("du", datefinprevu, TemporalType.DATE);
        Collection<Location> col = req.getResultList();
        return col;

    }

    @Override
    public int CalculRetard(Location l) {
        Date dateprevue = l.getDate_fin_prevue();
        Date datedujour = new Date();
        int nombrejourderetard = dateprevue.compareTo(datedujour);
        return nombrejourderetard;
    }

}
