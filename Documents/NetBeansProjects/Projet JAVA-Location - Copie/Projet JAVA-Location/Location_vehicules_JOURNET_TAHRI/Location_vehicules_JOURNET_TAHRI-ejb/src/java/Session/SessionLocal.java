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
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author journ
 */
@Local
public interface SessionLocal {

    Compte AuthentificationSession(String l, String mdp);

    void CreationClientSession(String num, String nom, String prenom, String adresse, String tel);

    void CreationCompteSession(String num, String l, String mdp, Date date, String mail, Client Client);

    void ModificationCompteSession(Compte c,String l, String mdp, String nvmdp);

    void CreationEntretienSession(String num, Date dated, Date datef, Type_entretien type);

    void CreationFraisSession(String num, Type_frais type, double mt, Location lo, Reservation re);

    void CreationLocationSession(String num, String etatd, Assurance assur, double mtr, double mtc, Date dated, Date datef, double prix,Date df2, Date df30, Vehicule vehi, Reservation resa, Client cli, Agent agent);

    void ModificationPayementLocationSession( double mt, Assurance assur, String num);

    void ModificationRetourVoitureSession(Date date, String etat, String num);

    void ModificationVoitureVolSession(String num, Vol vol);

    java.util.Collection<Location> RechercheLocation2JoursSession(Date d);

    void CreationReservationSession(String num, Date dated, Date datef, double mta, double pra, Compte co);

    void ModificationReservationSession(String num, Date dated, Date datef);

    void SupprimerReservationSession(String num);

    java.util.Collection<Reservation> ReservationVenirSession(Date d);

    void CreationVoitureSession(String num, String marq, String mod,Type type, double prixj, double prixs, double km);

    void ModifierStatutSession(String num, Statut satut);

    java.util.Collection<Vehicule> RechercheVehiculeLibre(Statut st);

    java.util.Collection<Location> RechercheLocation30JoursSession(Date d);

    Location ChiffreAffaireSession();


    
}
