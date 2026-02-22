package Command;

import AETHEREA.Lokace;
import Hra.DataHry;
import Hra.StavHry;
import Předměty.Odpad;
import java.util.ArrayList;

import static Hra.ToolBox.*;

/**
 * Spravuje command Sken.
 * metoda execute: vypíše seznam odpadu v aktualni mistnosti a procento v lokaci.
 * * @author Katka
 */
public class Sken implements Command {

    @Override
    public String execute(StavHry stavHry) {

        Lokace aktualni = stavHry.getAktualniLokace();
        ArrayList<Odpad> odpady = aktualni.getOdpady();

        mezara();
        System.out.println(ANSI_ZELENA + "[ SIS ]:" + ANSI_RESET + " Zahajuji hloubkový sken sektoru: " + aktualni.getNazev());
        System.out.println("----------------------------------------------------------------------------------------------------");

        if (stavHry.getAktualniLokace().getProcentoCistoty() == 100) {
            System.out.println("Stav: SEKTOR JE 100% DEKONTAMINOVÁN.");
            return "";
        }

        int zbyvajiciProgres = 0;

        for (Odpad o : odpady) {
            System.out.print("- " + o.getNazev());
            System.out.print(" (" + o.getVelikost() + ")");
            System.out.println(" | " + o.getVahu() + " kg");
            zbyvajiciProgres += o.getProgres();
        }
        if (!stavHry.isMaIDkartu() && stavHry.getAktualniLokace().equals(DataHry.getLocations().get(4))) {
            System.out.println("ID karta");
        }
        int aktualniCistota = 100 - zbyvajiciProgres;
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(ANSI_ZELENA + "AKTUÁLNÍ ČISTOTA SEKTORU: " + aktualniCistota + "%" + ANSI_RESET );
        return " ";
    }

    @Override
    public boolean exit(StavHry stavHry) {
        return false;
    }
}
