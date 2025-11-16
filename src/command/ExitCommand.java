package command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Програма завершена!");
        System.exit(0);
    }

    @Override
    public String getDesc() {
        return "Вийти з програми";
    }
}