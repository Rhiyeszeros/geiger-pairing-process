package com.geiger.toolbox.ui;

import com.geiger.toolbox.util.Images;

import totalcross.io.IOException;
import totalcross.ui.ImageControl;
import totalcross.ui.Window;
import totalcross.ui.anim.ControlAnimation;
import totalcross.ui.anim.FadeAnimation;

import totalcross.ui.image.ImageException;

public class SplashScreen extends Window {
    public SplashScreen() throws IOException, ImageException{
        
    }
    protected void onPopup(){
		Images background = new Images("images/ic_background.png");
        ImageControl back = new ImageControl(background.getImage());
		back.scaleToFit = true;
		back.centerImage = true;
		back.hwScale = true;
		back.strechImage = true;
		add(back, LEFT, TOP, FILL, FILL);
    
        Images path = new Images("images/logo.png");
        ImageControl logo;
        logo = new ImageControl( path.getImage());
           
        logo.scaleToFit = true;
        logo.centerImage = true;
        logo.transparentBackground = true;
        logo.hwScale = true;
            
        add(logo, CENTER, CENTER, PARENTSIZE, PARENTSIZE);

        FadeAnimation.create(logo, true, null, 3000)
            .then(FadeAnimation.create(logo, false, this::onAnimationFinished, 3000)).start();
    
    }
    public void onAnimationFinished(ControlAnimation anim){
        this.unpop();
    }
}
