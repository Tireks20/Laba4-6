package service;

import command.*;
import java.util.*;

public class Menu {
    private Map<String, Command> commands = new HashMap<>();

    public Menu() {
        commands.put("1", new LoadDevicesCommand());
        commands.put("2", new ShowDevicesCommand());
        commands.put("3", new TurnOnDevicesCommand());
        commands.put("4", new TurnOffDevicesCommand());
        commands.put("5", new CalculatePowerCommand());
        commands.put("6", new SortDevicesCommand());
        commands.put("7", new FindByPowerRangeCommand());
    }

    public void help() {
        System.out.println(" Домашні електроприлади ");
        System.out.println("1. Завантажити прилади з файлу");
        System.out.println("2. Показати всі прилади");
        System.out.println("3. Увімкнути прилад(и)");
        System.out.println("4. Вимкнути прилад(и)");
        System.out.println("5. Підрахувати потужність увімкнених приладів");
        System.out.println("6. Сортувати прилади за потужністю");
        System.out.println("7. Знайти прилади у діапазоні потужності");
        System.out.println("8. Вихід");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        String choice;

        while (true) {
            help();
            System.out.print("Виберіть дію: ");
            choice = sc.nextLine();

            if (choice.equals("8")) {
                System.out.println("Вихід з програми...");
                break;
            } else if (commands.containsKey(choice)) {
                commands.get(choice).execute("");
            } else {
                System.out.println("Невірний вибір! Спробуйте ще раз.");
            }
            System.out.println();
        }
    }
}
