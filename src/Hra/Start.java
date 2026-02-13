package Hra;

import AETHEREA.ProcentaProgresu;
import Inventář.InventarProOdpad;
import Inventář.InventarProPredmet;
import Inventář.InventarVModulu;

/**
 * Stravuje start hry.
 * * @author Katka
 */
public class Start {



    public void start(){
        DataHry data = DataHry.nacist("resources/DataHry.json");

        Konzole konzole = new Konzole();
        InventarProOdpad inventarProOdpad = new InventarProOdpad();
        ProcentaProgresu procentaProgresu = new ProcentaProgresu(0, 0);
        InventarVModulu inventarVModulu = new InventarVModulu();
        InventarProPredmet inventarProPredmet = new InventarProPredmet();
        StavHry stavHry = new StavHry(inventarProOdpad, procentaProgresu, inventarVModulu, inventarProPredmet);

        stavHry.setJeOdemcenaReaktorovaMistnost(false);
        stavHry.setMaIDkartu(false);
        stavHry.getVmodulu().nacistPredmety();

        konzole.inicialization();

        stavHry.setAktualniLokace(DataHry.getLocations().getFirst());
        konzole.execute(stavHry);
    }
}
