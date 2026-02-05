package Command;

import Hra.DataHry;
import Hra.StavHry;

public class Info implements Command {
    @Override
    public String execute(StavHry stavHry) {
        // postupem se pridaji dalsi aktualni informace
        return "Prave se nachazis v" + stavHry.getAktualniLokace().getNazev() + " -- "
                +stavHry.getAktualniLokace().getProcentoCistoty()+ " -- " + stavHry.getProcentaProgresu().getProcentaZaCelouHru() + stavHry.getProPredmet().getAktualniPredmet().getNazev();
    }

    @Override
    public boolean exit(StavHry stavHry) {
        return false;
    }
}
