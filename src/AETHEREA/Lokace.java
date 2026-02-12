package AETHEREA;

import Předměty.Odpad;

import java.util.ArrayList;

/**
 * Reprezentuje jednotlivé místnosti na vesmírné stanici.
 * Uchovává informace: id, nazev, podtitulek, popis, procento cistity, vychody, odpady a boolean je sto procent.
 * * @author Katka
 */

public class Lokace {

    private String id;
    private String nazev;
    private String podtitulek;
    private String popis;
    private int procentoCistoty;
    private ArrayList<String> vychody;
    private ArrayList<Odpad> odpady;
    private boolean jeStoProcent;

    public Lokace() {
    }

    public Lokace(String id, String nazev, String podtitulek, String popis, int procentoCistoty, ArrayList<String> vychody, ArrayList<Odpad> odpady, boolean jeStoProcent) {
        this.id = id;
        this.nazev = nazev;
        this.podtitulek = podtitulek;
        this.popis = popis;
        this.procentoCistoty = procentoCistoty;
        this.vychody = vychody;
        this.odpady = odpady;
        this.jeStoProcent = jeStoProcent;
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

    public int getProcentoCistoty() {
        return procentoCistoty;
    }

    public void setProcentoCistoty(int procentoCistoty) {
        this.procentoCistoty = procentoCistoty;
    }

    public boolean isJeStoProcent() {
        return jeStoProcent;
    }

    public void setJeStoProcent(boolean jeStoProcent) {
        this.jeStoProcent = jeStoProcent;
    }

    public String getPodtitulek() {
        return podtitulek;
    }

    public void setPodtitulek(String podtitulek) {
        this.podtitulek = podtitulek;
    }

    @Override
    public String toString() {
        return "Lokace{" +
                "id='" + id + '\'' +
                ", nazev='" + nazev + '\'' +
                ", podtitulek='" + podtitulek + '\'' +
                ", popis='" + popis + '\'' +
                ", procentoCistoty=" + procentoCistoty +
                ", vychody=" + vychody +
                ", odpady=" + odpady +
                ", jeStoProcent=" + jeStoProcent +
                '}';
    }
}
