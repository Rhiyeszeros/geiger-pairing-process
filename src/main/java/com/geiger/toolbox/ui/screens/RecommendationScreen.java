package com.geiger.toolbox.ui.screens;

import java.io.IOException;

import com.geiger.toolbox.ui.BaseScreen;
import com.geiger.toolbox.ui.screens.DeviceRecommendationScreen;
import com.geiger.toolbox.ui.components.CardRecommendation;
import com.geiger.toolbox.ui.components.TopContainer;
import com.geiger.toolbox.ui.components.TopRecommendationContainer;
import com.geiger.toolbox.util.Colors;
import com.geiger.toolbox.util.MaterialConstants;


import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;
import totalcross.ui.TabbedContainer;
import totalcross.ui.Window;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;


public class RecommendationScreen extends BaseScreen{
    private String threatTitle;

    public RecommendationScreen(String threatTitle){
        this.threatTitle = threatTitle;
    }

    @Override
    public void onContent(ScrollContainer content) {
        Container spacing = new Container();
        content.add( new TopRecommendationContainer("images/tabUserActive.png", "images/tabDeviceInactive.png", new DeviceRecommendationScreen(threatTitle), threatTitle), LEFT + MaterialConstants.COMPONENT_SPACING, TOP, FILL, PARENTSIZE + 30);
        content.add(new CardRecommendation(), LEFT + MaterialConstants.BORDER_SPACING, AFTER+ MaterialConstants.COMPONENT_SPACING, FILL - MaterialConstants.BORDER_SPACING, PARENTSIZE);
        //content.add(new CardRecommendation(), LEFT + MaterialConstants.BORDER_SPACING, AFTER+ MaterialConstants.COMPONENT_SPACING, FILL - MaterialConstants.BORDER_SPACING, PARENTSIZE);
     
       
    }

}








/* 
public class RecommendationScreen extends Container{
        TabbedContainer tab;
        Container userRecommendationsContainer;
        Container deviceRecommendationsContainer;
        Label testLabelUser;
        Label testLabelDevice;
        private int gap = (int) (Settings.screenDensity * 10);

        final int DP_10 = (int) (Settings.screenDensity * 2);
        
        public void initUI(){

            try{
                int space = UnitsConverter.toPixels(DP + 10);
        
                String[] tabCaptions = {"User", "Device"};
                Image[] icons = { new Image("images/user.png"), new Image("images/device.png")};

                Container spacing = new Container();
                add(spacing, LEFT, TOP, FILL, PARENTSIZE);
            
                testLabelDevice = new Label("Device Recommendations");
                
                
                final TabbedContainer tabs = new TabbedContainer(tabCaptions);
                tabs.setIcons(icons);
                tabs.pressedColor = Colors.PRIMARY;
                tabs.allSameWidth = true;
                tabs.extraTabHeight = fmH * 2;
                tabs.borderColor = Colors.WHITE;
                add(tabs, LEFT, TOP - 2, FILL, PARENTSIZE);
                tabs.transparentBackground = true;

                tabs.getContainer(0).add(new TopContainer(), LEFT, TOP, PARENTSIZE, PARENTSIZE + 40);

                tabs.getContainer(0).add(new CardRecommendation(), LEFT, AFTER + 2, FILL, PARENTSIZE + UnitsConverter.toPixels(DP + 90));
                
                tabs.getContainer(1).add(testLabelDevice, LEFT, CENTER);
                

            }

            catch(ImageException | IOException e){
                e.printStackTrace();
            }
        }
        


    }

*/
