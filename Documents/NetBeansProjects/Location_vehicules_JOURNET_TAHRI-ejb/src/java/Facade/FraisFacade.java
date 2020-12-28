/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Assurance;
import Entite.Frais;
import Entite.Location;
import Entite.Reservation;
import Entite.Type_frais;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tahri
 */
@Stateless
public class FraisFacade extends AbstractFacade<Frais> implements FraisFacadeLocal {

    @PersistenceContext(unitName = "Location_vehicules_JOURNET_TAHRI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FraisFacade() {
        super(Frais.class);
    }

    @Override
    public void CreerFraisReservationAcompte(Reservation laReservation) {

        Frais f = new Frais();
        //------------------------------------------------------------------------------------------//
        // Initialisation des variables
        //------------------------------------------------------------------------------------------//

        // Le numFrais sera composé du numéro de réservation et le type de frais
        f.setNum_frais(laReservation.getNum_reservation() + "Accompte");
        f.setLareservation(laReservation);
        //------------------------------------------------------------------------------------------//
        // Calcul de l'acompte automatique sur une base d'acompte à 10% du prix total pour l'interface client
        //------------------------------------------------------------------------------------------//
        Date datedebut = laReservation.getDate_debut_reservation();
        Date datefin = laReservation.getDate_fin_reservation();
        double nbjours = datedebut.compareTo(datefin);
        double prixjour = laReservation.getLeVehicule().getPrix_jour();
        double prixtotal = prixjour * nbjours;
        double acompte = prixtotal * 0.1;

        //  Initialisation de la date de frais à la date du jour
        Date datedujour = new Date();
        f.setDateFrais(datedujour);

        f.setMontant_frais(acompte);
        f.setType_frais(Type_frais.Acompte);
        getEntityManager().persist(f);

    }

    @Override
    public void CreerFraisReservationAcompteAgent(Reservation laReservation, double pourcentage) {

        Frais f = new Frais();
        //------------------------------------------------------------------------------------------//
        // Initialisation des variables
        //------------------------------------------------------------------------------------------//

        // Le numFrais sera composé du numéro de réservation et le type de frais
        f.setNum_frais(laReservation.getNum_reservation() + "Accompte");
        f.setLareservation(laReservation);
        //------------------------------------------------------------------------------------------//
        // Calcul de l'acompte automatique avec un pourcentage d'acompte modifiable pour l'interface agent
        //------------------------------------------------------------------------------------------//
        Date datedebut = laReservation.getDate_debut_reservation();
        Date datefin = laReservation.getDate_fin_reservation();
        double nbjours = datedebut.compareTo(datefin);
        double prixjour = laReservation.getLeVehicule().getPrix_jour();
        double prixtotal = prixjour * nbjours;
        double acompte = prixtotal * pourcentage;

        //  Initialisation de la date de frais à la date du jour
        Date datedujour = new Date();
        f.setDateFrais(datedujour);

        f.setMontant_frais(acompte);
        f.setType_frais(Type_frais.Acompte);
        getEntityManager().persist(f);

    }

    @Override
    public void CreerFraisReservationIntegral(Reservation laReservation) {

        Frais f = new Frais();
        //------------------------------------------------------------------------------------------//
        // Initialisation des variables
        //------------------------------------------------------------------------------------------//

        // Le numFrais sera composé du numéro de réservation et le type de frais
        f.setNum_frais(laReservation.getNum_reservation() + "Frais total");
        f.setLareservation(laReservation);
        //------------------------------------------------------------------------------------------//
        // Calcul du prix total automatique 
        //------------------------------------------------------------------------------------------//
        Date datedebut = laReservation.getDate_debut_reservation();
        Date datefin = laReservation.getDate_fin_reservation();
        double nbjours = datedebut.compareTo(datefin);
        double prixjour = laReservation.getLeVehicule().getPrix_jour();
        double prixtotal = prixjour * nbjours;

        //  Initialisation de la date de frais à la date du jour
        Date datedujour = new Date();
        f.setDateFrais(datedujour);

        f.setMontant_frais(prixtotal);
        f.setType_frais(Type_frais.Frais_integral);
        getEntityManager().persist(f);

    }

    @Override
    public void CreerFraisLocationIntegral(Location laLocation, String assur) {

        Frais f = new Frais();
        Location l = new Location();
        //------------------------------------------------------------------------------------------//
        // Initialisation des variables
        //------------------------------------------------------------------------------------------//

        // Le numFrais sera composé du numéro de réservation et le type de frais
        f.setNum_frais(laLocation.getNum_location() + "Frais total");
        f.setLalocation(laLocation);
        //------------------------------------------------------------------------------------------//
        // Calcul du prix total automatique 
        //------------------------------------------------------------------------------------------//
        Date datedebut = laLocation.getDate_debut_reel();
        Date datefin = laLocation.getDate_fin_prevue();
        double nbjours = datedebut.compareTo(datefin);
        double prixjour = laLocation.getLevehicule().getPrix_jour();
        double prixtotal = prixjour * nbjours;

        //  Initialisation de la date de frais à la date du jour
        Date datedujour = new Date();
        f.setDateFrais(datedujour);

        f.setMontant_frais(prixtotal);
        f.setType_frais(Type_frais.Frais_integral);

        //------------------------------------------------------------------------------------------//
        // Recupération de la weblist
        //------------------------------------------------------------------------------------------//
        if (assur.equalsIgnoreCase("Oui")) {
            l.setAssurance(Assurance.Souscrit);

        } else if (assur.equalsIgnoreCase("Non")) {

            l.setAssurance(Assurance.Nonsouscrit);
        }
        getEntityManager().persist(f);

    }

    @Override
    public void CreerFraisLocationDeduit(Location laLocation, double pourcentage, int acomptepaye, int cautionpaye) {

        Frais f = new Frais();
        //------------------------------------------------------------------------------------------//
        // Initialisation des variables
        //------------------------------------------------------------------------------------------//

        // Le numFrais sera composé du numéro de réservation et le type de frais
        f.setNum_frais(laLocation.getNum_location() + "Frais total");
        f.setLalocation(laLocation);
        //------------------------------------------------------------------------------------------//
        // Calcul du prix deduit automatique 
        //------------------------------------------------------------------------------------------//
        Date datedebut = laLocation.getDate_debut_reel();
        Date datefin = laLocation.getDate_fin_prevue();
        double nbjours = datedebut.compareTo(datefin);
        double prixjour = laLocation.getLevehicule().getPrix_jour();
        double prixtotal = prixjour * nbjours;
        double acompte = prixtotal * pourcentage;
        double caution = laLocation.getLevehicule().getCaution();
        double prixssacompte = prixtotal - acompte;
        double prixsscaution = prixtotal - caution;
        double prixssfrais = prixtotal - (acompte + caution);

        //------------------------------------------------------------------------------------------//
        // Recupération de la valeur de la checkbox pour cette méthode
        //------------------------------------------------------------------------------------------//
        if (acomptepaye > 0 & cautionpaye <= 0) {

            f.setMontant_frais(prixssacompte);
        }
        if (acomptepaye <= 0 & cautionpaye > 0) {
            f.setMontant_frais(prixsscaution);

        }
        if (cautionpaye > 0 & acomptepaye > 0) {
            f.setMontant_frais(prixssfrais);

        }

        f.setType_frais(Type_frais.Frais_Montant_Restant);
        getEntityManager().persist(f);

    }

    @Override
    public void CreerFraisAnnulationReservation(Reservation laReservation, double pourcentage) {

        Frais f = new Frais();
        //------------------------------------------------------------------------------------------//
        // Initialisation des variables
        //------------------------------------------------------------------------------------------//

        // Le numFrais sera composé du numéro de réservation et le type de frais
        f.setNum_frais(laReservation.getNum_reservation() + "Annulation reservation");
        f.setLareservation(laReservation);
        //------------------------------------------------------------------------------------------//
        // Calcul des frais de suppression à 50% du prix total de la reservation total
        //------------------------------------------------------------------------------------------//
        Date datedebut = laReservation.getDate_debut_reservation();
        Date datefin = laReservation.getDate_fin_reservation();
        double nbjours = datedebut.compareTo(datefin);

        double prixjour = laReservation.getLeVehicule().getPrix_jour();
        double prixtotal = prixjour * nbjours;
        double acompte = prixtotal * pourcentage;
        double fraissup = (prixtotal - acompte) * 0.5;

        f.setMontant_frais(fraissup);
        f.setType_frais(Type_frais.Frais_de_suppression_de_réservation);
        getEntityManager().persist(f);

    }

    @Override
    public void CreerFraisLocationAgent(Location laLocation, Type_frais type_paiement, String cause_frais, int montant_frais) {

        Frais f = new Frais();
        //------------------------------------------------------------------------------------------//
        // Initialisation des variables
        //------------------------------------------------------------------------------------------//

        // Le numFrais sera composé du numéro de réservation et le type de frais
        f.setNum_frais(laLocation.getNum_location() + cause_frais);
        f.setLalocation(laLocation);
        f.setMontant_frais(montant_frais);
        f.setType_frais(type_paiement);

        getEntityManager().persist(f);

    }

    @Override
    public double CalculReservationAcompte(Reservation laReservation) {
        Date datedebut = laReservation.getDate_debut_reservation();
        Date datefin = laReservation.getDate_fin_reservation();
        double nbjours = datedebut.compareTo(datefin);
        double prixjour = laReservation.getLeVehicule().getPrix_jour();
        double prixtotal = prixjour * nbjours;
        //------------------------------------------------------------------------------------------//
        // Calcul de l'acompte pour une réservation de base à 10% du prix total
        //------------------------------------------------------------------------------------------//
        double acompte = prixtotal * 0.1;

        return acompte;
    }

    @Override
    public double CalculLocationAcompte(Location laLocation, double pourcentage) {
        Date datedebut = laLocation.getDate_debut_reel();
        Date datefin = laLocation.getDate_fin_prevue();
        double nbjours = datedebut.compareTo(datefin);
        double prixjour = laLocation.getLevehicule().getPrix_jour();
        double prixtotal = prixjour * nbjours;
        double acompte = prixtotal * pourcentage;

        return acompte;
    }

    @Override
    public double CalculCaution(Location laLocation, double pourcentage) {
        double caution = laLocation.getLevehicule().getCaution();
        return caution;
    }

    @Override
    public double CalculMontantRestantLocation(Location laLocation, double pourcentage, int acomptepaye, int cautionpaye) {
        Date datedebut = laLocation.getDate_debut_reel();
        Date datefin = laLocation.getDate_fin_prevue();
        double nbjours = datedebut.compareTo(datefin);
        double prixjour = laLocation.getLevehicule().getPrix_jour();
        double prixtotal = prixjour * nbjours;
        double acompte = prixtotal * pourcentage;
        double caution = laLocation.getLevehicule().getCaution();
        double prixssacompte = prixtotal - acompte;
        double prixsscaution = prixtotal - caution;
        double prixssfrais = prixtotal - (acompte + caution);
        //------------------------------------------------------------------------------------------//
        // Recupération de la valeur de la checkbox pour cette méthode
        //------------------------------------------------------------------------------------------//

        if (acomptepaye > 0 & cautionpaye <= 0) {

            return prixssacompte;
        }
        if (acomptepaye <= 0 & cautionpaye > 0) {
            return prixsscaution;

        }
        return prixssfrais;
    }

    // ----------------------------------------------------------------------//
    // Ajouter la prise en compte de la date dans la recherche de frais //
    //--------------------------------------------------------------------//
        @Override
        public int CalculCAparVille(String Ville, Date datedebp, Date datefinp) {
            int l;
            Query req = getEntityManager().createQuery("SELECT sum(f.Montant_frais) FROM Frais AS f WHERE f.Lalocation.Leagent.Laagence.Localisation=:vi");
            req = req.setParameter("vi", Ville);
            l =  (int) req.getSingleResult();
            return l; 
    
        }
        @Override
            public int CalculCAparAgence(String numagence, Date datedebp, Date datefinp) {
            int l;
            Query req = getEntityManager().createQuery("SELECT sum(f.Montant_frais) FROM Frais AS f WHERE f.Lalocation.Leagent.Laagence.Num_agence=:vi");
            req = req.setParameter("vi", numagence);
            l =  (int) req.getSingleResult();
            return l;
    
        }




}
