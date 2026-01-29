package Command;

import Hra.StavHry;

public class Info implements Command {
    @Override
    public String execute() {
        // dodelat: postuprm se pridaji dalsi
        return "Prave se nachazis v" + StavHry.getAktualniLokace().getNazev();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
