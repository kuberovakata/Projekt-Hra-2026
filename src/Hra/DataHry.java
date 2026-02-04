package Hra;
import Předměty.Predmet;
import com.fasterxml.jackson.databind.ObjectMapper;
import AETHEREA.Lokace;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
public class DataHry {

        private final static ObjectMapper objectMapper = new ObjectMapper();
        private static LinkedList<Lokace> locations;
        private static LinkedList<Predmet> ukolovePredmety ;

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

    @Override
    public String toString() {
            return "Default.LocationManager{" +
                "locations=" + locations +
                '}';
    }
}