package Hra;

import AETHEREA.ProcentaProgresu;
import Inventář.InventářProOdpad;

public class Start {

    Konzole konzole = new Konzole();
    InventářProOdpad inventářProOdpad = new InventářProOdpad();
    ProcentaProgresu procentaProgresu = new ProcentaProgresu(0, 0);
    StavHry stavHry = new StavHry(inventářProOdpad,  procentaProgresu);

    public void start(){
        konzole.inicialization();
        stavHry.setAktualniLokace(DataHry.nacist("resources/DataHry.json").getLocations().get(0));
        System.out.println(DataHry.getLocations().get(0));
        System.out.println(DataHry.getLocations().get(1));

        konzole.execute(stavHry);
    }
}
