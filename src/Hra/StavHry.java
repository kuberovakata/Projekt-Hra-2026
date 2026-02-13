package Hra;

import AETHEREA.Lokace;
import AETHEREA.ProcentaProgresu;
import AETHEREA.Ukol;
import Inventář.InventarProOdpad;
import Inventář.InventarProPredmet;
import Inventář.InventarVModulu;

import java.util.ArrayList;

/**
 * Reprezentuje a stravuje vsechny menitelne informace hry.
 * * @author Katka
 */
public class StavHry {

    private Lokace AktualniLokace;
    private String StavHry;
    private InventarProOdpad inventarProOdpad;
    private ProcentaProgresu procentaProgresu;
    private ArrayList<Ukol> ukoly;
    private boolean jeOdemcenaReaktorovaMistnost;
    private boolean maIDkartu;
    private InventarVModulu vmodulu;
    private InventarProPredmet proPredmet;

    public StavHry(InventarProOdpad inventarProOdpad, ProcentaProgresu procentaProgresu, InventarVModulu inventarVModulu, InventarProPredmet proPredmet) {
        this.inventarProOdpad = inventarProOdpad;
        this.procentaProgresu = procentaProgresu;
        this.vmodulu = inventarVModulu;
        this.proPredmet = proPredmet;
    }

    public boolean zkontrolujKonecMise() {

        if (!getAktualniLokace().equals(DataHry.getLocations().getFirst())) {
            return false;
        }

        for (Ukol u : DataHry.getSeznam_ukolu()) {
            if (!u.isJeSplneno()) {
                return false;
            }
        }

        procentaProgresu.vypocetProcentaZaCelouHru();
        if (getProcentaProgresu().getProcentaZaCelouHru() < 100) {
            return false;
        }

        return true; // Mise je připravena k ukončení!
    }

    public ProcentaProgresu getProcentaProgresu() {
        return procentaProgresu;
    }

    public void setProcentaProgresu(ProcentaProgresu procentaProgresu) {
        this.procentaProgresu = procentaProgresu;
    }

    public Lokace getAktualniLokace() {
        return AktualniLokace;
    }

    public void setAktualniLokace(Lokace aktualniLokace) {
        AktualniLokace = aktualniLokace;
    }

    public String getStavHry() {
        return StavHry;
    }

    public void setStavHry(String stavHry) {
        StavHry = stavHry;
    }

    public InventarProOdpad getInventářProOdpad() {
        return inventarProOdpad;
    }

    public void setInventářProOdpad(InventarProOdpad inventarProOdpad) {
        this.inventarProOdpad = inventarProOdpad;
    }

    public ArrayList<Ukol> getUkoly() {
        return ukoly;
    }

    public void setUkoly(ArrayList<Ukol> ukoly) {
        this.ukoly = ukoly;
    }

    public boolean isJeOdemcenaReaktorovaMistnost() {
        return jeOdemcenaReaktorovaMistnost;
    }

    public void setJeOdemcenaReaktorovaMistnost(boolean jeOdemcenaReaktorovaMistnost) {
        this.jeOdemcenaReaktorovaMistnost = jeOdemcenaReaktorovaMistnost;
    }

    public boolean isMaIDkartu() {
        return maIDkartu;
    }

    public void setMaIDkartu(boolean maIDkartu) {
        this.maIDkartu = maIDkartu;
    }

    public InventarVModulu getVmodulu() {
        return vmodulu;
    }

    public void setVmodulu(InventarVModulu vmodulu) {
        this.vmodulu = vmodulu;
    }

    public InventarProPredmet getProPredmet() {
        return proPredmet;
    }

    public void setProPredmet(InventarProPredmet proPredmet) {
        this.proPredmet = proPredmet;
    }
}
