package com.geiger.toolbox.ui.components;

import com.geiger.toolbox.util.MaterialConstants;

import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MaterialWindow;
import totalcross.ui.Presenter;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public class TopDeviceRecommendationContainer extends Container {
    String imagePathUser, imagePathDevice, threatTitle;
    Container screen;
    Button btnUserActive, btnDeviceInactive;

    public TopDeviceRecommendationContainer(String imagePathUser, String imagePathDevice,Container screen,String threatTitle){
        this.imagePathUser = imagePathUser;
        this.imagePathDevice = imagePathDevice;
        this.screen = screen;
        this.threatTitle = threatTitle;
    }

    public void initUI() {
        Container topContainer = new Container();
        //content.add(topContainer, LEFT, TOP, PREFERRED, PREFERRED);
        Label threatName = new Label("Phishing Risk");
        Label userName = new Label("Daniel Thomas");
        IndicatorGauge indicatorGauge = new IndicatorGauge(40);
        Label riskLevel = new Label("High");

        int imageSize = UnitsConverter.toPixels(DP + 40);

        try {
            Image userActive = new Image(imagePathUser);
            ImageControl userImageControl = new ImageControl(userActive.hwScaledFixedAspectRatio(imageSize, true));
            userImageControl.centerImage = true;
            userImageControl.scaleToFit = true;

            Image deviceInactive = new Image(imagePathDevice);
            ImageControl deviceImageControl = new ImageControl(deviceInactive.hwScaledFixedAspectRatio(imageSize, true));
            userImageControl.centerImage = true;
            userImageControl.scaleToFit = true;
            
            
            btnUserActive = new Button(userImageControl.getImage());
            
            btnDeviceInactive = new Button(deviceImageControl.getImage());
            
            btnUserActive.addPressListener( (e) -> {
                MaterialWindow materialWindow = new MaterialWindow(threatTitle, false, new Presenter<Container>() {  
                    @Override
                    public Container getView(){
                        return screen;
                    }
                });
                materialWindow.popup();
            });

    
            add(btnUserActive, LEFT + MaterialConstants.BORDER_SPACING, TOP - UnitsConverter.toPixels(DP + 5));
            add(btnDeviceInactive, RIGHT - MaterialConstants.BORDER_SPACING, CENTER_OF);
            add(indicatorGauge, CENTER,  AFTER + MaterialConstants.BORDER_SPACING, PARENTSIZE + 25, PARENTSIZE+ 50);
            add(riskLevel,CENTER + UnitsConverter.toPixels(DP + 40), AFTER - UnitsConverter.toPixels(DP + 20));

            resizeHeight();



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ImageException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
