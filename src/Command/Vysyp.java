package Command;

import AETHEREA.Lokace;
import Hra.DataHry;
import Hra.StavHry;

/**
 * Spravuje command Info.
 * metoda execute: vyprezdis batoh hrace.
 * * @author Katka
 */
public class Vysyp implements Command {

    public String execute(StavHry stavHry) {
        Lokace aktualni = stavHry.getAktualniLokace();
        if (aktualni.equals(DataHry.getLocations().getFirst())){
            stavHry.getInventářProOdpad().vyprazdnit();
            return "vysypal jsi svuj batoh" + stavHry.getInventářProOdpad().toString();
        }
        return "nejsi v operacnim modulu, dojdi tam a zkus to znovu";
    }

    @Override
    public boolean exit(StavHry stavHry) {
        return false;
    }
}
