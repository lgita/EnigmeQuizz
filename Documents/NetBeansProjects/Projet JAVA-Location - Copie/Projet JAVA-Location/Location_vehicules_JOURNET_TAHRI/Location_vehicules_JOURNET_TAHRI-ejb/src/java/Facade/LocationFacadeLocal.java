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
import Entite.Vehicule;
import Entite.Vol;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author journ
 */
@Local
public interface LocationFacadeLocal {

    void create(Location location);

    void edit(Location location);

    void remove(Location location);

    Location find(Object id);

    List<Location> findAll();

    List<Location> findRange(int[] range);

    int count();

    void CreationLocation(String num, String etatdebut, Assurance assurance, double mtrestant, double mtcaution, Date datedebut, Date datefinprevu, double prixinitial,Date datefin2, Date datefin30, Vehicule vehicule,
            Reservation reservation, Client client, Agent agent);

    Location RechercheLocation(String num);

    void ModificationPayementLocation(Location l, double mtcaution, Assurance assur);

    void ModificationRetourVoiture(Location l, String etat, Date dateretour);

    void ModificationVol(Location l, Vol vol);

    java.util.Collection<Location>RechercheLocation30Jours(Date d);

    java.util.Collection<Location> RechercheLocation2Jours(Date d);
    
    java.util.Collection<Location> ListeLocation();
    
    public Location ChiffreAffaire(Location l); 

    
    
}
