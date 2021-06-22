package com.geiger.toolbox.ui.components;

import com.geiger.toolbox.ui.screens.RecommendationScreen;
import com.geiger.toolbox.ui.screens.ScanRiskScreen;
import com.geiger.toolbox.util.Colors;
import com.geiger.toolbox.util.Fonts;
import com.geiger.toolbox.util.Images;
import com.geiger.toolbox.util.MaterialConstants;

import ch.fhnw.geiger.localstorage.db.GenericController;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.FloatingActionButton;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.ScrollContainer;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;


public class TopContainer extends Container{

    private Container component;
    private int gap = MaterialConstants.BORDER_SPACING;

    public TopContainer(Container component){
        this.component = component;
    }
  
    public void initUI(){
        int space = UnitsConverter.toPixels(DP + 10);
        try{
            int imageSize = UnitsConverter.toPixels(DP + 130);
            ScrollContainer scrollContainer = new ScrollContainer(false, true); 

            Label text = new Label("Your Risk Score:");
            add(text,CENTER, TOP +  MaterialConstants.COMPONENT_SPACING);
    
            Images scanRiskImage = new Images("images/scanRiskButton.png");
    
            Label score = new Label("73.5");
            score.setForeColor(Colors.SCORE_COLOR);
            score.setFont(Fonts.nunitoBoldScoreSize);
            add(score, CENTER, AFTER + MaterialConstants.COMPONENT_SPACING);
    
            ImageControl scanRiskImageControl= new ImageControl( scanRiskImage.getImage()
                            .hwScaledFixedAspectRatio(imageSize, true));
                            
            scanRiskImageControl.centerImage = true;
            scanRiskImageControl.scaleToFit = true;
            scanRiskImageControl.transparentBackground = true;
            

            FloatingActionButton scanBtn = new FloatingActionButton(scanRiskImageControl.getImage());
            scanBtn.setIconSize(UnitsConverter.toPixels(DP+95));
            add(scanBtn, CENTER, AFTER + MaterialConstants.COMPONENT_SPACING);
            
            scanBtn.addPressListener((e) -> {    
                if (component != null){
                    
                        
                } 
                else{
                    System.out.println("Just Scanning");
                    scrollContainer.add(score, CENTER, AFTER);
                    scrollContainer.add(new CardThreat("Phishing", new Images("images/phishing.png"), 80, "High", new RecommendationScreen("Phishing")), LEFT + gap, AFTER + space, 
                    FILL - MaterialConstants.BORDER_SPACING, 130+ DP);
                }
			    
             });


            Button btnEmployee = new Button("Device Risks", Button.BORDER_OUTLINED);
            btnEmployee.setBackForeColors(Colors.PRIMARY, Colors.TEXT_ON_P_LIGHT);
            add(btnEmployee, LEFT, AFTER + MaterialConstants.COMPONENT_SPACING);
    
            Button btnDevice= new Button("Employee Risks", Button.BORDER_OUTLINED);
            btnDevice.setBackForeColors(Colors.PRIMARY, Colors.TEXT_ON_P_LIGHT);
            add(btnDevice, RIGHT, CENTER_OF);
    
            Label currentThreatText= new Label("Current Threats:");
            currentThreatText.setFont(Fonts.nunitoBoldFont);
            add(currentThreatText,LEFT, AFTER + MaterialConstants.BORDER_SPACING);
    
            Label threatRiskText = new Label("Threat Risk");
            add(threatRiskText, RIGHT, CENTER_OF);
            
            add(scrollContainer, CENTER, AFTER, PARENTSIZE, FILL);

        }
        catch(ImageException e){
            e.printStackTrace();
        }
        
    }

}
// Storage connect = new Storage();
// connect.connectToDatabase();
// StorageController storageController = connect.getController();
// storageController.add(new NodeImpl("testing123"));