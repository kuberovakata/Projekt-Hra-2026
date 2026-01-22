package Hra;
public class Start {

    Konzole konzole = new Konzole();
    public void start(){
        konzole.inicialization();
        StavHry.setAktualniLokace(DataHry.nacist("resources/DataHry.json").getLocations().get(0));
        System.out.println(DataHry.getLocations().get(0));

        konzole.execute();
    }
}
