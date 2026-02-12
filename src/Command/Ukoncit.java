package Command;

import Hra.StavHry;

/**
 * Spravuje command Ukoncit.
 * metoda execute: pokud jdou splněny všechny podminky, bude mozne ukoncit a dohrat hru.
 * * @author Katka
 */
public class Ukoncit implements Command{

    @Override
    public String execute(StavHry stavHry) {
        return "";

    }

    public boolean exit(StavHry stavHry) {
        if (stavHry.zkontrolujKonecMise()) {
            System.out.println("--------------------------------------------------\n" +
                    "SYSTÉM: Všechny úkoly splněny. Data odeslána na Zemi.\n" +
                    "Nix usedá do křesla, motory modulu naskakují...\n" +
                    "Mise AETHEREA byla úspěšně dokončena! Vyhrál jsi!\n" +
                    "--------------------------------------------------");
            return true;
        } else {
            System.out.println("NIX: Ještě nemůžu odletět. Musím dokončit všechny úkoly " +
                    "a prozkoumat celou stanici na 100 %.");
            return false;
        }
    }
}
