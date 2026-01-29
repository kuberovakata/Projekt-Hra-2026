package Command;

public class Konec implements Command{
    public String execute() {
        return "konec programu";
    }

    public boolean exit() {
        return true;
    }
}
