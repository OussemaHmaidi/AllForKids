/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ousse
 */
@Entity
@Table(name = "fos_message_messages")
@NamedQueries({
    @NamedQuery(name = "FosMessageMessages.findAll", query = "SELECT f FROM FosMessageMessages f")})
public class FosMessageMessages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "body")
    private String body;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(mappedBy = "messageId")
    private Collection<FosMessageMessagesPersons> fosMessageMessagesPersonsCollection;
    @JoinColumn(name = "conversation_id", referencedColumnName = "id")
    @ManyToOne
    private FosMessageConversations conversationId;
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    @ManyToOne
    private FosUser senderId;

    public FosMessageMessages() {
    }

    public FosMessageMessages(Integer id) {
        this.id = id;
    }

    public FosMessageMessages(Integer id, String body, Date date) {
        this.id = id;
        this.body = body;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<FosMessageMessagesPersons> getFosMessageMessagesPersonsCollection() {
        return fosMessageMessagesPersonsCollection;
    }

    public void setFosMessageMessagesPersonsCollection(Collection<FosMessageMessagesPersons> fosMessageMessagesPersonsCollection) {
        this.fosMessageMessagesPersonsCollection = fosMessageMessagesPersonsCollection;
    }

    public FosMessageConversations getConversationId() {
        return conversationId;
    }

    public void setConversationId(FosMessageConversations conversationId) {
        this.conversationId = conversationId;
    }

    public FosUser getSenderId() {
        return senderId;
    }

    public void setSenderId(FosUser senderId) {
        this.senderId = senderId;
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
        if (!(object instanceof FosMessageMessages)) {
            return false;
        }
        FosMessageMessages other = (FosMessageMessages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esprit.Entite.FosMessageMessages[ id=" + id + " ]";
    }
    
}
