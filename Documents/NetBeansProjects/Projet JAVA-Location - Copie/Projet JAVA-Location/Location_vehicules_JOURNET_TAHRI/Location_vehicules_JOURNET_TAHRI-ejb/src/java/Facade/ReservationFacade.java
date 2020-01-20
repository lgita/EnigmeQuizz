/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Compte;
import Entite.Location;
import Entite.Reservation;
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
public class ReservationFacade extends AbstractFacade<Reservation> implements ReservationFacadeLocal {
    @PersistenceContext(unitName = "Location_vehicules_JOURNET_TAHRI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationFacade() {
        super(Reservation.class);
    }

    @Override
    public void CreationReservation(String num, Date dated, Date datef, double mtacompte, double pracompte, Compte compte) {
        Reservation r = new Reservation();
        r.setNum_reservation(num);
        r.setDate_debut_reservation(dated);
        r.setDate_fin_reservation(datef);
        r.setLecompte(compte);
        r.setMontant_acompte(mtacompte);
        r.setPourcentage_acompte(pracompte);
        getEntityManager().persist(r);}

    @Override
    public void ModificationDate(Reservation r,Date dated, Date datef) {
        r.setDate_debut_reservation(dated);
        r.setDate_fin_reservation(datef);
         getEntityManager().merge(r);
    }

    @Override
    public void SupprimerReservation(Reservation reservation) {
        em.remove(reservation);
        
    }

    @Override
    public Reservation RechercheReservation(String num) {
   
            Reservation r =null;
        List<Reservation> result;

        String txt="SELECT r FROM Reservation AS r WHERE r.num_reservation=:nu ";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("nu",num);
         result = req.getResultList();
       	 if (result.size()==1)
       	 {
          		  r = (Reservation)result.get(0);
	}
         return r;
    }

    @Override
    public java.util.Collection<Reservation> RechercheReservationVenir(Date d) {
        Query req=getEntityManager().createNativeQuery ("SELECT r FROM Reservation AS r WHERE r.date_debut <=: d ");
        req=req.setParameter("d",d);
       Collection<Reservation> col = req.getResultList();
        return col; }
    
    
    
}

    
    







    
    