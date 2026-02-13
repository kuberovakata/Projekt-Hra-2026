package Inventář;

import AETHEREA.Lokace;
import Hra.StavHry;
import Předměty.Odpad;

import java.util.ArrayList;

/**
 * Reprezentuje a stravuje inventar pro odpad.
 * * @author Katka
 */
public class InventarProOdpad {

    int hodnotaMista = 0;
    int pocetPolozek;
    ArrayList<Odpad> inventarProOdpad = new ArrayList<>();

    public InventarProOdpad() {
    }

    public void pridatOdpad(Odpad odpad, ArrayList<Odpad> odpady) {
        odpady.add(odpad);
        hodnotaMista += odpad.getVahu();
    }

    public String pridarOdpadPodleStringu(String vybranyOdpad, StavHry stavHry) {

        ArrayList<Odpad> odpadyVMistnosti = stavHry.getAktualniLokace().getOdpady();
        Lokace aktualni = stavHry.getAktualniLokace();

        Odpad nalezenyOdpad = null;
        for (Odpad o : odpadyVMistnosti) {
            if (o.getNazev().equalsIgnoreCase(vybranyOdpad)) {
                nalezenyOdpad = o;
                break;
            }
        }
        if (nalezenyOdpad == null) {
            return "Takový odpad tu SIS AI nedetekuje.";
        }

        if ((hodnotaMista + nalezenyOdpad.getVahu()) > 100) {
            return "Zásobník je plný! vrat se do CSS-VAULT a zkus to znovu.";
        }

        inventarProOdpad.add(nalezenyOdpad);
        hodnotaMista += nalezenyOdpad.getVahu();

        stavHry.getAktualniLokace().setProcentoCistoty(stavHry.getAktualniLokace().getProcentoCistoty() + nalezenyOdpad.getProgres());

        stavHry.getProcentaProgresu().pocitaniProcent(stavHry);

        odpadyVMistnosti.remove(nalezenyOdpad);


        return "Nix sebral: " + nalezenyOdpad.getNazev() + ". Aktuální náklad: " + hodnotaMista + "/100 kg.";
    }

    public void vyprazdnit() {
        inventarProOdpad.clear();
        hodnotaMista = 0;
    }

    public int getHodnotaMista() {
        return hodnotaMista;
    }

    public void setHodnotaMista(int hodnotaMista) {
        this.hodnotaMista = hodnotaMista;
    }

    public int getPocetPolozek() {
        return pocetPolozek;
    }

    public void setPocetPolozek(int pocetPolozek) {
        this.pocetPolozek = pocetPolozek;
    }

    public ArrayList<Odpad> getInventarProOdpad() {
        return inventarProOdpad;
    }

    public void setInventarProOdpad(ArrayList<Odpad> inventarProOdpad) {
        this.inventarProOdpad = inventarProOdpad;
    }

    @Override
    public String toString() {
        return "InventářProOdpad{" +
                "hodnotaMista=" + hodnotaMista +
                ", pocetPolozek=" + pocetPolozek +
                ", inventářProOdpad=" + inventarProOdpad +
                '}';
    }
}
