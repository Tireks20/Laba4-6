package model;


public class KitchenDevice extends Device {
    private String energyEfficiency; // Наприклад, "A+", "B"

    public KitchenDevice(String name, int power, String energyEfficiency) {
        super(name, power);
        this.energyEfficiency = energyEfficiency;
    }

    public String getEnergyEfficiency() {
        return energyEfficiency;
    }

    @Override
    public String toString() {
        return super.toString() + ", Energy Efficiency: " + energyEfficiency;
    }
}