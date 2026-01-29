package Command;

import Inventář.InventářProOdpad;

import java.util.Scanner;

public class Vezmi implements Command {
    InventářProOdpad inventářProOdpad = new InventářProOdpad();

    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Co?");
        String input = scanner.nextLine();
        return inventářProOdpad.pridarOdpad(input);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
