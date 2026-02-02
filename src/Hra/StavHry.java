package Hra;

import AETHEREA.Lokace;
import AETHEREA.ProcentaProgresu;
import Inventář.InventářProOdpad;

public class StavHry {

    private Lokace AktualniLokace;
    private String StavHry;
    private InventářProOdpad inventářProOdpad;
    private ProcentaProgresu procentaProgresu;

    public StavHry(InventářProOdpad inventářProOdpad, ProcentaProgresu procentaProgresu) {
        this.inventářProOdpad = inventářProOdpad;
        this.procentaProgresu = procentaProgresu;
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

}
