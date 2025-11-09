package command;

import service.DeviceManager;
import java.util.Scanner;

public class FindByPowerRangeCommand implements Command {
    public String getDesc() {
        return "Знайти прилади у діапазоні потужності";
    }

    public void execute(String params) {
        if (DeviceManager.isEmpty()) {
            System.out.println("Список порожній!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть мінімальну потужність: ");
        double min = sc.nextDouble();
        System.out.print("Введіть максимальну потужність: ");
        double max = sc.nextDouble();
        DeviceManager.findByRange(min, max);
    }
}
