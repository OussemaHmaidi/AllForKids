/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.Service.ParentsService;

/**
 *
 * @author ousse
 */
public class LoginForm {
    Form f;
    TextField tusername;
    TextField tpassword;
    Button btnlogin,btnnouveau;
    Container cnt;

    public LoginForm(Resources res) {
        f = new Form("LOGIN", new BorderLayout());
        f.setUIID("CreerCompteForm");
        cnt=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt.setUIID("LoginFormContainer");
        ((BorderLayout)f.getLayout()).setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER);
        tusername = new TextField("", "Login", 20, TextField.ANY);
        tpassword = new TextField("", "Password", 20, TextField.PASSWORD);
        btnlogin = new Button("Connexion");
        btnnouveau=new Button("Créer compte");
        cnt.add(tusername).add(tpassword).add(btnlogin).add(btnnouveau);
        f.add(BorderLayout.CENTER,cnt);
        
        btnlogin.addActionListener((e) -> {
            //ser.ajoutTask(t);
            ParentsService ser = new ParentsService();
            ser.login(tusername.getText(), tpassword.getText(),res);
        });
        btnnouveau.addActionListener((e)->{
            CreerCompte a=new CreerCompte(res);
            a.getF().show();
        });
        
        
        
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
}
