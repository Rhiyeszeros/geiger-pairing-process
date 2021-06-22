package com.geiger.toolbox.ui.screens;

import com.geiger.toolbox.ui.BaseScreen;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;

public class SettingsScreen extends BaseScreen{
    
    @Override
    public void onContent(ScrollContainer content){
        Label lbWorkInProgress = new Label("Work in Progress");
        content.add(lbWorkInProgress, CENTER, CENTER);
    }
}