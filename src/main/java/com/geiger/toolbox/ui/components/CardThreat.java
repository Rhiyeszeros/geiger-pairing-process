package com.geiger.toolbox.ui.components;

import com.geiger.toolbox.ui.screens.RecommendationScreen;
import com.geiger.toolbox.util.Colors;
import com.geiger.toolbox.util.DatabaseManager;
import com.geiger.toolbox.util.Fonts;
import com.geiger.toolbox.util.Images;
import com.geiger.toolbox.util.MaterialConstants;

import ch.fhnw.geiger.localstorage.StorageController;
import ch.fhnw.geiger.localstorage.StorageException;
import ch.fhnw.geiger.localstorage.db.data.Node;
import ch.fhnw.geiger.localstorage.db.data.NodeImpl;
import ch.fhnw.geiger.localstorage.db.data.NodeValue;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.MaterialWindow;
import totalcross.ui.Presenter;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;



public class CardThreat extends Container{;

    private Label threatText;
    private ImageControl threatIcon;
    private IndicatorGauge threatIndicator;
    private Label riskText;
    private Button btnImprove;
   

    String threatTitle;
    Images riskIcon;
    int indicatorValue;
    String riskLevel;
    Container userRecommendationScreen;
   
    public CardThreat(String threatTitle, Images riskIcon, int indicatorValue, String riskLevel, Container recommendationScreen){
            this.threatTitle = threatTitle;
            this.riskIcon = riskIcon;
            this.indicatorValue = indicatorValue;
            this.riskLevel = riskLevel;
            this.userRecommendationScreen =  recommendationScreen;
            
    }

    public CardThreat(String title, Images images, Object object, Object object2,
            RecommendationScreen recommendationScreen, int i, int j, int k, int l) {
    }

    public void initUI(){

        try{
            
            int textGap = UnitsConverter.toPixels(DP + 4);
            int gap = UnitsConverter.toPixels(DP + 32);
            int imageSize = UnitsConverter.toPixels(DP + 110);
            final int margin = UnitsConverter.toPixels(DP + 6);

            threatIcon = new ImageControl( riskIcon.getImage()
                        .hwScaledFixedAspectRatio(imageSize, true));
            
            threatIcon.centerImage = true;
            threatIcon.transparentBackground = true;
            threatIcon.scaleToFit = true;

            threatText = new Label(threatTitle);
            threatText.autoSplit = true;
            threatText.setFont(Fonts.nunitoBoldFont);
            threatText.setForeColor(Colors.TEXT_BLACK);
           

            threatIndicator = new IndicatorGauge(indicatorValue);
            
            riskText = new Label(riskLevel);
            riskText.setFont(Fonts.nunitoRiskLevel);
            riskText.setForeColor(Colors.S_LIGHT);

            btnImprove = new Button("Improve", Button.BORDER_ROUND);
            btnImprove.setBackColor(Colors.PRIMARY);
            btnImprove.setForeColor(Colors.TEXT_ON_P);
            btnImprove.addPressListener(
                (e) -> {
                    try{
                        Node node;
                        NodeValue nodeValue;

                        DatabaseManager databaseManager = new DatabaseManager();
                        databaseManager.connectToDatabase();
                        StorageController storageController = databaseManager.getController();

                       
                        node = storageController.get(":Local");
                        nodeValue = node.getValue("currentUser");

                            MessageBox mb = new MessageBox(nodeValue.toString(), node.toString());
                            mb.popup();
                       
                            
                    }
                        catch(StorageException ee){
                            ee.printStackTrace();
                        }

                    MaterialWindow materialWindow = new MaterialWindow(threatTitle, false, new Presenter<Container>() {  
                        @Override
                        public Container getView(){
                            return userRecommendationScreen;
                        }
                    });
                    materialWindow.popup();
                });
            
            

            add(threatText, LEFT + textGap, TOP + margin);
            add(threatIcon, CENTER - MaterialConstants.BORDER_SPACING, CENTER, PARENTSIZE, PARENTSIZE);
            add(threatIndicator, RIGHT, TOP + UnitsConverter.toPixels(DP + 10),
            PARENTSIZE + 50, PARENTSIZE + 50);
            add(riskText, RIGHT - MaterialConstants.TABS_HEIGHT, AFTER - UnitsConverter.toPixels(DP + 5));
            add(btnImprove, RIGHT - MaterialConstants.BORDER_SPACING, BOTTOM - UnitsConverter.toPixels(DP + 5));
            
            
            
            setBorderStyle(BORDER_LOWERED);
            // setBorderRadius(28);
        }
        catch(ImageException e){
            e.printStackTrace();
        }
    }
}
