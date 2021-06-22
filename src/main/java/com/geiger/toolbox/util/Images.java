package com.geiger.toolbox.util;

import totalcross.io.IOException;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;



public class Images {
    // public static Image geiger_logo;
    // public static Image nav_icon, scan_icon, phishing_icon, risk_indicator;
    private Image imagePath;


    public Images(String path){
        try{
            this.imagePath = new Image(path);
            // nav_icon= new Image("images/menu_icon.png");
            // scan_icon = new Image("images/scan_btn2.png");
            // phishing_icon = new Image("images/phishing.png");
            // risk_indicator = new Image("images/indicator.png");

        }
        catch( IOException | ImageException e){
            e.printStackTrace();

        }
    }
    public Image getImage(){
        return imagePath;
    }
}
