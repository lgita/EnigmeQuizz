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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author journ
 */
@Stateless
public class FraisFacade extends AbstractFacade<Frais> implements FraisFacadeLocal {
    @PersistenceContext(unitName = "Location_vehicules_JOURNET_TAHRI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FraisFacade() {
        super(Frais.class);
    }

    @Override
    public void CreationFrais(String num, Type_frais type, Double mtfrais, Location location, Reservation reservation) {
    Frais f = new Frais ();
    f.setNum_frais(num);
    f.setType_frais(type);
    f.setMontant_frais(mtfrais);
    f.setLalocation(location);
    f.setLareservation(reservation);
            }
    
    
    
}
