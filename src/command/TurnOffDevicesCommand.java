package command;

import service.DeviceManager;
import java.util.*;

public class TurnOffDevicesCommand implements Command {
    public String getDesc() {
        return "Вимкнути прилади";
    }

    public void execute(String params) {
        if (DeviceManager.isEmpty()) {
            System.out.println("Список порожній!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        DeviceManager.showAll();
        System.out.print("Введіть номери приладів через кому (наприклад 2,4): ");
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
        DeviceManager.turnOffDevices(list);
    }
}
