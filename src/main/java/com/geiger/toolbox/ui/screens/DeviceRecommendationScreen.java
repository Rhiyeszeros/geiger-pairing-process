package com.geiger.toolbox.ui.screens;

import com.geiger.toolbox.ui.BaseScreen;
import com.geiger.toolbox.ui.components.CardRecommendation;
import com.geiger.toolbox.ui.components.TopDeviceRecommendationContainer;
import com.geiger.toolbox.ui.components.TopRecommendationContainer;
import com.geiger.toolbox.util.MaterialConstants;

import totalcross.ui.Container;
import totalcross.ui.ScrollContainer;

public class DeviceRecommendationScreen extends BaseScreen{
    private String threatTitle;

    DeviceRecommendationScreen(String threatTitle){
        this.threatTitle = threatTitle; 

    }


    @Override
    public void onContent(ScrollContainer content) {
        Container spacing = new Container();
        content.add( new TopDeviceRecommendationContainer("images/tabUserInactive.png", "images/tabDeviceActive.png", new RecommendationScreen(threatTitle), threatTitle), LEFT + MaterialConstants.COMPONENT_SPACING, TOP, FILL, PARENTSIZE + 30);
        content.add(new CardRecommendation(), LEFT + MaterialConstants.BORDER_SPACING, AFTER+ MaterialConstants.COMPONENT_SPACING, FILL - MaterialConstants.BORDER_SPACING, PARENTSIZE);
        //content.add(new CardRecommendation(), LEFT + MaterialConstants.BORDER_SPACING, AFTER+ MaterialConstants.COMP

    }

   
}