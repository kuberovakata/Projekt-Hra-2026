package AETHEREA;

public class Ukol {

    private String nazevMistoKonani;
    private int id;
    private String popis;
    private String nazevPotrebnyPredmet;
    private boolean jeSplneno;

    public Ukol() {
    }

    public String getNazevMistoKonani() {
        return nazevMistoKonani;
    }

    public void setNazevMistoKonani(String nazevMistoKonani) {
        this.nazevMistoKonani = nazevMistoKonani;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public String getNazevPotrebnyPredmet() {
        return nazevPotrebnyPredmet;
    }

    public void setNazevPotrebnyPredmet(String nazevPotrebnyPredmet) {
        this.nazevPotrebnyPredmet = nazevPotrebnyPredmet;
    }

    public boolean isJeSplneno() {
        return jeSplneno;
    }

    public void setJeSplneno(boolean jeSplneno) {
        this.jeSplneno = jeSplneno;
    }
}
