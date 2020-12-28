/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Statut;
import Entite.Type;
import Entite.Vehicule;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author journ
 */
@Local
public interface VehiculeFacadeLocal {

    void create(Vehicule vehicule);

    void edit(Vehicule vehicule);

    void remove(Vehicule vehicule);

    Vehicule find(Object id);

    List<Vehicule> findAll();

    List<Vehicule> findRange(int[] range);

    int count();

    void CreerVehicule(String num, String marque, String modele, Type type , double prixj, double prixs, Double nbkm,int caut);

    Vehicule RechercherVehicule (String num);
    
    public Collection<Vehicule> RechercheVehiculeLibre();

    public Collection<Vehicule> RechercheTypeVehicule(String type);

    public Double NombredeKm(Vehicule v);


    public Collection<Vehicule> RechercheReparationRevision(Vehicule v);
    
}
