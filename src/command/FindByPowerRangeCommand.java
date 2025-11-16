package command;

import model.Device;
import service.DeviceManager;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Scanner;

public class FindByPowerRangeCommand implements Command {
    private ArrayList<Device> devices;

    public FindByPowerRangeCommand() {
        this.devices = DeviceManager.getInstance().getDevices();
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть мінімальну потужність:");
        int minPower = scanner.nextInt();
        System.out.println("Введіть максимальну потужність:");
        int maxPower = scanner.nextInt();

        boolean found = false;
        for (Device device : devices) {
            if (device.getPower() >= minPower && device.getPower() <= maxPower) {
                System.out.println(device);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Прилади в заданому діапазоні потужності не знайдено!");
        }
    }

    @Override
    public String getDesc() {
        return "Знайти прилади за діапазоном потужності";
    }
}