package com.geiger.toolbox.ui.screens;
import com.geiger.toolbox.ui.BaseScreen;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;

public class CompareRiskScreen extends BaseScreen{
  

    
    @Override
    public void onContent(ScrollContainer content){
        Label lbCompareRisk = new Label("Compare your risk score with others");
        content.add(lbCompareRisk, CENTER, CENTER);
    }
    
}
