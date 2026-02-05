package Command;

import Hra.StavHry;

public class Konec implements Command{
    public String execute(StavHry stavHry) {
        return "konec programu";
    }

    public boolean exit(StavHry stavHry) {
        return true;
    }
}
