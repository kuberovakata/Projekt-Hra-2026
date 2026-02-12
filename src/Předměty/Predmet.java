package Předměty;

/**
 * Reprezentuje a stravuje predmety.
 * * @author Katka
 */
public class Predmet {

    private int id;
    private String nazev;
    private String popis;

    public Predmet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
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

    @Override
    public String toString() {
        return "Predmet{" +
                "id=" + id +
                ", nazev='" + nazev + '\'' +
                ", popis='" + popis + '\'' +
                '}';
    }
}
