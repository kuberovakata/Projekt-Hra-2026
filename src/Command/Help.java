package Command;

public class Help implements Command {
    @Override
    public String execute() {
        return "";
    }
    public String listPrikazu() {
        // dodelat: postupem se pridaji dalsi
        return "seznam prikazu: help, info, jdi, konec, vezmi, vysyp";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
