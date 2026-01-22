package Hra;

import AETHEREA.Lokace;

public class StavHry {
    private static Lokace AktualniLokace;
    private static String StavHry;

    public static Lokace getAktualniLokace() {
        return AktualniLokace;
    }
    public static void setAktualniLokace(Lokace aktualniLokace) {
        AktualniLokace = aktualniLokace;
    }
    public static String getStavHry() {
        return StavHry;
    }
    public static void setStavHry(String stavHry) {
        StavHry = stavHry;
    }
}
