/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.esprit.Entite.Babysitter;
import com.esprit.Entite.Parents;
import com.esprit.Service.ParentsService;

/**
 *
 * @author ousse
 */
public class CreerCompte {
    private Resources theme;
    Form f;
    Container cnt;
    TextField temail;
    TextField tusername;
    TextField tpassword;
    TextField tnom;
    TextField tprenom;
    Picker dn;
    TextField tcin;
    TextField ttel;
    Picker adresse;
    CheckBox babysitter;
    Button btnconfirmer;

    public CreerCompte(Resources res) {
        f = new Form("Créer compte");
        f.setUIID("CreerCompteForm");
        temail = new TextField("", "Email:exemple@domain.com", 20, TextField.EMAILADDR);
        tusername = new TextField("", "User Name", 20, TextField.ANY);
        tpassword = new TextField("", "Password", 20, TextField.PASSWORD);
        tnom = new TextField("", "Nom", 20, TextField.ANY);
        tprenom = new TextField("", "Prenom", 20, TextField.ANY);
        dn = new Picker();
        dn.setType(Display.PICKER_TYPE_DATE);
        tcin = new TextField("", "C.I.N", 20, TextField.NUMERIC);
        ttel = new TextField("", "Téléphone", 20, TextField.NUMERIC);
        String[] adresses = { "Ariana", "Ben arous", "Bizerte", "Béja",
        "Gabès","Gafsa","Jendouba","Kairouane","Kasserine","Kébili","La manouba","Le kef","Mahdia","Monastir","Médenine",
        "Nabeul","Sfax","Sidi bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan"
        };
        adresse =new Picker();
        adresse.setStrings(adresses);
        adresse.setSelectedString(adresses[0]);
        babysitter=new CheckBox("Je suis une Babysitter!");
        btnconfirmer=new Button("Confirmer");
        cnt=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt.setUIID("LoginFormContainer");
        cnt.add(temail).add(tusername).add(tpassword)
                .add(tnom).add(tprenom).add(dn)
                .add(tcin).add(ttel).add(adresse)
                .add(babysitter).add(btnconfirmer);
        f.add(cnt);
        btnconfirmer.addActionListener((e) -> {
            if (babysitter.isSelected()){
                ParentsService ser = new ParentsService();
                Babysitter p = new Babysitter();
                p.setEmail(temail.getText());
                p.setUsername(tusername.getText());
                p.setPassword(tpassword.getText());
                p.setNom(tnom.getText());
                p.setPrenom(tprenom.getText());
                p.setDateNaissance(dn.getDate());
                p.setCin(tcin.getText());
                p.setTel(ttel.getText());
                p.setAdresse(adresse.getSelectedString());
                ser.ajoutBabysitter(p,res);
            }else{
                ParentsService ser = new ParentsService();
                Parents p = new Parents();
                p.setEmail(temail.getText());
                p.setUsername(tusername.getText());
                p.setPassword(tpassword.getText());
                p.setNom(tnom.getText());
                p.setPrenom(tprenom.getText());
                p.setDateNaissance(dn.getDate());
                p.setCin(tcin.getText());
                p.setTel(ttel.getText());
                p.setAdresse(adresse.getSelectedString());
                ser.ajoutParents(p,res);
            }
            
            //ser.ajoutTask(t);
        });
        f.getToolbar().addCommandToRightBar("back", /*theme.getImage("back-command.png")*/null, (ev)->{LoginForm h=new LoginForm(res);
          h.getF().show();
          });
    }
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
