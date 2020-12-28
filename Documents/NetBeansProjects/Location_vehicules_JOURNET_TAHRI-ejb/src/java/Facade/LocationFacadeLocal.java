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
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tahri
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

    public Collection<Location> RechercherLocationRetard(Date datefinprevu);

    public void RetourLocation(Location l, String etat);

    public void SaisiVol(Location l);

    public Location RechercherLocationDateID(Date datedebut, Date datefin, String idclient);

    public Location RechercherLocationNum(String num);

    public void ModifierDateFinReel(Location l, Date datefinreel);


    public int CalculRetard(Location l);

    public void CreerLocationAvecReservation(String etat, Assurance assur, Reservation laReservation, Agent leAgent, Double nbkm);

    public void CreerLocationSansReservation(String num, String etat, Assurance assur, double mtrestant, double caution, Date datedebut, Date datefinprevue, Vehicule leVehicule, Client leClient, Agent Leagent, Double nbkm);
    
}
