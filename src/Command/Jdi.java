package Command;

import AETHEREA.Lokace;
import Hra.DataHry;
import Hra.StavHry;

import java.util.Scanner;

/**
 * Spravuje command Jdi.
 * metoda execute: spravuje pohyb po mapě.
 * * @author Katka
 */
public class Jdi implements Command {
    @Override
    public String execute(StavHry stavHry) {

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < stavHry.getAktualniLokace().getVychody().size(); i++) {
            System.out.println(stavHry.getAktualniLokace().getVychody().get(i));
        }
        System.out.println("Kam?");
        String input = scanner.nextLine();

        Lokace aktualni = stavHry.getAktualniLokace();

        if (aktualni.getVychody().contains(input)) {
            for (Lokace l : DataHry.getLocations()) {

                if (input.equals(DataHry.getLocations().get(7).getNazev()) && !stavHry.isJeOdemcenaReaktorovaMistnost() && !stavHry.isMaIDkartu() ) {
                    return "bohuzel sem se momentalne nemuzes dostat, najdi ID kartu a zkus to znova";
                }

                if (input.equals(DataHry.getLocations().get(7).getNazev()) && !stavHry.isJeOdemcenaReaktorovaMistnost() && stavHry.isMaIDkartu() ) {
                    stavHry.setJeOdemcenaReaktorovaMistnost(true);
                    System.out.println("Uspesne si pouzil ID kartu");
                }


                if (l.getNazev().equalsIgnoreCase(input)) {
                    stavHry.setAktualniLokace(l);
                    System.out.println("Vstoupil jsi do: " + l.getNazev());
                    System.out.println(l.getPopis());
                    return "";
                }


            }
        }

        System.out.println("Tam se odsud nedostaneš nebo taková místnost neexistuje.");
        return "";
    }

    @Override
    public boolean exit(StavHry stavHry) {
        return false;
    }
}
