package Command;

import Hra.StavHry;

import java.util.Scanner;

public class Sis implements Command {
    @Override
    public String execute() {
        System.out.println("Ahoj, jsem SIS tvoje AI asistentka jak ti mohu pomoci? : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "tip":
                return "tip pro tebe";
            case "ted":
                return "ted muzes ...";
            default:
                return "mozna priste";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
