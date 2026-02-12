package test;

import AETHEREA.Lokace;
import Command.Vysyp;
import Hra.DataHry;
import Hra.StavHry;
import Inventář.InventářProOdpad;
import Předměty.Odpad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class VysypTest {

    InventářProOdpad inventářProOdpad = new InventářProOdpad();
    StavHry stavHry = new StavHry(inventářProOdpad, null, null, null);


    Odpad odpad0 = new Odpad( "Žlutý sliz", "střední", 15, 15 );
    Odpad odpad1 = new Odpad( "Zkroucený plát ventilace", "velký", 40, 25 );

    Lokace lokace = new Lokace(
            "0",
            "Mobilní operační modul CSS-VAULT",
            null,
            "Tento modul přistál společně s Nixem v hlavním hangáru stanice. Je to tvá jediná spojnice s korporací.",
            100,
            null,
            null,
            true);
    DataHry dataHry = new DataHry();
    LinkedList<Lokace> LokaceProDataHry = new LinkedList<>();

    @BeforeEach
    void setUp() {
        stavHry.setAktualniLokace(lokace);
        LokaceProDataHry.add(lokace);
        dataHry.setLocations(LokaceProDataHry);
        stavHry.getInventářProOdpad().pridatOdpad(odpad0, stavHry.getInventářProOdpad().getInventářProOdpad());
        stavHry.getInventářProOdpad().pridatOdpad(odpad1, stavHry.getInventářProOdpad().getInventářProOdpad());
    }

    @Test
    void executeVysyp() {
        Vysyp vysyp = new Vysyp();
        setUp();
        vysyp.execute(stavHry);
        assertSame(0,stavHry.getInventářProOdpad().getInventářProOdpad().size());
    }

    @Test
    void executeHodnotaMista() {
        Vysyp vysyp = new Vysyp();
        setUp();
        vysyp.execute(stavHry);
        assertSame(0, stavHry.getInventářProOdpad().getHodnotaMista());
    }
}