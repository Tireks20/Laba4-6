package model;

public class Lighting extends Device {
    private int maintenanceInterval; // Період обслуговування в місяцях

    public Lighting(String name, int power, int maintenanceInterval) {
        super(name, power);
        this.maintenanceInterval = maintenanceInterval;
    }

    public int getMaintenanceInterval() {
        return maintenanceInterval;
    }

    @Override
    public String toString() {
        return super.toString() + ", Maintenance Interval: " + maintenanceInterval + " months";
    }
}