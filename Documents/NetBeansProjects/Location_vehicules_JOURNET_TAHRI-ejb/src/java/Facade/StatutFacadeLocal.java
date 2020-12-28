/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Statut;
import Entite.Vehicule;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tahri
 */
@Local
public interface StatutFacadeLocal {

    void create(Statut statut);

    void edit(Statut statut);

    void remove(Statut statut);

    Statut find(Object id);

    List<Statut> findAll();

    List<Statut> findRange(int[] range);

    int count();

    Statut RechercherStatutNum(String nume);

    void modificationfinStatut(Date datefin, Statut s);

    public void CreerStatut(String numStatut, String libelleStatut, Vehicule vehicule, Date datedebut, Date datefin, String detail);
}
