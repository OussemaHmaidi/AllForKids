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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ousse
 */
@Entity
@Table(name = "fos_message_conversations_persons")
@NamedQueries({
    @NamedQuery(name = "FosMessageConversationsPersons.findAll", query = "SELECT f FROM FosMessageConversationsPersons f")})
public class FosMessageConversationsPersons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinTable(name = "fos_message_conversations_persons_tags", joinColumns = {
        @JoinColumn(name = "conversation_person_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tag_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<FosMessageTags> fosMessageTagsCollection;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne
    private FosUser personId;
    @JoinColumn(name = "conversation_id", referencedColumnName = "id")
    @ManyToOne
    private FosMessageConversations conversationId;

    public FosMessageConversationsPersons() {
    }

    public FosMessageConversationsPersons(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<FosMessageTags> getFosMessageTagsCollection() {
        return fosMessageTagsCollection;
    }

    public void setFosMessageTagsCollection(Collection<FosMessageTags> fosMessageTagsCollection) {
        this.fosMessageTagsCollection = fosMessageTagsCollection;
    }

    public FosUser getPersonId() {
        return personId;
    }

    public void setPersonId(FosUser personId) {
        this.personId = personId;
    }

    public FosMessageConversations getConversationId() {
        return conversationId;
    }

    public void setConversationId(FosMessageConversations conversationId) {
        this.conversationId = conversationId;
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
        if (!(object instanceof FosMessageConversationsPersons)) {
            return false;
        }
        FosMessageConversationsPersons other = (FosMessageConversationsPersons) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esprit.Entite.FosMessageConversationsPersons[ id=" + id + " ]";
    }
    
}
