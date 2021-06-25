package com.geiger.toolbox.ui.components;

import com.geiger.toolbox.model.Device;
import com.geiger.toolbox.ui.screens.DevicesScreen;
import com.geiger.toolbox.util.Colors;
import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.Divider;
import totalcross.ui.ScrollContainer;
import totalcross.util.UnitsConverter;

import java.util.ArrayList;

public class DeviceList extends Container {

    int margin = UnitsConverter.toPixels(Control.DP + 10);
    ArrayList<Device> devices;
    ScrollContainer scrollContainer;
    private DevicesScreen deviceListScrollContainer;
    protected boolean allowVerticalScroll = true;
    protected boolean allowHorizontalScroll = false;

    public DeviceList(ArrayList<Device> deviceList, DevicesScreen deviceListScrollContainer){
        this.devices = deviceList;
        this.deviceListScrollContainer = deviceListScrollContainer;
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

        if (devices.size() == 1){
            allowVerticalScroll = false;
        }

        add(scrollContainer, LEFT, CENTER, PARENTSIZE, PARENTSIZE);

        for (Device device : devices){
            DeviceListElement deviceListElement = new DeviceListElement(device, devices, deviceListScrollContainer);
            scrollContainer.add(deviceListElement, CENTER, AFTER + margin, Settings.screenWidth - margin*2, 90);
            if (devices.size() > 1){
                Divider divider = new Divider();
                scrollContainer.add(divider, CENTER, AFTER, Settings.screenWidth - margin*4, PREFERRED);
            }
        }

        setBorderStyle(BORDER_ROUNDED);
        borderColor = Colors.SECONDARY;
    }
}
