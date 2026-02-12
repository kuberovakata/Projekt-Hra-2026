package Command;

import Hra.DataHry;
import Hra.StavHry;

import java.util.Scanner;

/**
 * Spravuje command Venzmi.
 * metoda execute: vezmes vybrany objdekt.
 * * @author Katka
 */
public class Vezmi implements Command {

    public String execute(StavHry stavHry) {
        Scanner scanner = new Scanner(System.in);

        if (stavHry.getAktualniLokace().equals(DataHry.getLocations().getFirst())){
            for(int i = 0; i < stavHry.getVmodulu().getPredmetyNaModulu().size(); i++){
                System.out.println(stavHry.getVmodulu().getPredmetyNaModulu().get(i).getNazev());
            }
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
        return stavHry.getInventářProOdpad().pridarOdpadPodleStringu(input, stavHry);
    }

    @Override
    public boolean exit(StavHry stavHry) {
        return false;
    }
}
