package com.geiger.toolbox.ui.screens;

import totalcross.ui.FloatingActionButton;

import com.geiger.toolbox.ui.components.CardThreat;
import com.geiger.toolbox.util.Colors;
import com.geiger.toolbox.util.Fonts;
import com.geiger.toolbox.util.Images;
import com.geiger.toolbox.util.MaterialConstants;

import totalcross.ui.Label;
import totalcross.ui.MainWindow;

import totalcross.json.JSONArray;
import totalcross.json.JSONObject;
import totalcross.notification.Notification;
import totalcross.notification.NotificationManager;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.event.UpdateListener;
import totalcross.ui.ImageControl;
import totalcross.ui.ScrollContainer;

import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public class ScanRiskScreen extends Container {

    int space = UnitsConverter.toPixels(DP + 10);
    private int gap = MaterialConstants.BORDER_SPACING;
    final static int ANIMATION_TIME = 5000;
    int currentAnimationTime = 0;
    int nextStopTime = 0;
    float geigerScore;
    JSONObject threats = new JSONObject();
    JSONObject threatPhishing = new JSONObject();
    JSONObject threatMalware = new JSONObject();
    JSONArray threatTitles;
    JSONArray threatTitleItems;

    int index = 0;
    Label score, textTitle;
    String s;
    ScrollContainer scrollContainer;
    Container topContainer;
    Container spacing = new Container();
    protected boolean allowVerticalScroll = true;
    protected boolean allowHorizontalScroll = false;

    public ScanRiskScreen() {
        populateData();
    }

    @Override
    public void initUI() {

        scrollContainer = new ScrollContainer() {
            @Override
            public void initUI() {
                setScrollBars(allowHorizontalScroll, allowVerticalScroll);
                super.initUI();
            }
        };

        int space = UnitsConverter.toPixels(DP + 10);

        topContainer = new Container();

        try {

            int imageSize = UnitsConverter.toPixels(DP + 130);

            add(scrollContainer, CENTER, AFTER, PARENTSIZE, FILL);

            scrollContainer.add(topContainer, LEFT, AFTER, FILL, PARENTSIZE + 55);

            textTitle = new Label("Start scanning your cyber threats:");
            topContainer.add(textTitle, CENTER, TOP + MaterialConstants.COMPONENT_SPACING);

            Images scanRiskImage = new Images("images/scanRiskButton.png");

            score = new Label("22.5");
            score.setVisible(false);
            score.setForeColor(Colors.SCORE_COLOR);
            score.setFont(Fonts.nunitoBoldScoreSize);

            topContainer.add(score, CENTER, AFTER + UnitsConverter.toPixels(DP + 5));

            ImageControl scanRiskImageControl = new ImageControl(
                    scanRiskImage.getImage().hwScaledFixedAspectRatio(imageSize, true));

            scanRiskImageControl.centerImage = true;
            scanRiskImageControl.scaleToFit = true;
            scanRiskImageControl.transparentBackground = true;

            FloatingActionButton scanBtn = new FloatingActionButton(scanRiskImageControl.getImage());
            scanBtn.setIconSize(UnitsConverter.toPixels(DP + 95));
            topContainer.add(scanBtn, CENTER, AFTER + MaterialConstants.COMPONENT_SPACING);

            scanBtn.addPressListener((e) -> {

                rescan();
                updateUi();

            });

            Button btnEmployee = new Button("Employee Risks", Button.BORDER_OUTLINED);
            btnEmployee.setBackForeColors(Colors.PRIMARY, Colors.TEXT_ON_P_LIGHT);
            btnEmployee.addPressListener((e) -> {
                Notification.Builder builder = new Notification.Builder();
                Notification notification = builder.title("Geiger Toolbox").text("Change of cyber security threats!")
                        .build();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                NotificationManager.getInstance().notify(notification);
            });
            topContainer.add(btnEmployee, LEFT + MaterialConstants.BORDER_SPACING, AFTER + MaterialConstants.COMPONENT_SPACING);

            Button btnDevice = new Button("Device Risks", Button.BORDER_OUTLINED);
            btnDevice.setBackForeColors(Colors.PRIMARY, Colors.TEXT_ON_P_LIGHT);
            topContainer.add(btnDevice, RIGHT - MaterialConstants.BORDER_SPACING, CENTER_OF);

            Label currentThreatText = new Label("Current Threats:");
            currentThreatText.setFont(Fonts.nunitoBoldFont);
            topContainer.add(currentThreatText, LEFT + MaterialConstants.BORDER_SPACING,
                    AFTER + MaterialConstants.COMPONENT_SPACING);

            Label threatRiskText = new Label("Threat Risk");

            topContainer.add(threatRiskText, RIGHT - MaterialConstants.BORDER_SPACING, CENTER_OF);

            // add(scrollContainer, CENTER, AFTER, PARENTSIZE, FILL);

        }

        catch (ImageException e) {
            e.printStackTrace();
        }

    }

    UpdateListener updateListener = new UpdateListener() {

        @Override
        public void updateListenerTriggered(int elapsedmilliseconds) {

            if (index != threats.length() - 1) {
                index++;
            } else {
                MainWindow.getMainWindow().removeUpdateListener(this);
            }

        }
    };

    private void populateData() {

        threatMalware.keySet().clear();
        threatPhishing.keySet().clear();

        // phishing JSONObject
        threatPhishing.put("image", "images/phishing.png");
        threatPhishing.put("threatScore", 88);
        threatPhishing.put("threatRisk", "very high");

        // malware JSONObject

        threatMalware.put("image", "images/malware.png");
        threatMalware.put("threatScore", 55);
        threatMalware.put("threatRisk", "medium");

        threats.put("Phishing", threatPhishing);
        threats.put("Malware", threatMalware);

        System.out.println(threats.length() + "number" + index);
    }

    private void updateUi() {

        threats.keySet().clear();
        MainWindow.getMainWindow().removeUpdateListener(updateListener);
        index = 0;
        MainWindow.getMainWindow().addUpdateListener(updateListener);

    }

    private void rescan() {

        if (threats.length() != index) {
            threatTitles = threats.names();
            threatTitleItems = threats.toJSONArray(threatTitles);
            score.setText("55");
            score.setVisible(true);
            score.repaintNow();

            textTitle.setText("Your total Risk Score:");
            textTitle.repaintNow();
            System.out.println(s);

            for (int i = 0; i < threats.length(); i++) {
                String title = threatTitles.getString(i);
                JSONObject items = threatTitleItems.getJSONObject(i);

                int tScore = Integer.parseInt(items.get("threatScore").toString());

                CardThreat card = new CardThreat(title, new Images(items.get("image").toString()), tScore,
                        items.get("threatRisk").toString(), new RecommendationScreen(title));

                scrollContainer.add(card, LEFT + gap, AFTER + space, FILL - MaterialConstants.BORDER_SPACING, 130 + DP);
                // System.out.println(title);
                // System.out.println(items);

            }
            scrollContainer.add(spacing, LEFT, AFTER + MaterialConstants.TWENTY_DP);

        }

    }

}
