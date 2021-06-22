package com.geiger.toolbox.model;

import java.util.ArrayList;

public class Model {

    public static ArrayList<Device> devices = new ArrayList<>();
    static Device android = new Device("Samsung Galays S10", 79);
    static Device iPhone = new Device("iPhone 12", 55);

    public static void addDevices(){
        devices.add(android);
        for (int i = 0; i < 5; i++){
            devices.add(iPhone);
        }
    }
}