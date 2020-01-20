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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author journ
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

    void CreationFrais(String num, Type_frais type,Double mtfrais, Location location, Reservation reservation);
    
}
