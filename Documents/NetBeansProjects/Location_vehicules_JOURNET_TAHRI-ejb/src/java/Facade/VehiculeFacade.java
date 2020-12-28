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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author journ
 */
@Stateless
public class VehiculeFacade extends AbstractFacade<Vehicule> implements VehiculeFacadeLocal {

    @PersistenceContext(unitName = "Location_vehicules_JOURNET_TAHRI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculeFacade() {
        super(Vehicule.class);
    }

    @Override
    public void CreerVehicule(String num, String marque, String modele, Type type, double prixj, double prixs, Double nbkm, int caut) {
        Vehicule v = new Vehicule();
        v.setNum_véhicule(num);
        v.setMarque(marque);
        v.setModele(modele);
        v.setType(type);
        v.setPrix_jour(prixj);
        v.setPrix_semaine(prixs);
        v.setNb_km(nbkm);
        v.setCaution(caut);
        getEntityManager().persist(v);
    }

    @Override
    public Vehicule RechercherVehicule(String num) {
        Vehicule v = null;
        List<Vehicule> result;
        Query req = getEntityManager().createQuery("SELECT v FROM Vehicule AS v WHERE v.Num_véhicule=:nu ");
        req = req.setParameter("nu", num);
        result = req.getResultList();
        if (result.size() == 1) {
            v = (Vehicule) result.get(0);
        }
        return v;
    }

    @Override
    public java.util.Collection<Vehicule> RechercheVehiculeLibre() {
        String statut = "disponible";
        Query req = getEntityManager().createQuery("SELECT v FROM Vehicule AS v WHERE v.leStatut=:st ");
        req = req.setParameter("st", statut);
        Collection<Vehicule> col = req.getResultList();
        return col;
    }

    @Override
    public java.util.Collection<Vehicule> RechercheTypeVehicule(String type) {
        Query req = getEntityManager().createQuery("SELECT v FROM Vehicule AS v WHERE v.Type=:ty");
        req = req.setParameter("ty", type);
        Collection<Vehicule> col = req.getResultList();
        return col;
    }

    @Override
    public Double NombredeKm(Vehicule v) {
        Double nbkm = v.getNb_km();
        return nbkm;

    }

    @Override
    public java.util.Collection<Vehicule> RechercheReparationRevision(Vehicule v) {
        String Revision = "en revision";
        String Reparation = "en reparation";
        Query req = getEntityManager().createQuery("SELECT v FROM Vehicule AS v WHERE v.leStatut.Libelle=:rep OR v.leStatut.Libelle=:rev ");
        req = req.setParameter("rep", Reparation);
        req = req.setParameter("rev", Revision);
        Collection<Vehicule> col = req.getResultList();
        return col;
    }
    

}
