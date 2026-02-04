package Command;

import AETHEREA.Lokace;
import Hra.DataHry;
import Hra.StavHry;
import Předměty.Odpad;
import java.util.ArrayList;

public class Sken implements Command {

    @Override
    public String execute(StavHry stavHry) {

        Lokace aktualni = stavHry.getAktualniLokace();
        ArrayList<Odpad> odpady = aktualni.getOdpady();

        System.out.println("\n[SIS AI]: Zahajuji hloubkový sken sektoru: " + aktualni.getNazev());
        System.out.println("-------------------------------------------------------");

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
        System.out.println("-------------------------------------------------------");
        System.out.println("AKTUÁLNÍ ČISTOTA SEKTORU: " + aktualniCistota + "%");
        System.out.println();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
