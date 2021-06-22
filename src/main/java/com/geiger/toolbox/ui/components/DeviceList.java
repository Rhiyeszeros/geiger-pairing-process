package com.geiger.toolbox.ui.components;

import com.geiger.toolbox.model.Device;
import com.geiger.toolbox.util.Colors;
import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.Divider;
import totalcross.util.UnitsConverter;

import java.util.ArrayList;

public class DeviceList extends Container {

    int margin = UnitsConverter.toPixels(Control.DP + 10);
    ArrayList<Device> devices;

    public DeviceList(ArrayList<Device> deviceList){
        this.devices = deviceList;
    }

    @Override
    public void initUI() {
        super.initUI();

        for (Device device : devices){
            DeviceListElement deviceListElement = new DeviceListElement(device, devices);
            add(deviceListElement, CENTER, AFTER + margin, Settings.screenWidth - margin*2, PREFERRED);
            Divider divider = new Divider();
            add(divider, CENTER, AFTER, Settings.screenWidth - margin*4, PREFERRED);
        }

        setBorderStyle(BORDER_ROUNDED);
        borderColor = Colors.SECONDARY;
        resizeHeight();
    }
}
