package com.geiger.toolbox.ui.screens;

import com.geiger.toolbox.ui.BaseScreen;
import com.geiger.toolbox.ui.components.CardRecommendation;
import com.geiger.toolbox.ui.components.CardThreat;
import com.geiger.toolbox.ui.components.TopContainer;
import com.geiger.toolbox.util.Images;
import com.geiger.toolbox.util.MaterialConstants;

import totalcross.ui.Container;
import totalcross.ui.ScrollContainer;
import totalcross.util.UnitsConverter;

public class InitialScreen extends BaseScreen {
    private int gap = MaterialConstants.BORDER_SPACING;
        
    @Override
    public void onContent(ScrollContainer content) {
        Container container = new ScanRiskScreen();
        int space = UnitsConverter.toPixels(DP + 10);
       
        content.add(new TopContainer(container), LEFT + MaterialConstants.BORDER_SPACING, AFTER, FILL - MaterialConstants.BORDER_SPACING, PARENTSIZE - 30);
        content.add(new CardThreat("Phishing", new Images("images/phishing.png"), 80, "High", new RecommendationScreen("Phishing")), LEFT + gap, AFTER + space, 
            FILL - MaterialConstants.BORDER_SPACING, 130+ DP);
        // content.add(new CardThreat("Malware", new Images("images/malware.png"), 40, "Low", new RecommendationScreen("Malware")), LEFT + gap, AFTER + space, 
        //     FILL - MaterialConstants.BORDER_SPACING, 130+ DP);
        // content.add(new CardThreat("Spam", new Images("images/spam.png"), 55, "Medium", new RecommendationScreen("Spam")), LEFT + gap, AFTER + space, 
        //     FILL - MaterialConstants.BORDER_SPACING, 130+ DP);
        // content.add(new CardThreat("Web Attack", new Images("images/web_attack.png"), 90, "High", new RecommendationScreen("Web Attack")), LEFT + gap, AFTER + space,
        //     FILL - MaterialConstants.BORDER_SPACING, 130+ DP);
    }
    
}
