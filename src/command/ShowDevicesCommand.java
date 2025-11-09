package command;

import service.DeviceManager;

public class ShowDevicesCommand implements Command {
    public String getDesc() {
        return "Показати всі прилади";
    }

    public void execute(String params) {
        DeviceManager.showAll();
    }
}
