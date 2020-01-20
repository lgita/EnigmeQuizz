/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Agent;
import Entite.Assurance;
import Entite.Client;
import Entite.Compte;
import Entite.Location;
import Entite.Reservation;
import Entite.Statut;
import Entite.Type;
import Entite.Type_entretien;
import Entite.Type_frais;
import Entite.Vehicule;
import Entite.Vol;
import Facade.ClientFacadeLocal;
import Facade.CompteFacadeLocal;
import Facade.EntretienFacadeLocal;
import Facade.FraisFacadeLocal;
import Facade.LocationFacadeLocal;
import Facade.ReservationFacadeLocal;
import Facade.VehiculeFacadeLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author journ
 */
@Stateless
public class Session implements SessionLocal {
    @EJB
    private VehiculeFacadeLocal vehiculeFacade;
    @EJB
    private ReservationFacadeLocal reservationFacade;
    @EJB
    private LocationFacadeLocal locationFacade;
    @EJB
    private FraisFacadeLocal fraisFacade;
    @EJB
    private EntretienFacadeLocal entretienFacade;
    @EJB
    private CompteFacadeLocal compteFacade;
    @EJB
    private ClientFacadeLocal clientFacade;
    
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Compte AuthentificationSession(String l, String mdp) {
        Compte c;
        c = compteFacade.Authentification(l,mdp);
        return c; }
   
    @Override
    public void CreationClientSession(String num, String nom, String prenom, String adresse, String tel) {
        clientFacade.CreationClient(num, nom, prenom, adresse, tel); }
    
    @Override
    public void CreationCompteSession(String num, String l, String mdp, Date date, String mail, Client Client) {
        compteFacade.CreerCompte(num, mail, mdp, date, mail, Client);}
    
    @Override
    public void ModificationCompteSession(Compte c, String l, String mdp, String nvmdp) {
        c = compteFacade.Authentification(l, mdp);
        compteFacade.ModificationMdp(c, nvmdp); }
    
    @Override
    public void CreationEntretienSession(String num, Date dated, Date datef, Type_entretien type) {
        entretienFacade.CreerEntretien(num, dated, datef, type);}
    
    @Override
    public void CreationFraisSession(String num, Type_frais type, double mt, Location lo, Reservation re) {
        fraisFacade.CreationFrais(num, type, mt, lo, re);}
    
    @Override
    public void CreationLocationSession(String num, String etatd, Assurance assur, double mtr, double mtc, Date dated, Date datef, double prix, Date df2, Date df30, Vehicule vehi, Reservation resa, Client cli, Agent agent) {
    locationFacade.CreationLocation(num, etatd, assur, mtr, mtc, dated, datef, prix, datef, datef, vehi, resa, cli, agent);}
    
    @Override
    public void ModificationPayementLocationSession( double mt, Assurance assur, String num) {
        Location l = locationFacade.RechercheLocation(num);
        locationFacade.ModificationPayementLocation(l, mt, assur);}

    @Override
    public void ModificationRetourVoitureSession(Date date, String etat, String num) {
        Location l = locationFacade.RechercheLocation(num);
        locationFacade.ModificationRetourVoiture(l, etat, date);}

    @Override
    public void ModificationVoitureVolSession(String num, Vol vol) {
        Location l = locationFacade.RechercheLocation(num);
        locationFacade.ModificationVol(l, vol);}

    @Override
    public java.util.Collection<Location> RechercheLocation2JoursSession(Date d) {
       Collection<Location>col = locationFacade.RechercheLocation2Jours(d);
        return col; }
    
    @Override
    public java.util.Collection<Location> RechercheLocation30JoursSession(Date d) {
       Collection<Location>col = locationFacade.RechercheLocation30Jours(d);
        return col; } 
    
    @Override
    public void CreationReservationSession(String num, Date dated, Date datef, double mta, double pra, Compte co) {
      reservationFacade.CreationReservation(num, dated, datef, mta, pra, co);}
    
    @Override
    public void ModificationReservationSession(String num, Date dated, Date datef) {
        Reservation r = reservationFacade.RechercheReservation(num);
        reservationFacade.ModificationDate(r, dated, datef);}

    @Override
    public void SupprimerReservationSession(String num) {
        Reservation r = reservationFacade.RechercheReservation(num);
        reservationFacade.SupprimerReservation(r); }

    @Override
    public java.util.Collection<Reservation> ReservationVenirSession(Date d) {
       Collection<Reservation>col = reservationFacade.RechercheReservationVenir(d);
        return col; }
    
    @Override
    public void CreationVoitureSession(String num, String marq, String mod,Type type, double prixj, double prixs, double km) {
        vehiculeFacade.CreerVehicule(num, marq, mod, type, prixj, prixs, km); }

    @Override
    public void ModifierStatutSession(String num, Statut satut) {
        Vehicule v = vehiculeFacade.RechercherVehicule(num);
        vehiculeFacade.ModificationStatut(v, satut);}

    @Override
    public java.util.Collection<Vehicule> RechercheVehiculeLibre(Statut st) {
        Collection<Vehicule>col = vehiculeFacade.RechercheVehiculeLibre(st);
        return col; }
    

    @Override
    public Location ChiffreAffaireSession() {
        return null;
    }

    

    
    

}
    
    

    
    
    
    
    
    
    

    
