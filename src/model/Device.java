package model;

import java.io.Serializable;

public abstract class Device implements Comparable<Device>, Serializable {
    protected String name;
    protected int power;
    protected boolean isOn;

    public Device(String name, int power) {
        this.name = name;
        this.power = power;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    @Override
    public int compareTo(Device other) {
        return Integer.compare(this.power, other.power);
    }

    @Override
    public String toString() {
        return "Device: " + name + ", Power: " + power + "W, Status: " + (isOn ? "On" : "Off");
    }
}