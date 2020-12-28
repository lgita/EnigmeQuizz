/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Frais;
import Entite.Location;
import Entite.Reservation;
import Entite.Type_frais;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tahri
 */
@Local
public interface FraisFacadeLocal {

    void create(Frais frais);

    void edit(Frais frais);

    void remove(Frais frais);

    Frais find(Object id);

    List<Frais> findAll();

    List<Frais> findRange(int[] range);

    int count();

    public double CalculMontantRestantLocation(Location laLocation, double pourcentage, int acomptepaye, int cautionpaye);

    public double CalculCaution(Location laLocation, double pourcentage);

    public double CalculLocationAcompte(Location laLocation, double pourcentage);

    public double CalculReservationAcompte(Reservation laReservation);

    public void CreerFraisLocationAgent(Location laLocation, Type_frais type_paiement, String cause_frais, int montant_frais);

    public void CreerFraisAnnulationReservation(Reservation laReservation, double pourcentage);

    public void CreerFraisLocationDeduit(Location laLocation, double pourcentage, int acomptepaye, int cautionpaye);


    public void CreerFraisReservationIntegral(Reservation laReservation);

    public void CreerFraisReservationAcompteAgent(Reservation laReservation, double pourcentage);

    public void CreerFraisReservationAcompte(Reservation laReservation);

    public void CreerFraisLocationIntegral(Location laLocation, String assur);



    public int CalculCAparVille(String Ville, Date datedebp, Date datefinp);

    public int CalculCAparAgence(String numagence, Date datedebp, Date datefinp);
    
}
