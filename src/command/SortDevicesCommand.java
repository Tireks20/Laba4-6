package command;

import service.DeviceManager;

public class SortDevicesCommand implements Command {
    public String getDesc() {
        return "Сортувати прилади за потужністю";
    }

    public void execute(String params) {
        DeviceManager.sortByPower();
    }
}
