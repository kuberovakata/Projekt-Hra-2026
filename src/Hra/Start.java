package Hra;

import AETHEREA.ProcentaProgresu;
import Inventář.InventarProOdpad;
import Inventář.InventarProPredmet;
import Inventář.InventarVModulu;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static Hra.ToolBox.*;

/**
 * Stravuje start hry.
 * * @author Katka
 */
public class Start {

    /**
     * Načte a vypíše ASCII logo ze souboru logoProjekt.txt.
     * @author Katka
     */
    public void vypisLogo() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("logoProjekt.txt")) {
            if (is == null) {
                System.out.println("Logo soubor nebyl nalezen!");
                return;
            };
            String logo = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(logo);

        } catch (IOException e) {
            System.err.println("Chyba při čtení loga: " + e.getMessage());
        }
    }

    /**
     * Načte a vypíše ASCII Uvodu ze souboru UvodDoPribehu.txt.
     * @author Katka
     */
    public void vypisUvodu() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("UvodDoPribehu.txt")) {
            if (is == null) {
                System.out.println("Uvod soubor nebyl nalezen!");
                return;
            };
            String uvod = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(uvod);

        } catch (IOException e) {
            System.err.println("Chyba při čtení Uvodu: " + e.getMessage());
        }
    }

    public void dalsiuvod(){
        System.out.println(ANSI_ZELENA + "[ OK ]" + ANSI_RESET + " Podpora života aktivní.");
        System.out.println(ANSI_ZELENA + "[ OK ]" + ANSI_RESET + " Databáze lokací načtena: 7 sektorů.");
        System.out.println(ANSI_ZELENA + "[ WARNING ]" + ANSI_RESET + " Detekována biomasa: 100% zamoření stanice.");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public void sisUvod(){
        System.out.println(ANSI_ZELENA + "SIS: " + ANSI_RESET + "'Dobré ráno. Jsem tvůj asistent SIS.'");
        System.out.println(ANSI_ZELENA + "SIS: " + ANSI_RESET + "'Situace na stanici je kritická. Tvým hlavním úkolem je:'");
        System.out.println("  1. Vyčistit sektory od odpadu (příkaz " + ANSI_ZELENA + "'Vysyp'" + ANSI_RESET+" / " + ANSI_ZELENA + "'Vezmi'" + ANSI_RESET + ").");
        System.out.println("  2. Sledovat postup čištění (příkaz " + ANSI_ZELENA + "'Info'" + ANSI_RESET + ").");
        System.out.println("  3. Splnit všechny tři zásadní úkoly, který nám klijent zadal (příkaz " + ANSI_ZELENA + "'Sis'" + ANSI_RESET + ").");

        System.out.println("\n" + ANSI_ZELENA + "SIS: " + ANSI_RESET + "'Zkus začít příkazem 'jdi', ať se posunem a nasledně 'sken' pro lepší obraz.'");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────\n");
    }

    Scanner scanner = new Scanner(System.in);

    /**
     * Stravuje start hry.
     * * @author Katka
     */
    public void start(){
        DataHry data = DataHry.nacist("resources/DataHry.json");

        Konzole konzole = new Konzole();
        InventarProOdpad inventarProOdpad = new InventarProOdpad();
        ProcentaProgresu procentaProgresu = new ProcentaProgresu(0, 0);
        InventarVModulu inventarVModulu = new InventarVModulu();
        InventarProPredmet inventarProPredmet = new InventarProPredmet();
        StavHry stavHry = new StavHry(inventarProOdpad, procentaProgresu, inventarVModulu, inventarProPredmet);

        mezara();
        vypisUvodu();

        System.out.print("\n" + ANSI_ZELENA + "[ Stiskněte ENTER pro zahájení bootování systémů ] " + ANSI_RESET);
        scanner.nextLine();

        mezara();
        vypisLogo();
        mezara();
        dalsiuvod();
        mezara();
        sisUvod();

        stavHry.setJeOdemcenaReaktorovaMistnost(false);
        stavHry.setMaIDkartu(false);
        stavHry.getVmodulu().nacistPredmety();

        konzole.inicialization();

        stavHry.setAktualniLokace(DataHry.getLocations().getFirst());
        konzole.execute(stavHry);
    }
}
