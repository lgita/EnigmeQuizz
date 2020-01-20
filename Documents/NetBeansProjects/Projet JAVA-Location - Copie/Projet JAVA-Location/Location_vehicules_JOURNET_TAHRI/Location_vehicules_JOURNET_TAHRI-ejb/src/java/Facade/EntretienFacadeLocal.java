/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Entretien;
import Entite.Type_entretien;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author journ
 */
@Local
public interface EntretienFacadeLocal {

    void create(Entretien entretien);

    void edit(Entretien entretien);

    void remove(Entretien entretien);

    Entretien find(Object id);

    List<Entretien> findAll();

    List<Entretien> findRange(int[] range);

    int count();

    void CreerEntretien(String num, Date dated, Date datef, Type_entretien type);
    
}
