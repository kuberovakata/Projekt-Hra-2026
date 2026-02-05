package Hra;
import AETHEREA.Ukol;
import Předměty.Predmet;
import com.fasterxml.jackson.databind.ObjectMapper;
import AETHEREA.Lokace;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
public class DataHry {

        private final static ObjectMapper objectMapper = new ObjectMapper();
        private static LinkedList<Lokace> locations;
        private static LinkedList<Predmet> ukolovePredmety ;
        private static ArrayList<Ukol> seznam_ukolu;

        public DataHry() {
        }

        public static DataHry nacist(String jsonPath) {

            try {
                final InputStream is = new FileInputStream(jsonPath);
                return objectMapper.readValue(is, DataHry.class);

            } catch (Exception e) {
                System.err.println(jsonPath);
                throw new RuntimeException(e);
            }
        }

        public static LinkedList<Lokace> getLocations() {
            return locations;
        }

        public void setLocations(LinkedList<Lokace> locations) {
            this.locations = locations;
        }

        public static LinkedList<Predmet> getUkolovePredmety() {
            return ukolovePredmety;
        }

        public void setUkolovePredmety(LinkedList<Predmet> ukolove_predmety) {
            this.ukolovePredmety = ukolove_predmety;
        }

        public static ArrayList<Ukol> getSeznam_ukolu() {
             return seznam_ukolu;
        }

        public void setSeznam_ukolu(ArrayList<Ukol> seznam_ukolu) {
            this.seznam_ukolu = seznam_ukolu;
        }

    @Override
    public String toString() {
            return "Default.LocationManager{" +
                "locations=" + locations +
                '}';
    }
}