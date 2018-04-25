/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ousse
 */
@Entity
@Table(name = "enfant_vaccin")
@NamedQueries({
    @NamedQuery(name = "EnfantVaccin.findAll", query = "SELECT e FROM EnfantVaccin e")})
public class EnfantVaccin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "statut")
    private Integer statut;
    @JoinColumn(name = "enfant", referencedColumnName = "id")
    @ManyToOne
    private Enfant enfant;
    @JoinColumn(name = "vaccin", referencedColumnName = "id")
    @ManyToOne
    private Vaccin vaccin;

    public EnfantVaccin() {
    }

    public EnfantVaccin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public Vaccin getVaccin() {
        return vaccin;
    }

    public void setVaccin(Vaccin vaccin) {
        this.vaccin = vaccin;
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
        if (!(object instanceof EnfantVaccin)) {
            return false;
        }
        EnfantVaccin other = (EnfantVaccin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esprit.Entite.EnfantVaccin[ id=" + id + " ]";
    }
    
}
