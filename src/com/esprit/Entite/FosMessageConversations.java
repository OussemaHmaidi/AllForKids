/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ousse
 */
@Entity
@Table(name = "fos_message_conversations")
@NamedQueries({
    @NamedQuery(name = "FosMessageConversations.findAll", query = "SELECT f FROM FosMessageConversations f")})
public class FosMessageConversations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "subject")
    private String subject;
    @OneToMany(mappedBy = "conversationId")
    private Collection<FosMessageMessages> fosMessageMessagesCollection;
    @OneToMany(mappedBy = "conversationId")
    private Collection<FosMessageConversationsPersons> fosMessageConversationsPersonsCollection;

    public FosMessageConversations() {
    }

    public FosMessageConversations(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Collection<FosMessageMessages> getFosMessageMessagesCollection() {
        return fosMessageMessagesCollection;
    }

    public void setFosMessageMessagesCollection(Collection<FosMessageMessages> fosMessageMessagesCollection) {
        this.fosMessageMessagesCollection = fosMessageMessagesCollection;
    }

    public Collection<FosMessageConversationsPersons> getFosMessageConversationsPersonsCollection() {
        return fosMessageConversationsPersonsCollection;
    }

    public void setFosMessageConversationsPersonsCollection(Collection<FosMessageConversationsPersons> fosMessageConversationsPersonsCollection) {
        this.fosMessageConversationsPersonsCollection = fosMessageConversationsPersonsCollection;
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
        if (!(object instanceof FosMessageConversations)) {
            return false;
        }
        FosMessageConversations other = (FosMessageConversations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esprit.Entite.FosMessageConversations[ id=" + id + " ]";
    }
    
}
