/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import com.esprit.Entite.Babysitter;
import com.esprit.Entite.Parents;
import com.esprit.gui.Home;
import com.esprit.gui.LoginForm;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author ousse
 */
public class ParentsService {
        public void ajoutParents(Parents p,Resources res) {
        ConnectionRequest con = new ConnectionRequest();
        if (p.getEmail()=="" ||p.getEmail()==null){
            Dialog.show("Erreur", "Vérifier votre email", "ok", null);
            return;
        }
        String Url = "http://127.0.0.1/pidevv/web/ajout_utilisateur?email=" + p.getEmail() +
                "&username=" + p.getUsername() +
                "&password=" + p.getPassword()+
                "&nom=" + p.getNom()+
                "&prenom=" + p.getPrenom()+
                "&dn="+ new SimpleDateFormat("dd-MM-yyyy").format(p.getDateNaissance()) +
                "&cin=" + p.getCin()+
                "&tel=" + p.getTel()+
                "&adresse=" + p.getAdresse();
            System.out.println(Url);
        Dialog.show("Succées", Url, "ok", null);
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            
//            if (str.trim().equalsIgnoreCase("OK")) {
//                Dialog.show("Succées", "Votre compte a été crée avec succées", "ok", null);
//            }
//            else{
//                Dialog.show("Erreur", "Verifier vos paramètres", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        LoginForm h = new LoginForm(res);
            h.getF().show();
    }

        public void ajoutBabysitter(Babysitter p,Resources res) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/pidevv/web/ajout_utilisateur?email=" + p.getEmail() +
                "&username=" + p.getUsername() +
                "&password=" + p.getPassword()+
                "&nom=" + p.getNom()+
                "&prenom=" + p.getPrenom()+
                "&dn="+ new SimpleDateFormat("dd-MM-yyyy").format(p.getDateNaissance()) +
                "&cin=" + p.getCin()+
                "&tel=" + p.getTel()+
                "&adresse=" + p.getAdresse()+
                "&babysitter=babysitter";
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        LoginForm h = new LoginForm(res);
            h.getF().show();
    }
        
        
        
        public void login(String username,String password,Resources res) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/pidevv/web/loginmobile/" + username +"/" + password;
        con.setUrl(Url);

        Babysitter b=new Babysitter();
        Parents p = new Parents();
        con.addResponseListener((e) -> {
            try {
                String str = new String(con.getResponseData());
                System.out.println(str);
                JSONParser j = new JSONParser();
                Map<String, Object> user = j.parseJSON(new CharArrayReader(str.toCharArray()));
                String id = user.get("roles").toString();
                if(id.toLowerCase().indexOf("role_parent")>-1){
//                    p.setId(Integer.parseInt(user.get("id").toString().trim()));
                    float x = Float.parseFloat(user.get("id").toString());
                    p.setId((int) x);
                    p.setNom(user.get("nom").toString().trim());
                    p.setPrenom(user.get("prenom").toString().trim());
                    String dn=str.substring(str.indexOf("\"timestamp\":")+12
                            ,str.indexOf("},\"cin\":"));
                    Long date=Long.parseLong(dn);
                    Date d=new Date(date * 1000);
                    p.setDateNaissance(d);
                    if(user.get("cin").toString().trim()!=null){
                    p.setCin(user.get("cin").toString().trim());}
                    p.setTel(user.get("tel").toString().trim());
                    p.setAdresse(user.get("adresse").toString().trim());
                    p.setUsername(user.get("username").toString().trim());
                    p.setEmail(user.get("email").toString().trim());
                    Home h=new Home(p,res);
                    h.getF().show();
                }else if(id.toLowerCase().indexOf("role_babysitter")>-1){
                    Dialog.show("Succées", "babysitter", "ok", null);
                }else{
                    Dialog.show("Succées", "pas autorisé", "ok", null);
                }
                
                //e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                //e.setEtat(obj.get("state").toString());
                //e.setNom(obj.get("name").toString());
                //System.out.println(e);
                //listEtudiants.add(e);

            
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

}
