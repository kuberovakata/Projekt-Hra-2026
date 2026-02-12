package Předměty;

/**
 * Reprezentuje a stravuje odbad.
 * * @author Katka
 */
public class Odpad {

    String nazev;
    String velikost;
    int vahu;
    int progres;

    public Odpad() {
    }

    public Odpad(String nazev, String velikost, int vahu, int progres) {
        this.nazev = nazev;
        this.velikost = velikost;
        this.vahu = vahu;
        this.progres = progres;
    }

    public int getProgres() {
        return progres;
    }

    public void setProgres(int progres) {
        this.progres = progres;
    }

    public int getVahu() {
        return vahu;
    }

    public void setVahu(int vahu) {
        this.vahu = vahu;
    }

    public String getVelikost() {
        return velikost;
    }

    public void setVelikost(String velikost) {
        this.velikost = velikost;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Override
    public String toString() {
        return "Odpad{" +
                "nazev='" + nazev + '\'' +
                ", velikost='" + velikost + '\'' +
                ", vahu=" + vahu +
                ", progres=" + progres +
                '}';
    }
}