package Inventář;

import Hra.DataHry;
import Předměty.Predmet;

import java.util.ArrayList;

/**
 * Reprezentuje a stravuje inventar v modulu.
 * * @author Katka
 */
public class InventarVModulu {

    private ArrayList<Predmet> predmetyNaModulu = new ArrayList<>();

    public InventarVModulu() {
    }

    public ArrayList<Predmet> nacistPredmety() {

        for (int i = 0; i < DataHry.getUkolovePredmety().size(); i++) {
            predmetyNaModulu.add(DataHry.getUkolovePredmety().get(i));
        }
        return predmetyNaModulu;
    }

    public ArrayList<Predmet> getPredmetyNaModulu() {
        return predmetyNaModulu;
    }

    public void setPredmetyNaModulu(ArrayList<Predmet> predmetyNaModulu) {
        this.predmetyNaModulu = predmetyNaModulu;
    }

    @Override
    public String toString() {
        return "InventářVModulu{" +
                "predmetyNaModulu=" + predmetyNaModulu +
                '}';
    }
}
