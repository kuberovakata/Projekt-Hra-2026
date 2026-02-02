package Command;

import Hra.StavHry;

public class Použij implements Command {

    @Override
    public String execute(StavHry stavHry) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
