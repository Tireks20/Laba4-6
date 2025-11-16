package command;

import model.Device;
import service.DeviceManager;
import java.util.*;

import java.util.Scanner;

public class TurnOnDevicesCommand implements Command {
    private ArrayList<Device> devices;

    public TurnOnDevicesCommand() {
        this.devices = DeviceManager.getInstance().getDevices();
    }

    @Override
    public void execute() {
        System.out.println("Введіть назву приладу для увімкнення:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (Device device : devices) {
            if (device.getName().equalsIgnoreCase(name)) {
                device.turnOn();
                System.out.println("Прилад " + name + " увімкнено!");
                return;
            }
        }
        System.out.println("Прилад з назвою " + name + " не знайдено!");
    }

    @Override
    public String getDesc() {
        return "Увімкнути прилад";
    }
}