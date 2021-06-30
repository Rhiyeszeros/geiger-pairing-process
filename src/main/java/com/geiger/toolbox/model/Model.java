package com.geiger.toolbox.model;

import java.util.ArrayList;

public class Model {

    public static ArrayList<Device> devices = new ArrayList<>();
    public static ArrayList<Device> thisDeviceList = new ArrayList<>();
    static Device android = new Device("Samsung Galaxy S10", 79, "Smartphone");
    static Device macbook = new Device("Macbook Pro", 55, "Laptop");
    static Device pc = new Device("HP Desktop", 65, "Desktop");

    public static Device thisDevice = new Device("FairPhone 2", 12, "Smartphone");

    public static void addDevices(){
        thisDeviceList.add(thisDevice);
        devices.add(android);
        devices.add(pc);
        devices.add(macbook);
    }
}