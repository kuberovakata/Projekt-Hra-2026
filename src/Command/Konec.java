package Command;

import Hra.StavHry;

/**
 * Spravuje command Konec.
 * metoda execute: ukoncuje hru.
 * * @author Katka
 */
public class Konec implements Command{
    public String execute(StavHry stavHry) {
        return "konec programu";
    }

    public boolean exit(StavHry stavHry) {
        return true;
    }
}
