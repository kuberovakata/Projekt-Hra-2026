package Command;

import AETHEREA.Lokace;
import Hra.DataHry;
import Hra.StavHry;

import java.util.ArrayList;

public class Vysyp implements Command {

    public String execute() {

        Lokace aktualni = StavHry.getAktualniLokace();
        if (aktualni.equals(DataHry.getLocations().getFirst())){
            // dodelat: naklad se odstrani z InventářProOdpad
            return "vysypal jsi svuj batoh";
        }
        return "nejsi v operacnim modulu, dojdi tam a zkus to znovu";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
