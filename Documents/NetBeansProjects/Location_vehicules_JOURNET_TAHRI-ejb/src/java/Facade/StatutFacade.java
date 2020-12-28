/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Statut;
import Entite.Vehicule;
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
public class StatutFacade extends AbstractFacade<Statut> implements StatutFacadeLocal {

    @PersistenceContext(unitName = "Location_vehicules_JOURNET_TAHRI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatutFacade() {
        super(Statut.class);
    }

    @Override
    public void CreerStatut(String numStatut, String libelleStatut, Vehicule vehicule, Date datedebut, Date datefin, String detail) {
        Statut s = new Statut();
        s.setLibelle(libelleStatut);
        s.setNum_statut(numStatut);
        s.setVehicule(vehicule);
        s.setDateDebut(datedebut);
        s.setDateFin(datefin);
        s.setDetailStatut(detail);
        getEntityManager().persist(s);
    }

    @Override
    public  Statut RechercherStatutNum(String nume) {
        Statut s;
        String txt="SELECT s FROM Statut  AS s WHERE s.nume=:nu";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("nu",nume);
        s = (Statut)req.getSingleResult();
        return s;
    }

    @Override
    public void modificationfinStatut(Date datefin, Statut s) {
        s.setDateFin(datefin);
        getEntityManager().merge(s);
    }
    
    public void CreerReparation (String num, Vehicule leVehicule, Date datedebut, Date datefinprevue, String detail_reparation){
        Statut s = new Statut();
        s.setNum_statut(num + "reparation");
        s.setVehicule(leVehicule);
        s.setDateDebut(datedebut);
        s.setDateFin(datefinprevue);
        s.setDetailStatut(detail_reparation);
        //sera prolonger si besoin par l'Agent
        s.setLibelle("en reparation");
        getEntityManager().persist(s);
    }

        public void CreerRevision (String num, Vehicule leVehicule, Date datedebut, Date datefinprevue, String detail_reparation){
        Statut s = new Statut();
        s.setNum_statut(num + "révision");
        s.setVehicule(leVehicule);
        s.setDateDebut(datedebut);
        s.setDateFin(datefinprevue);
        s.setDetailStatut(detail_reparation);
        //sera prolonger si besoin par l'Agent
        s.setLibelle("en revision");
        getEntityManager().persist(s);
    }

}
