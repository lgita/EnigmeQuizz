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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author journ
 */
@Stateless
public class LocationFacade extends AbstractFacade<Location> implements LocationFacadeLocal {
    @PersistenceContext(unitName = "Location_vehicules_JOURNET_TAHRI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocationFacade() {
        super(Location.class);
    }

    @Override
    public void CreationLocation(String num, String etatdebut, Assurance assurance, double mtrestant, double mtcaution, Date datedebut, Date datefinprevu,double prixinitial, Date datefin2, Date datefin30, Vehicule vehicule,
            Reservation reservation, Client client, Agent agent) {
        
        Location c = new Location();
        c.setNum_location(num);
        c.setEtat_voiture_début(etatdebut);
        c.setAssurance(assurance);
        c.setMontant_restant(mtrestant);
        c.setMontant_caution(mtcaution);
        c.setDate_debut_reel(datedebut);
        c.setDate_fin_prevue(datefinprevu);
        c.setPrix_initial(prixinitial);
        c.setDate_fin_prevue2jours(datefin2);
        c.setDate_fin_prevue30jours(datefin30);
        c.setLevehicule(vehicule);
        c.setLareservation(reservation);
        c.setLeclient(client);
        c.setLeagent(agent);
        getEntityManager().persist(c);
        
        
    }

    @Override
    public Location RechercheLocation(String num) {
       
             Location l =null;
        List<Location> result;

        String txt="SELECT l FROM Location AS l WHERE l.num_location=:nu ";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("nu",num);
         result = req.getResultList();
       	 if (result.size()==1)
       	 {
          		  l = (Location)result.get(0);
	}
         return l;
    }

    @Override
public void ModificationPayementLocation(Location l, double mtcaution, Assurance assur) {
        l.setMontant_payer_caution(mtcaution);
        l.setAssurance(assur);
         getEntityManager().merge(l);
    }

    @Override
    public void ModificationRetourVoiture(Location l, String etat, Date dateretour) {
        l.setEtat_voiture_retour(etat);
        l.setDate_fin_reel(dateretour);
        getEntityManager().merge(l);
    }

    @Override
    public void ModificationVol(Location l, Vol vol) {
        l.setVol(vol);
           getEntityManager().merge(l);
    }

    @Override
    public java.util.Collection<Location> RechercheLocation2Jours(Date d) {
        Query req=getEntityManager().createNativeQuery("SELECT l FROM Location AS l WHERE l.date_fin_prevue2jours <=: d ");
        req=req.setParameter("d",d);
        Collection<Location> col = req.getResultList();
        return col; }

    @Override
    public java.util.Collection<Location> RechercheLocation30Jours(Date d) {
        Query req=getEntityManager().createNativeQuery ("SELECT l FROM Location AS l WHERE l.date_fin_prevue2jours <=: d ");
        req=req.setParameter("d",d);
       Collection<Location> col = req.getResultList();
        return col; }

    @Override
    public java.util.Collection<Location> ListeLocation() {
           Query req=getEntityManager().createNativeQuery ("SELECT l FROM Location AS l ");
       Collection<Location> col = req.getResultList();
        return col; }
    
    @Override
    public Location ChiffreAffaire(Location l) {
        
        return l;
    }

    
    
    
    }
    
    

    
    
    
    
    
    
