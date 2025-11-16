package service;

import command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<String, Command> commands;

    public Menu() {
        commands = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commands.put("1", new LoadDevicesCommand());
        commands.put("2", new ShowDevicesCommand());
        commands.put("3", new TurnOnDevicesCommand());
        commands.put("4", new TurnOffDevicesCommand());
        commands.put("5", new SortDevicesCommand());
        commands.put("6", new FindByPowerRangeCommand());
        commands.put("7", new CalculatePowerCommand());
        commands.put("8", new ExitCommand());
    }

    public void showMenu() {
        help();
        System.out.println("Введіть номер команди:");
    }

    public void help() {
        System.out.println("Домашні електроприлади");
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getDesc());
        }
    }

    public void executeCommand(String choice) {
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Невірна команда!");
        }
    }

    // Новий метод run
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            String choice = scanner.nextLine();
            executeCommand(choice);
        }
    }
}