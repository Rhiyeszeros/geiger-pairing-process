package com.geiger.toolbox.ui.screens;

import ch.fhnw.geiger.localstorage.StorageController;
import ch.fhnw.geiger.localstorage.StorageException;
import ch.fhnw.geiger.localstorage.db.GenericController;
import ch.fhnw.geiger.localstorage.db.data.Node;
import ch.fhnw.geiger.localstorage.db.data.NodeImpl;
import ch.fhnw.geiger.localstorage.db.data.NodeValue;
import ch.fhnw.geiger.localstorage.db.mapper.H2SqlMapper;
import ch.fhnw.geiger.totalcross.ByteArrayOutputStream;
import ch.fhnw.geiger.totalcross.Locale;
import com.geiger.toolbox.model.Device;
import com.geiger.toolbox.model.Model;
import com.geiger.toolbox.ui.BaseScreen;
import com.geiger.toolbox.ui.components.DeviceList;
import com.geiger.toolbox.ui.components.DeviceListElement;
import com.geiger.toolbox.util.Colors;
import com.geiger.toolbox.util.DatabaseManager;

import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.event.UpdateListener;
import totalcross.ui.gfx.Color;
import totalcross.ui.layout.HBox;
import totalcross.ui.layout.VBox;
import totalcross.util.UnitsConverter;
import com.geiger.toolbox.model.Storage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.MissingResourceException;


public class DevicesScreen extends Container{

    int margin = UnitsConverter.toPixels(Control.DP + 10);
    public ScrollContainer scrollContainer;


    @Override
    public void initUI() {

        scrollContainer = new ScrollContainer() {
            @Override
            public void initUI() {
                setScrollBars(false, false);
                super.initUI();
            }
        };

        add(scrollContainer, LEFT, TOP, FILL, FILL);
        paintUI();
    }

    public void  paintUI(){
        Label lb1, lb2;

        lb1 = new Label("This Device", LEFT, Color.BLACK, true);
        lb1.setBackForeColors(Colors.WHITE,  Color.BLACK);
        scrollContainer.add(lb1, LEFT + margin, TOP + margin, PREFERRED + margin, PREFERRED);

        DeviceList thisDevice = new DeviceList(Model.thisDeviceList, this);

        DeviceList deviceList = new DeviceList(Model.devices, this);

        scrollContainer.add(thisDevice, LEFT + margin/2, AFTER + margin, Settings.screenWidth - margin, 90);

        lb2 = new Label("Your other paired devices", LEFT, Color.BLACK, true);
        lb2.setBackForeColors(Colors.WHITE,  Color.BLACK);
        scrollContainer.add(lb2, LEFT + margin, AFTER + margin, PREFERRED + margin, PREFERRED);

        scrollContainer.add(deviceList, LEFT + margin/2, AFTER + margin, Settings.screenWidth - margin, 270);

        HBox hbox = new HBox(HBox.LAYOUT_FILL, HBox.ALIGNMENT_CENTER);
        Button pairNewDevice = new Button("Pair New Device", Button.BORDER_ROUND);
        Button pairThisDevice = new Button("Pair This Device", Button.BORDER_ROUND);

        pairNewDevice.setBackColor(Colors.PRIMARY);
        pairNewDevice.setForeColor(Colors.TEXT_ON_P);
        pairThisDevice.setBackColor(Colors.PRIMARY);
        pairThisDevice.setForeColor(Colors.TEXT_ON_P);

        hbox.add(pairNewDevice);
        hbox.add(pairThisDevice);
        hbox.setSpacing(margin);
        scrollContainer.add(hbox, LEFT + margin/2, AFTER + margin, Settings.screenWidth, PREFERRED);

        pairNewDevice.addPressListener((e) -> {
            MaterialWindow materialWindow = new MaterialWindow("Pair a new Device", false, new Presenter<Container>() {
                @Override
                public Container getView(){
                    return new PairNewDeviceScreen();
                }
            });
            materialWindow.popup();
        });

        pairThisDevice.addPressListener((e) -> {
            MaterialWindow materialWindow = new MaterialWindow("Pair this Device", false, new Presenter<Container>() {
                @Override
                public Container getView(){
                    return new PairThisDeviceScreen();
                }
            });
            materialWindow.popup();
        });
    }
}


