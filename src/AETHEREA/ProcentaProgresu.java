package AETHEREA;

import Hra.DataHry;
import Hra.StavHry;

/**
 * Reprezentuje a stravuje výpocty funkce procent ve hře.
 * Uchovává informace: procenta za místnost, procenta za celou hru a pocet sektoru.
 * * @author Katka
 */

public class ProcentaProgresu {

    private int procentaZaMistnost;
    private int procentaZaCelouHru;
    private int pocetSektoru = 0;

    /**
     * Metoda která přidává procenta.
     * Vrací procento čistoty aktuální lokace.
     * * @author Katka
     */
    public int pridatProcenta(int procenta, StavHry stavHry) {
        stavHry.getAktualniLokace().setProcentoCistoty(stavHry.getAktualniLokace().getProcentoCistoty() + procenta);
        return stavHry.getAktualniLokace().getProcentoCistoty();
    }

    /**
     * Metoda která počítá procenta za celou hru.
     * Sečte procenta všech lokací a vydělí je poctem sektorů.
     * Vrací pruměr procent na všech lokací.
     * * @author Katka
     */
    public int vypocetProcentaZaCelouHru(){
        int soucetProcent = 0;
        // Počítáme od indexu 1, protože index 0 je CSS-VAULT (základna bez odpadu)
        for (int i = 1; i < 8; i++) {
            soucetProcent += DataHry.getLocations().get(i).getProcentoCistoty();
            pocetSektoru++;
        }
        // Průměr = součet všech / 7 (počet herních sektorů)
        this.procentaZaCelouHru = soucetProcent / pocetSektoru;
        return procentaZaCelouHru;
    }

    /**
     * Metoda která počítá procenta.
     * Pokud ma lokace 100procent, nastaví JeStoProcent na true.
     * Vrací pruměr procent na všech lokací.
     * * @author Katka
     */
    public int pocitaniProcent(StavHry stavHry) {

        if (stavHry.getAktualniLokace().getProcentoCistoty()==100) {
            stavHry.getAktualniLokace().setJeStoProcent(true);
        }
        stavHry.getProcentaProgresu().vypocetProcentaZaCelouHru();

        return procentaZaCelouHru;
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

    public int getPocetSektoru() {
        return pocetSektoru;
    }

    public void setPocetSektoru(int pocetSektoru) {
        this.pocetSektoru = pocetSektoru;
    }

    @Override
    public String toString() {
        return "ProcentaProgresu{" +
                "procentaZaMistnost=" + procentaZaMistnost +
                ", procentaZaCelouHru=" + procentaZaCelouHru +
                '}';
    }
}
