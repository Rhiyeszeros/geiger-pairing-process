package com.geiger.toolbox.model;

public class Device {
    String deviceName;
    String type;
    int score;

    public Device(String name, int score, String type){
        this.deviceName = name;
        this.score = score;
        this.type = type;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public int getScore() {
        return score;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Device))  {
            return false;
        }
        Device other = (Device)obj;
        return deviceName.equals(other.deviceName)
                && type.equals(other.type);
    }
}
