/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author tahri
 */
@Entity
public class Statut implements Serializable {
    
        private String detailStatut;


        
    public String getDetailStatut() {
        return detailStatut;
    }

    /**
     * Set the value of detailStatut
     *
     * @param detailStatut new value of detailStatut
     */
    public void setDetailStatut(String detailStatut) {
        this.detailStatut = detailStatut;
    }


    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @OneToOne(mappedBy = "leStatut")
    private Vehicule vehicule;



    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateFin;

    /**
     * Get the value of DateFin
     *
     * @return the value of DateFin
     */
    public Date getDateFin() {
        return DateFin;
    }

    /**
     * Set the value of DateFin
     *
     * @param DateFin new value of DateFin
     */
    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

     @Temporal(javax.persistence.TemporalType.DATE)
     private Date DateDebut;

    /**
     * Get the value of DateDebut
     *
     * @return the value of DateDebut
     */
    public Date getDateDebut() {
        return DateDebut;
    }

    /**
     * Set the value of DateDebut
     *
     * @param DateDebut new value of DateDebut
     */
    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    

    /**
     * Set the value of Entretien
     *
     * @param Entretien new value of Entretien
     */




        @Column(nullable = false)
    private String Libelle;

    /**
     * Get the value of Libelle
     *
     * @return the value of Libelle
     */
    public String getLibelle() {
        return Libelle;
    }

    /**
     * Set the value of Libelle
     *
     * @param Libelle new value of Libelle
     */
    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }
    @Column(unique = true,nullable = false)
    private String Num_statut;

    /**
     * Get the value of Num_statut
     *
     * @return the value of Num_statut
     */
    public String getNum_statut() {
        return Num_statut;
    }

    /**
     * Set the value of Num_statut
     *
     * @param Num_statut new value of Num_statut
     */
    public void setNum_statut(String Num_statut) {
        this.Num_statut = Num_statut;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statut)) {
            return false;
        }
        Statut other = (Statut) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Statut[ id=" + id + " ]";
    }
    
}
