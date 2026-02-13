package Inventář;

import Hra.StavHry;
import Předměty.Predmet;

/**
 * Reprezentuje a stravuje inventar pro predmety.
 * * @author Katka
 */
public class InventarProPredmet {

    private Predmet aktualniPredmet;

    public InventarProPredmet() {
    }

    public String nastavitAktualniPredmet(String imput, StavHry stavHry) {

        for (int i = 0; i < stavHry.getVmodulu().getPredmetyNaModulu().size(); i++) {
            if (imput.equals(stavHry.getVmodulu().getPredmetyNaModulu().get(i).getNazev())) {
                aktualniPredmet = stavHry.getVmodulu().getPredmetyNaModulu().get(i);
                return "Momentalne mas usebe " + stavHry.getVmodulu().getPredmetyNaModulu().get(i).getNazev();
            }
        }
        return "spatny nazev zkus to znovu";
    }

    public Predmet getAktualniPredmet() {
        return aktualniPredmet;
    }

    public void setAktualniPredmet(Predmet aktualniPredmet) {
        this.aktualniPredmet = aktualniPredmet;
    }

    @Override
    public String toString() {
        return "InventářProPredmet{" +
                "aktualniPredmet=" + aktualniPredmet +
                '}';
    }
}
