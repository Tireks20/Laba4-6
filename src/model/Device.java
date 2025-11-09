package model;

public class Device {
    private String name;
    private double power;
    private boolean on;

    public Device(String name, double power) {
        this.name = name;
        this.power = power;
        this.on = false;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    @Override
    public String toString() {
        return name + " (" + power + " Вт) " + (on ? "[УВІМКНЕНО]" : "[ВИМКНЕНО]");
    }
}
