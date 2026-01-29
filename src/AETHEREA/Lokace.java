package AETHEREA;

import Předměty.Odpad;

import java.util.ArrayList;

public class Lokace {


    private String id;
    private String nazev;
    private String popis;
    private ArrayList<String> vychody;
    private ArrayList<Odpad> odpady;

    public Lokace() {
    }

    public String getNazev() {
        return nazev;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public ArrayList<String> getVychody() {
        return vychody;
    }

    public void setVychody(ArrayList<String> vychody) {
        this.vychody = vychody;
    }

    public ArrayList<Odpad> getOdpady() {
        return odpady;
    }

    public void setOdpady(ArrayList<Odpad> odpady) {
        this.odpady = odpady;
    }

    @Override
    public String toString() {
        return "Lokace{" +
                "id='" + id + '\'' +
                ", nazev='" + nazev + '\'' +
                ", popis='" + popis + '\'' +
                ", vychody=" + vychody +
                ", odpady=" + odpady +
                '}';
    }
}
