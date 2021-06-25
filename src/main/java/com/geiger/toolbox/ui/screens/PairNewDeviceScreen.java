package com.geiger.toolbox.ui.screens;


import totalcross.ui.*;
import totalcross.util.UnitsConverter;

public class PairNewDeviceScreen extends Container {

    public ScrollContainer scrollContainer;
    int margin = UnitsConverter.toPixels(Control.DP + 10);


    @Override
    public void initUI(){

        scrollContainer = new ScrollContainer() {
            @Override
            public void initUI() {
                setScrollBars(false, false);
                super.initUI();
            }
        };

        add(scrollContainer, LEFT, TOP, FILL, FILL);

        Label lb1 = new Label("Pair a new device!");
        scrollContainer.add(lb1, LEFT + margin, TOP + margin, PREFERRED + margin, PREFERRED);
    }
}
