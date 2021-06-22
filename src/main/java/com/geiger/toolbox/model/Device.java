package com.geiger.toolbox.model;

public class Device {
    String deviceName;
    int geigerScore;

    public Device(String name, int score){
        this.deviceName = name;
        this.geigerScore = score;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public int getGeigerScore() {
        return geigerScore;
    }
}
