package com.geiger.toolbox.model;

import java.util.ArrayList;

public class Model {

    public static ArrayList<Device> devices = new ArrayList<>();
    public static ArrayList<Device> thisDeviceList = new ArrayList<>();
    static Device android = new Device("Samsung Galays S10", 79, "Smartphone");
    static Device iPhone = new Device("iPhone 12", 55, "Smartphone");

    public static Device thisDevice = new Device("FairPhone 2", 12, "Smartphone");

    public static void addDevices(){
        thisDeviceList.add(thisDevice);
        devices.add(android);
        for (int i = 0; i < 5; i++){
            devices.add(iPhone);
        }
    }
}