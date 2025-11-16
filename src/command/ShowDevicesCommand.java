package command;

import model.Device;
import service.DeviceManager;

import java.util.ArrayList;

public class ShowDevicesCommand implements Command {
    private ArrayList<Device> devices;

    public ShowDevicesCommand() {
        this.devices = DeviceManager.getInstance().getDevices();
    }

    @Override
    public void execute() {
        if (devices.isEmpty()) {
            System.out.println("Список приладів порожній!");
        } else {
            for (Device device : devices) {
                System.out.println(device);
            }
        }
    }

    @Override
    public String getDesc() {
        return "Показати всі прилади";
    }
}
