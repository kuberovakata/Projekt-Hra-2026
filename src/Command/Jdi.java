package Command;

import AETHEREA.Lokace;
import Hra.DataHry;
import Hra.StavHry;

import java.util.Scanner;

public class Jdi implements Command {
    @Override
    public String execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Kam?");
//        System.out.print(">> ");
//        String input = scanner.nextLine();
//
//        for (int i = 1; i < DataHry.getLocations().size(); i++) {
//            for (int j = 1; j < DataHry.getLocations().get(i).getVychody().size(); j++) {
//                if (input.equals(DataHry.getLocations().get(i).getVychody().get(j))) {
//                    for (int k = 0; k < DataHry.getLocations().size(); k++) {
//                        if (DataHry.getLocations().get(i).getVychody().get(j).equals(DataHry.getLocations().get(k).getNazev())){
//                            StavHry.setAktualniLokace(DataHry.getLocations().get(k));
//                            System.out.println(DataHry.getLocations().get(k).getNazev());
//                        }else{
//                            System.out.println("Takova moznost neni dostupna");
//                        }
//
//                    }
//                }
//            }
//        }
//       return "";

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
