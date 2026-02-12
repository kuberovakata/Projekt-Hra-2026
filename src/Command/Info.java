package Command;

import Hra.StavHry;

/**
 * Spravuje command Info.
 * metoda execute: napíše aktualni informace o stavu hry.
 * * @author Katka
 */
public class Info implements Command {

    @Override
    public String execute(StavHry stavHry) {

        // postupem se pridaji dalsi aktualni informace
        return "Prave se nachazis v" + stavHry.getAktualniLokace().getNazev() + " -- "
                +stavHry.getAktualniLokace().getProcentoCistoty()+ " -- " +
                stavHry.getProcentaProgresu().pocitaniProcent(stavHry) + zadnyPredmet(stavHry);
    }

    public String zadnyPredmet(StavHry stavHry) {
        if (stavHry.getProPredmet().getAktualniPredmet() == null){
            return "zadny";
        }
        return stavHry.getProPredmet().getAktualniPredmet().getNazev();
    }

    @Override
    public boolean exit(StavHry stavHry) {
        return false;
    }
}
