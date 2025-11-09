package command;

import service.DeviceManager;
import java.util.*;

public class TurnOnDevicesCommand implements Command {
    public String getDesc() {
        return "Увімкнути прилади";
    }

    public void execute(String params) {
        if (DeviceManager.isEmpty()) {
            System.out.println("Список порожній!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        DeviceManager.showAll();
        System.out.print("Введіть номери приладів через кому (наприклад 1,3,5): ");
        String line = sc.nextLine();
        String[] parts = line.split(",");
        List<Integer> list = new ArrayList<>();
        for (String p : parts) {
            try {
                list.add(Integer.parseInt(p.trim()));
            } catch (Exception e) {
                System.out.println("Невірний номер: " + p.trim());
            }
        }
        DeviceManager.turnOnDevices(list);
    }
}
