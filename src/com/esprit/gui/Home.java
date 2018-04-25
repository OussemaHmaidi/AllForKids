/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.Entite.Parents;

/**
 *
 * @author ousse
 */
public class Home {
    private Form f;
    public Home(Parents p,Resources res) {
        f = new Form("All 4 Kids");
        
        ////////////////////tool bar/////////////////////
        Toolbar tb = f.getToolbar();
        Image img = res.getImage("family all4kids.png");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("couverture");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        tb.addComponentToSideMenu(LayeredLayout.encloseIn(sl,FlowLayout.encloseCenterBottom(
                        new Label(res.getImage("apple.png"), "PictureWhiteBackgrond"))));
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> f.show());
        tb.addMaterialCommandToSideMenu("Etre parent", FontImage.MATERIAL_SETTINGS, e ->  {Home h=new Home(p,res);h.getF().show();});
        tb.addMaterialCommandToSideMenu("Produits", FontImage.MATERIAL_SETTINGS, e ->  f.show());
        tb.addMaterialCommandToSideMenu("Loisirs", FontImage.MATERIAL_SETTINGS, e ->  f.show());
        tb.addMaterialCommandToSideMenu("Sante", FontImage.MATERIAL_LOCAL_HOSPITAL, e ->  f.show());
        tb.addMaterialCommandToSideMenu("Babysitter", FontImage.MATERIAL_PEOPLE, e ->  f.show());
        tb.addMaterialCommandToSideMenu("Exit", FontImage.MATERIAL_EXIT_TO_APP, e ->  Display.getInstance().exitApplication());
        tb.addCommandToOverflowMenu("Paramètres du compte", null, 
             (e)->{});      
        tb.addCommandToOverflowMenu("Déconnecter", null, 
             (e)->{LoginForm h=new LoginForm(res);h.getF().show();});
        ////////////////////tool bar/////////////////////
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
}
