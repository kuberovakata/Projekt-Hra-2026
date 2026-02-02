package Command;

import Hra.StavHry;

import java.util.Scanner;

public class Vezmi implements Command {

    public String execute(StavHry stavHry) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Co?");
        String input = scanner.nextLine();
        return stavHry.getInventářProOdpad().pridarOdpad(input, stavHry);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
