/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Compte;
import Entite.Reservation;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author journ
 */
@Local
public interface ReservationFacadeLocal {

    void create(Reservation reservation);

    void edit(Reservation reservation);

    void remove(Reservation reservation);

    Reservation find(Object id);

    List<Reservation> findAll();

    List<Reservation> findRange(int[] range);

    int count();

    void CreationReservation(String num, Date dated, Date datef, double mtacompte, double pracompte, Compte compte);

    void ModificationDate(Reservation r,Date dated, Date datef);

    void SupprimerReservation(Reservation reservation);

    Reservation RechercheReservation(String num);

    java.util.Collection<Reservation> RechercheReservationVenir(Date d);

    public Reservation RechercheReservationidClient(String idClient, Date datedeb, Date datefin);

   
    
}
