package test;

import AETHEREA.Lokace;
import AETHEREA.ProcentaProgresu;
import Hra.DataHry;
import Hra.StavHry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProcentaProgresuTest {

    // 0. Mobilní operační modul
    Lokace modul = new Lokace(
            "0", "Mobilní operační modul CSS-VAULT", "",
            "Tento modul přistál společně s Nixem v hlavním hangáru stanice. Je to tvá jediná spojnice s korporací.",
            10000, new ArrayList<>(), new ArrayList<>(), true
    );

    // 1. Přechodová komora
    Lokace komora = new Lokace(
            "1", "Přechodová komora", "(Decontamination Bay)",
            "Relativně stabilní, ale stěny jsou pokryty žlutým slizem.",
            50, new ArrayList<>(),
            new ArrayList<>(), false
    );

    // 2. Společenská místnost a jídelna
    Lokace jidelna = new Lokace(
            "2", "Společenská místnost a jídelna", "(The Mess Hall)",
            "Dům podvodníka s různými cetkami.",
            50, new ArrayList<>(),
            new ArrayList<>(), false
    );

    // 3. Botanická laboratoř
    Lokace botanika = new Lokace(
            "3", "Botanická laboratoř", "(Hydroponics)",
            "Místo autority; může otevírat postup v ději.",
            50, new ArrayList<>(),
            new ArrayList<>(), false
    );

    // 4. Kryogenní komora
    Lokace kryo = new Lokace(
            "4", "Kryogenní komora", "(Cryo-Storage)",
            "Útulná chatrč; zde lze získat důležitý úkol.",
            50, new ArrayList<>(),
            new ArrayList<>(), false
    );

    // 5. Hlavní serverovna
    Lokace serverovna = new Lokace(
            "5", "Hlavní serverovna", "(Data Center)",
            "Místo pro průzkum a získání vzácného kamene.",
            50, new ArrayList<>(),
            new ArrayList<>(), false
    );

    // 6. Ošetřovna
    Lokace osetrovna = new Lokace(
            "6", "Ošetřovna", "(Med-Bay)",
            "Borůvkový porost; lze získat borůvky.",
            50, new ArrayList<>(),
            new ArrayList<>(), false
    );

    // 7. Reaktorová hala
    Lokace reaktor = new Lokace(
            "7", "Reaktorová hala", "(The Core)",
            "Zahrada a dílna; Gerald zde pracuje s kameny.",
            100, new ArrayList<>(),
            new ArrayList<>(), false
    );

    // Přidání do seznamu pro DataHry
    LinkedList<Lokace> vsechnyLokace = new LinkedList<>();
    DataHry dataHry = new DataHry();

    @BeforeEach
    void setUp() {
        vsechnyLokace.add(modul);
        vsechnyLokace.add(komora);
        vsechnyLokace.add(jidelna);
        vsechnyLokace.add(botanika);
        vsechnyLokace.add(kryo);
        vsechnyLokace.add(serverovna);
        vsechnyLokace.add(osetrovna);
        vsechnyLokace.add(reaktor);

        dataHry.setLocations(vsechnyLokace);
    }

    @Test
    void vypocetProcentaZaCelouHru() {
        ProcentaProgresu procenta = new ProcentaProgresu(0,0);
        StavHry stavHry = new StavHry(null, procenta, null, null);
        setUp();
        procenta.vypocetProcentaZaCelouHru();
        assertSame(57, stavHry.getProcentaProgresu().getProcentaZaCelouHru());
    }

    @Test
    void pocitaniProcent() {
        ProcentaProgresu procenta = new ProcentaProgresu(0,0);
        StavHry stavHry = new StavHry(null, procenta, null, null);
        stavHry.setAktualniLokace(reaktor);
        setUp();
        procenta.pocitaniProcent(stavHry);
        assertTrue(stavHry.getAktualniLokace().isJeStoProcent());
    }
}