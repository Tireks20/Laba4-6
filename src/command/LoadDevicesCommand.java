package command;

import service.DeviceManager;

public class LoadDevicesCommand implements Command {
    public String getDesc() {
        return "Завантажити прилади з файлу";
    }

    public void execute(String params) {
        DeviceManager.loadFromFile("devices.txt");
    }
}
