package Hra;

import AETHEREA.Lokace;
import AETHEREA.ProcentaProgresu;
import AETHEREA.Ukol;
import Inventář.InventářProOdpad;
import Inventář.InventářProPredmet;
import Inventář.InventářVModulu;

public class StavHry {

    private Lokace AktualniLokace;
    private String StavHry;
    private InventářProOdpad inventářProOdpad;
    private ProcentaProgresu procentaProgresu;
    private Ukol ukoly;
    private boolean jeOdemcenaReaktorovaMistnost;
    private boolean maIDkartu;
    private InventářVModulu vmodulu;
    private InventářProPredmet  proPredmet;

    public StavHry(InventářProOdpad inventářProOdpad, ProcentaProgresu procentaProgresu, InventářVModulu inventářVModulu, InventářProPredmet proPredmet) {
        this.inventářProOdpad = inventářProOdpad;
        this.procentaProgresu = procentaProgresu;
        this.vmodulu = inventářVModulu;
        this.proPredmet = proPredmet;
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

    public InventářProOdpad getInventářProOdpad() {
        return inventářProOdpad;
    }

    public void setInventářProOdpad(InventářProOdpad inventářProOdpad) {
        this.inventářProOdpad = inventářProOdpad;
    }

    public Ukol getUkoly() {
        return ukoly;
    }

    public void setUkoly(Ukol ukoly) {
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

    public InventářVModulu getVmodulu() {
        return vmodulu;
    }

    public void setVmodulu(InventářVModulu vmodulu) {
        this.vmodulu = vmodulu;
    }

    public InventářProPredmet getProPredmet() {
        return proPredmet;
    }

    public void setProPredmet(InventářProPredmet proPredmet) {
        this.proPredmet = proPredmet;
    }
}
