package command;

import model.Device;
import model.Entertainment;
import model.KitchenDevice;
import model.Lighting;
import service.DeviceManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadDevicesCommand implements Command {
    private ArrayList<Device> devices;

    public LoadDevicesCommand() {
        this.devices = DeviceManager.getInstance().getDevices();
    }

    @Override
    public void execute() {
        try (BufferedReader reader = new BufferedReader(new FileReader("devices.txt"))) {
            devices.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Пропускаємо порожні рядки
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    System.out.println("Невірний формат рядка: " + line);
                    continue;
                }

                String type = parts[0].trim();
                String name = parts[1].trim();
                int power;
                try {
                    power = Integer.parseInt(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Невірна потужність у рядку: " + line);
                    continue;
                }

                Device device = null;
                switch (type) {
                    case "Entertainment":
                        String mediaType = parts[3].trim();
                        device = new Entertainment(name, power, mediaType);
                        break;
                    case "KitchenDevice":
                        String energyEfficiency = parts[3].trim();
                        device = new KitchenDevice(name, power, energyEfficiency);
                        break;
                    case "Lighting":
                        int maintenanceInterval;
                        try {
                            maintenanceInterval = Integer.parseInt(parts[3].trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Невірний інтервал обслуговування у рядку: " + line);
                            continue;
                        }
                        device = new Lighting(name, power, maintenanceInterval);
                        break;
                    default:
                        System.out.println("Невідомий тип приладу: " + type);
                        continue;
                }

                if (device != null) {
                    devices.add(device);
                }
            }
            System.out.println("Прилади успішно завантажено з devices.txt!");
        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні файлу devices.txt: " + e.getMessage());
        }
    }

    @Override
    public String getDesc() {
        return "Завантажити прилади з файлу";
    }
}