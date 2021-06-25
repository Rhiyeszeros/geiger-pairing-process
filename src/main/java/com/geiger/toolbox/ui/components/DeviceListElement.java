package com.geiger.toolbox.ui.components;


import com.geiger.toolbox.ToolboxUi;
import com.geiger.toolbox.model.Device;
import com.geiger.toolbox.model.Model;
import com.geiger.toolbox.ui.screens.DevicesScreen;
import com.geiger.toolbox.util.Colors;
import net.sf.saxon.type.StringConverter;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.event.UpdateListener;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;
import totalcross.ui.image.Image;

import totalcross.util.UnitsConverter;

import java.util.ArrayList;

import static com.geiger.toolbox.util.Fonts.nunitoItalic;

public class DeviceListElement extends Container {

    int margin = UnitsConverter.toPixels(Control.DP + 5);

    private Device device;
    private ArrayList<Device> deviceList;
    private DevicesScreen deviceListScrollContainer;

    public DeviceListElement(Device device, ArrayList<Device> deviceList,DevicesScreen deviceListScrollContainer){
        this.device = device;
        this.deviceList = deviceList;
        this.deviceListScrollContainer = deviceListScrollContainer;
    }
    public void initUI(){
        try {
            setInsets(margin, margin, margin, margin);
            Label lb2, lb3;

            Icon icon = new Icon(MaterialIcons._PHONE_ANDROID);
            add(icon,LEFT, TOP + margin, PREFERRED + margin, PREFERRED);

            lb2 = new Label(device.getDeviceName());
            lb2.setBackForeColors(Colors.WHITE,  Color.BLACK);
            add(lb2, AFTER, TOP + margin, PREFERRED + margin, PREFERRED);

            lb3 = new Label("Up to date: 2 days ago");
            lb3.setBackForeColors(Colors.WHITE,  Color.BLACK);
            lb3.setFont(nunitoItalic);
            add(lb3, LEFT, AFTER + margin, PREFERRED + margin, PREFERRED);

            Container cont = new Container();
            add(cont, AFTER + margin, TOP, 70, 60);
            IndicatorGauge indicatorGauge = new IndicatorGauge(device.getGeigerScore());
            indicatorGauge.resize();

            cont.add(indicatorGauge, CENTER, TOP, 70, 70);

            Label gaugeLabel = new Label(Integer.toString(device.getGeigerScore()));
            gaugeLabel.transparentBackground = true;
            cont.add(gaugeLabel, CENTER, BOTTOM, PREFERRED, PREFERRED);


            Icon iconTrash = new Icon(MaterialIcons._DELETE);
            iconTrash.setForeColor(Colors.S_LIGHT);
            iconTrash.transparentBackground = true;

            Image deleteImage = new Image("images/delete_image.jpg");
            Button button = new Button(deleteImage, Button.BORDER_ROUND);
            button.setBackColor(Colors.WHITE);
            button.setForeColor(Colors.TEXT_ON_P);

            resizeHeight();

            add(button,RIGHT, CENTER, 30, 30);

            button.addPressListener((e) -> {
                deviceList.remove(device);
                System.out.println(deviceListScrollContainer);
                deviceListScrollContainer.removeAll();
                deviceListScrollContainer.initUI();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
