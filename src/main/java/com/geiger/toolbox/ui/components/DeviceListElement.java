package com.geiger.toolbox.ui.components;


import com.geiger.toolbox.model.Device;
import com.geiger.toolbox.model.Model;
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

    int margin = UnitsConverter.toPixels(Control.DP + 10);

    private Device device;
    private ArrayList<Device> deviceList;

    public DeviceListElement(Device device, ArrayList<Device> deviceList){
        this.device = device;
        this.deviceList = deviceList;
    }
    public void initUI(){
        try {
            Label lb2, lb3;

            Icon icon = new Icon(MaterialIcons._PHONE_ANDROID);
            add(icon,LEFT+ margin, CENTER+margin, PREFERRED + margin, PREFERRED);

            lb2 = new Label(device.getDeviceName());
            lb2.setBackForeColors(Colors.WHITE,  Color.BLACK);
            add(lb2, AFTER, CENTER + margin, PREFERRED + margin, PREFERRED);

            lb3 = new Label("Up to date: 2 days ago");
            lb3.setBackForeColors(Colors.WHITE,  Color.BLACK);
            lb3.setFont(nunitoItalic);
            add(lb3, LEFT + margin, AFTER + margin, PREFERRED + margin, PREFERRED);

            Container cont = new Container();
            add(cont, AFTER + margin, TOP, 80, PARENTSIZE);


            IndicatorGauge indicatorGauge = new IndicatorGauge(device.getGeigerScore());
            indicatorGauge.resize();

            cont.add(indicatorGauge, CENTER, TOP, 80, 80);

            Label gaugeLabel = new Label(Integer.toString(device.getGeigerScore()));
            cont.add(gaugeLabel, CENTER, AFTER - margin, PREFERRED, PREFERRED);
            gaugeLabel.transparentBackground = true;
            cont.resizeHeight();

            Icon iconTrash = new Icon(MaterialIcons._DELETE);
            iconTrash.setForeColor(Colors.S_LIGHT);
            iconTrash.transparentBackground = true;

            Image deleteImage = new Image("images/delete_image.jpg");
            Button button = new Button(deleteImage, Button.BORDER_ROUND);
            button.setBackColor(Colors.PRIMARY);
            button.setForeColor(Colors.TEXT_ON_P);


            button.addPressListener((e) -> {
                deviceList.remove(device);
                getParentWindow().repaintNow();
            });

            setInsets(margin,margin,margin,margin);
            resizeHeight();
            add(button,AFTER + margin, CENTER, PREFERRED + margin, PREFERRED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
