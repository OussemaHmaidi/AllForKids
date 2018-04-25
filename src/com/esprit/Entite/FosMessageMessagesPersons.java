/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ousse
 */
@Entity
@Table(name = "fos_message_messages_persons")
@NamedQueries({
    @NamedQuery(name = "FosMessageMessagesPersons.findAll", query = "SELECT f FROM FosMessageMessagesPersons f")})
public class FosMessageMessagesPersons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "read_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne
    private FosUser personId;
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    @ManyToOne
    private FosMessageMessages messageId;

    public FosMessageMessagesPersons() {
    }

    public FosMessageMessagesPersons(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public FosUser getPersonId() {
        return personId;
    }

    public void setPersonId(FosUser personId) {
        this.personId = personId;
    }

    public FosMessageMessages getMessageId() {
        return messageId;
    }

    public void setMessageId(FosMessageMessages messageId) {
        this.messageId = messageId;
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
        if (!(object instanceof FosMessageMessagesPersons)) {
            return false;
        }
        FosMessageMessagesPersons other = (FosMessageMessagesPersons) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esprit.Entite.FosMessageMessagesPersons[ id=" + id + " ]";
    }
    
}
