package service;

import model.*;
import java.io.*;
import java.util.*;

public class DeviceManager {
    private static List<Device> devices = new ArrayList<>();

    public static void loadFromFile(String filename) {
        devices.clear();
        File f = new File(filename);
        if (!f.exists()) {
            f = new File("src/" + filename);
        }
        if (!f.exists()) {
            System.out.println("Файл не знайдено: " + filename);
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    double power = Double.parseDouble(parts[1].trim());
                    String type = parts[2].trim();
                    Device d;
                    if (type.equalsIgnoreCase("Kitchen")) d = new KitchenDevice(name, power);
                    else if (type.equalsIgnoreCase("Lighting")) d = new Lighting(name, power);
                    else d = new Entertainment(name, power);
                    devices.add(d);
                } else {
                    String[] p2 = line.split(",");
                    if (p2.length == 2) {
                        String name = p2[0].trim();
                        double power = Double.parseDouble(p2[1].trim());
                        devices.add(new Device(name, power) {});
                    }
                }
            }
            System.out.println("Прилади завантажено! (" + devices.size() + ")");
        } catch (Exception e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    public static void showAll() {
        if (devices.isEmpty()) {
            System.out.println("Список порожній!");
            return;
        }
        int i = 1;
        for (Device d : devices) {
            System.out.println(i + ". " + d);
            i++;
        }
    }

    public static void turnOnDevices(List<Integer> indexes) {
        for (int i : indexes) {
            if (i > 0 && i <= devices.size()) {
                devices.get(i - 1).turnOn();
            } else {
                System.out.println("Невірний індекс: " + i);
            }
        }
        System.out.println("Прилади увімкнено!");
    }

    public static void turnOffDevices(List<Integer> indexes) {
        for (int i : indexes) {
            if (i > 0 && i <= devices.size()) {
                devices.get(i - 1).turnOff();
            } else {
                System.out.println("Невірний індекс: " + i);
            }
        }
        System.out.println("Прилади вимкнено!");
    }

    public static double totalPower() {
        double sum = 0;
        for (Device d : devices) {
            if (d.isOn()) sum += d.getPower();
        }
        return sum;
    }

    public static void sortByPower() {
        devices.sort(Comparator.comparingDouble(Device::getPower));
        System.out.println(" Прилади відсортовано за потужністю!");
    }

    public static void findByRange(double min, double max) {
        boolean found = false;
        for (Device d : devices) {
            if (d.getPower() >= min && d.getPower() <= max) {
                System.out.println(d);
                found = true;
            }
        }
        if (!found) System.out.println("Прилади у цьому діапазоні не знайдені!");
    }

    public static boolean isEmpty() {
        return devices.isEmpty();
    }
}
