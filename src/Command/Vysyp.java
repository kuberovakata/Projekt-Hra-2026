package Command;

import AETHEREA.Lokace;
import Hra.DataHry;
import Hra.StavHry;
import Inventář.InventářProOdpad;

public class Vysyp implements Command {

    InventářProOdpad inventářProOdpad = new InventářProOdpad();

    public String execute() {
        Lokace aktualni = StavHry.getAktualniLokace();
        if (aktualni.equals(DataHry.getLocations().getFirst())){
            inventářProOdpad.vyprazdnit();
            return "vysypal jsi svuj batoh" + inventářProOdpad.toString();
        }
        return "nejsi v operacnim modulu, dojdi tam a zkus to znovu";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
