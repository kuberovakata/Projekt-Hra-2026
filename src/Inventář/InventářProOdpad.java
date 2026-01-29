package Inventář;

import AETHEREA.Lokace;
import Hra.StavHry;
import Předměty.Odpad;

import java.util.ArrayList;

public class InventářProOdpad {

    int hodnotaMista = 0;
    int pocetPolozek;
    ArrayList<Odpad> inventářProOdpad = new ArrayList<>();

    public InventářProOdpad() {
    }

    public String pridarOdpad(String vybranyOdpad){

        ArrayList<Odpad> odpadyVMistnosti = StavHry.getAktualniLokace().getOdpady();
        Lokace aktualni = StavHry.getAktualniLokace();

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
        inventářProOdpad.add(nalezenyOdpad);
        hodnotaMista += nalezenyOdpad.getVahu();
        odpadyVMistnosti.remove(nalezenyOdpad);

        return "Nix sebral: " + nalezenyOdpad.getNazev() + ". Aktuální náklad: " + hodnotaMista + "/100 kg.";
    }

    public void vyprazdnit() {
        inventářProOdpad.clear();
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

    public ArrayList<Odpad> getInventářProOdpad() {
        return inventářProOdpad;
    }

    public void setInventářProOdpad(ArrayList<Odpad> inventářProOdpad) {
        this.inventářProOdpad = inventářProOdpad;
    }

    @Override
    public String toString() {
        return "InventářProOdpad{" +
                "hodnotaMista=" + hodnotaMista +
                ", pocetPolozek=" + pocetPolozek +
                ", inventářProOdpad=" + inventářProOdpad +
                '}';
    }
}
