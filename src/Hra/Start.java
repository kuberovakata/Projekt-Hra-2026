package Hra;

import AETHEREA.ProcentaProgresu;
import Inventář.InventářProOdpad;
import Inventář.InventářProPredmet;
import Inventář.InventářVModulu;

public class Start {



    public void start(){
        DataHry data = DataHry.nacist("resources/DataHry.json");

        Konzole konzole = new Konzole();
        InventářProOdpad inventářProOdpad = new InventářProOdpad();
        ProcentaProgresu procentaProgresu = new ProcentaProgresu(0, 0);
        InventářVModulu inventářVModulu = new InventářVModulu();
        InventářProPredmet inventářProPredmet = new InventářProPredmet();
        StavHry stavHry = new StavHry(inventářProOdpad, procentaProgresu, inventářVModulu, inventářProPredmet);

        stavHry.setJeOdemcenaReaktorovaMistnost(false);
        stavHry.setMaIDkartu(false);
        stavHry.getVmodulu().nacistPredmety();

        konzole.inicialization();

        stavHry.setAktualniLokace(DataHry.getLocations().getFirst());
        System.out.println(DataHry.getLocations().get(0));
        System.out.println(DataHry.getLocations().get(1));
        System.out.println(DataHry.getUkolovePredmety().get(0));

        konzole.execute(stavHry);
    }
}
