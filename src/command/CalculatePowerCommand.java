package command;

import model.Device;
import service.DeviceManager;

import java.util.ArrayList;

public class CalculatePowerCommand implements Command {
    private ArrayList<Device> devices;

    public CalculatePowerCommand() {
        this.devices = DeviceManager.getInstance().getDevices();
    }

    @Override
    public void execute() {
        int totalPower = 0;
        for (Device device : devices) {
            if (device.isOn()) {
                totalPower += device.getPower();
            }
        }
        System.out.println("Загальна потужність увімкнених приладів: " + totalPower + "W");
    }

    @Override
    public String getDesc() {
        return "Обчислити загальну потужність увімкнених приладів";
    }
}