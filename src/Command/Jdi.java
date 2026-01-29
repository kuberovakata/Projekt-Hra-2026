package Command;

import AETHEREA.Lokace;
import Hra.DataHry;
import Hra.StavHry;

import java.util.Scanner;

public class Jdi implements Command {
    @Override
    public String execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Kam?");
        String input = scanner.nextLine();

        Lokace aktualni = StavHry.getAktualniLokace();
        if (aktualni.getVychody().contains(input)) {
            for (Lokace l : DataHry.getLocations()) {
                if (l.getNazev().equalsIgnoreCase(input)) {
                    StavHry.setAktualniLokace(l);
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
    public boolean exit() {
        return false;
    }
}
