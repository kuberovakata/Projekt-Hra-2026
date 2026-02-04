package AETHEREA;

import Hra.DataHry;
import Hra.StavHry;

import java.util.ArrayList;

public class ProcentaProgresu {

    private int procentaZaMistnost;
    private int procentaZaCelouHru;

    public int pridatProcenta(int procenta, StavHry stavHry) {
        stavHry.getAktualniLokace().setProcentoCistoty(stavHry.getAktualniLokace().getProcentoCistoty() + procenta);
        return stavHry.getAktualniLokace().getProcentoCistoty();
    }

    public int vypocetProcentaZaCelouHru(){
        int soucetProcent = 0;
        // Počítáme od indexu 1, protože index 0 je CSS-VAULT (základna bez odpadu)
        for (int i = 1; i < DataHry.getLocations().size(); i++) {
            soucetProcent += DataHry.getLocations().get(i).getProcentoCistoty();
        }
        // Průměr = součet všech / 7 (počet herních sektorů)
        procentaZaCelouHru = soucetProcent / 7;
        return procentaZaCelouHru;
    }

    public String pocitaniProcent(StavHry stavHry) {

        if (stavHry.getAktualniLokace().getProcentoCistoty()==100) {
            stavHry.getAktualniLokace().setJeStoProcent(true);
        }
        stavHry.getProcentaProgresu().vypocetProcentaZaCelouHru();

        return "";
    }

    public int getProcentaZaCelouHru() {
        return procentaZaCelouHru;
    }

    public void setProcentaZaCelouHru(int procentaZaCelouHru) {
        this.procentaZaCelouHru = procentaZaCelouHru;
    }

    public ProcentaProgresu(int procentaZaCelouHru, int procentaZaMistnost) {
        this.procentaZaCelouHru = procentaZaCelouHru;
        this.procentaZaMistnost = procentaZaMistnost;
    }

    public int getProcentaZaMistnost() {
        return procentaZaMistnost;
    }

    public void setProcentaZaMistnost(int procentaZaMistnost) {
        this.procentaZaMistnost = procentaZaMistnost;
    }


    @Override
    public String toString() {
        return "ProcentaProgresu{" +
                "procentaZaMistnost=" + procentaZaMistnost +
                ", procentaZaCelouHru=" + procentaZaCelouHru +
                '}';
    }
}
