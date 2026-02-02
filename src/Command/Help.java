package Command;

import Hra.StavHry;

public class Help implements Command {
    @Override
    public String execute(StavHry stavHry) {
        return "";
    }
    public String listPrikazu() {
        return "seznam prikazu: help, info, jdi, konec, sis, sken, vezmi, vysyp, ";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
