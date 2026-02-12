package Command;

import Hra.StavHry;

/**
 * Spravuje command Použít.
 * metoda execute: spravuje pouzivani objektu.
 * * @author Katka
 */
public class Použit implements Command {

    @Override
    public String execute(StavHry stavHry) {

        if (stavHry.getProPredmet().getAktualniPredmet() == null) {
            return "Nix: Momentálně nemám v rukou žádný předmět, který bych mohl použít.";
        }

        for (int i = 0; i < stavHry.getUkoly().size(); i++) {
            String nazevLokaceHrace = stavHry.getAktualniLokace().getNazev();

            if (nazevLokaceHrace.equals(stavHry.getUkoly().get(i).getNazevMistoKonani())){
                if (stavHry.getUkoly().get(i).isJeSplneno()) {
                    return "Tento úkol už jsi splnil. Pokračuj dál v misi.";
                }

                String aktualniPredmetHrace = stavHry.getProPredmet().getAktualniPredmet().getNazev();

                if (!aktualniPredmetHrace.equals(stavHry.getUkoly().get(i).getNazevPotrebnyPredmet())) {
                    return "Zkoušíš použít " + aktualniPredmetHrace + ", ale v této místnosti potřebuješ něco jiného.";
                }
                if (!stavHry.getAktualniLokace().isJeStoProcent()) {
                    return "Zatím nemůžeš použít " + stavHry.getUkoly().get(i).getNazevPotrebnyPredmet() + ". Nejdřív musíš místnost prozkoumat na 100 % (příkaz /info).";
                }

                stavHry.getUkoly().get(i).setJeSplneno(true);
                return "Skvělá práce! Použil jsi " + stavHry.getUkoly().get(i).getNazevPotrebnyPredmet() + " a splnil jsi úkol: " + stavHry.getUkoly().get(i).getPopis();
            }
        }
        return "Tady není nic, na co bys mohl své vybavení použít.";
    }

    @Override
    public boolean exit(StavHry stavHry) {
        return false;
    }
}
