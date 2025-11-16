package service;

import model.Device;

import java.util.ArrayList;

public class DeviceManager {
    private static DeviceManager instance;
    private ArrayList<Device> devices;

    private DeviceManager() {
        devices = new ArrayList<>();
    }

    public static DeviceManager getInstance() {
        if (instance == null) {
            instance = new DeviceManager();
        }
        return instance;
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }
}