package Command;

import Hra.StavHry;

/**
 * Spravuje command Help.
 * metoda execute: sepiše seznam příkazů.
 * * @author Katka
 */

public class Help implements Command {
    @Override
    public String execute(StavHry stavHry) {
        return listPrikazu();
    }
    public String listPrikazu() {
        return "seznam prikazu: help, info, jdi, konec, sis, sken, vezmi, vysyp, ";
    }

    @Override
    public boolean exit(StavHry stavHry) {
        return false;
    }
}
