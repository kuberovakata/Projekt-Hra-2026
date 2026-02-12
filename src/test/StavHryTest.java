package test;

import AETHEREA.Lokace;
import AETHEREA.ProcentaProgresu;
import AETHEREA.Ukol;
import Hra.DataHry;
import Hra.StavHry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StavHryTest {

    // 0. Mobilní operační modul
    Lokace modul = new Lokace(
            "0", "Mobilní operační modul CSS-VAULT", "",
            "Tento modul přistál společně s Nixem v hlavním hangáru stanice. Je to tvá jediná spojnice s korporací.",
            10000000, new ArrayList<>(), new ArrayList<>(), true
    );
    // 1. Přechodová komora
    Lokace komora = new Lokace(
            "1", "Přechodová komora", "(Decontamination Bay)",
            "Relativně stabilní, ale stěny jsou pokryty žlutým slizem.",
            100, new ArrayList<>(),
            new ArrayList<>(), true
    );

    // 2. Společenská místnost a jídelna
    Lokace jidelna = new Lokace(
            "2", "Společenská místnost a jídelna", "(The Mess Hall)",
            "Dům podvodníka s různými cetkami.",
            100, new ArrayList<>(),
            new ArrayList<>(), true
    );

    // 3. Botanická laboratoř
    Lokace botanika = new Lokace(
            "3", "Botanická laboratoř", "(Hydroponics)",
            "Místo autority; může otevírat postup v ději.",
            100, new ArrayList<>(),
            new ArrayList<>(), true
    );

    // 4. Kryogenní komora
    Lokace kryo = new Lokace(
            "4", "Kryogenní komora", "(Cryo-Storage)",
            "Útulná chatrč; zde lze získat důležitý úkol.",
            100, new ArrayList<>(),
            new ArrayList<>(), true
    );

    // 5. Hlavní serverovna
    Lokace serverovna = new Lokace(
            "5", "Hlavní serverovna", "(Data Center)",
            "Místo pro průzkum a získání vzácného kamene.",
            100, new ArrayList<>(),
            new ArrayList<>(), true
    );

    // 6. Ošetřovna
    Lokace osetrovna = new Lokace(
            "6", "Ošetřovna", "(Med-Bay)",
            "Borůvkový porost; lze získat borůvky.",
            100, new ArrayList<>(),
            new ArrayList<>(), true
    );

    // 7. Reaktorová hala
    Lokace reaktor = new Lokace(
            "7", "Reaktorová hala", "(The Core)",
            "Zahrada a dílna; Gerald zde pracuje s kameny.",
            100, new ArrayList<>(),
            new ArrayList<>(), true
    );

    DataHry dataHry = new DataHry();


    public DataHry getDataHry() {
        return dataHry;
    }

    LinkedList<Lokace> vsechnyLokace = new LinkedList<>();
    ArrayList<Ukol> listUkolu = new ArrayList<>();

    @BeforeEach
    void setUp() {
        // Přidání do seznamu pro DataHry

        vsechnyLokace.add(modul);
        vsechnyLokace.add(komora);
        vsechnyLokace.add(jidelna);
        vsechnyLokace.add(botanika);
        vsechnyLokace.add(kryo);
        vsechnyLokace.add(serverovna);
        vsechnyLokace.add(osetrovna);
        vsechnyLokace.add(reaktor);

        // 1. Vytvoření jednotlivých úkolů
        Ukol ukol1 = new Ukol();
        ukol1.setId(1);
        ukol1.setNazevMistoKonani("Hlavní serverovna (Data Center)");
        ukol1.setPopis("Získej bezpečnostní záznamy z kamerového systému stanice.");
        ukol1.setNazevPotrebnyPredmet("Prázdný datový disk");
        ukol1.setJeSplneno(true);

        Ukol ukol2 = new Ukol();
        ukol2.setId(2);
        ukol2.setNazevMistoKonani("Reaktorová hala (The Core)");
        ukol2.setPopis("Zprovozni jádro instalací nové procesorové jednotky.");
        ukol2.setNazevPotrebnyPredmet("Nová procesorová jednotka");
        ukol2.setJeSplneno(true);

        Ukol ukol3 = new Ukol();
        ukol3.setId(3);
        ukol3.setNazevMistoKonani("Botanická laboratoř (Hydroponics)");
        ukol3.setPopis("Odeber vzácné biologické vzorky rostliny Aethera.");
        ukol3.setNazevPotrebnyPredmet("Odběrový box");
        ukol3.setJeSplneno(true);

        // 2. Vložení do seznamu

        listUkolu.add(ukol1);
        listUkolu.add(ukol2);
        listUkolu.add(ukol3);

        // 3. Předání do DataHry, aby metoda zkontrolujKonecMise() měla s čím pracovat

        dataHry.setSeznam_ukolu(listUkolu);
        dataHry.setLocations(vsechnyLokace);
    }

    // V DataHry.java
    public List<Ukol> getSeznamUkoluProTest() {
        return listUkolu;
    }

    public List<Lokace> getLocationsProTest() {
        return vsechnyLokace;
    }


    @Test
    void zkontrolujKonecMisePodminky() {
        ProcentaProgresu procenta = new ProcentaProgresu(0,0);
        StavHry stavHry = new StavHry(null, procenta, null, null);
        setUp();
        procenta.vypocetProcentaZaCelouHru();

        //1.
        assertSame(100, stavHry.getProcentaProgresu().getProcentaZaCelouHru());

        stavHry.setAktualniLokace(modul);
        stavHry.zkontrolujKonecMise();

        //2.
        assertEquals(stavHry.getAktualniLokace().getNazev(),dataHry.getLocations().getFirst().getNazev());

        //3.
        assertTrue(listUkolu.get(0).isJeSplneno());

    }

    @Test
    void zkontrolujKonecMiseFalse() {
        ProcentaProgresu procenta = new ProcentaProgresu(0,0);
        StavHry stavHry = new StavHry(null, procenta, null, null);
        setUp();
        procenta.vypocetProcentaZaCelouHru();
        stavHry.setAktualniLokace(osetrovna);
        stavHry.zkontrolujKonecMise();

        assertFalse(stavHry.zkontrolujKonecMise());

    }
}