package Command;

import Hra.DataHry;
import Hra.StavHry;

import java.util.Scanner;

public class Vezmi implements Command {

    public String execute(StavHry stavHry) {
        Scanner scanner = new Scanner(System.in);

        if (stavHry.getAktualniLokace().equals(DataHry.getLocations().getFirst())){
            DataHry.getUkolovePredmety();
            System.out.println("Co si ches vzit?");
            String imput = scanner.nextLine();

            return stavHry.getProPredmet().nastavitAktualniPredmet(imput, stavHry);
        }




        System.out.println("Co?");
        String input = scanner.nextLine();


        if (input.equalsIgnoreCase("karta") && stavHry.getAktualniLokace().equals(DataHry.getLocations().get(4)) && !stavHry.isMaIDkartu()) {
            stavHry.setMaIDkartu(true);
            return "uspesne jsi nasel ID kartu";
        }
        return stavHry.getInventářProOdpad().pridarOdpad(input, stavHry);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
