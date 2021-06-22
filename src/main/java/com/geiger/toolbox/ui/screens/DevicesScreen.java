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
import totalcross.util.UnitsConverter;
import com.geiger.toolbox.model.Storage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.MissingResourceException;


public class DevicesScreen extends BaseScreen{

    int margin = UnitsConverter.toPixels(Control.DP + 10);

    @Override
    public void onContent(ScrollContainer content) throws StorageException {

        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.connectToDatabase();
        StorageController storageController = databaseManager.getController();

        Node node1 = storageController.get(":Local");
        NodeValue nodeValue1 = node1.getValue("currentDevice");

        System.out.println(nodeValue1);

        Label lb1;

        lb1 = new Label("This Device");
        lb1.setBackForeColors(Colors.WHITE,  Color.BLACK);
        content.add(lb1, LEFT + margin, TOP + margin, PREFERRED + margin, PREFERRED);

        DeviceList deviceList = new DeviceList(Model.devices);

        content.add(deviceList, CENTER, AFTER + margin, Settings.screenWidth - margin*2, PREFERRED);
    }
}
