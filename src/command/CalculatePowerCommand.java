package command;

import service.DeviceManager;

public class CalculatePowerCommand implements Command {
    public String getDesc() {
        return "Підрахувати потужність увімкнених приладів";
    }

    public void execute(String params) {
        double total = DeviceManager.totalPower();
        System.out.println("Загальна потужність увімкнених приладів: " + total + " Вт");
    }
}
