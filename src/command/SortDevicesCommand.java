package command;

import model.Device;
import service.DeviceManager;

import java.util.ArrayList;
import java.util.Collections;

public class SortDevicesCommand implements Command {
    private ArrayList<Device> devices;

    public SortDevicesCommand() {
        this.devices = DeviceManager.getInstance().getDevices();
    }

    @Override
    public void execute() {
        if (devices.isEmpty()) {
            System.out.println("Список приладів порожній!");
        } else {
            Collections.sort(devices);
            System.out.println("Прилади відсортовано за потужністю!");
        }
    }

    @Override
    public String getDesc() {
        return "Відсортувати прилади за потужністю";
    }
}