package Hra;

import java.util.Scanner;
import java.util.HashMap;
import Command.Command;
import Command.Jdi;
import Command.Konec;
import Command.Vysyp;
import Command.Vezmi;
import Command.Help;
import Command.Info;
import Command.Sis;
import Command.Sken;
import Command.Pouzit;
import Command.Ukoncit;


/**
 * stravuje konzoli.
 * * @author Paní učítelka Míša
 */
public class Konzole {
    private HashMap<String, Command> commands;
    private boolean isExit;
    private Scanner scanner;

    public Konzole() {
        this.commands = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.isExit = false;
    }

    public void inicialization() {
        commands.put("help", new Help());
        commands.put("jdi", new Jdi());
        commands.put("info", new Info());
        commands.put("konec", new Konec());
        commands.put("vysyp", new Vysyp());
        commands.put("vezmi", new Vezmi());
        commands.put("sis", new Sis());
        commands.put("sken", new Sken());
        commands.put("pouzit", new Pouzit());
        commands.put("ukoncit", new Ukoncit());
    }

    public void execute(StavHry stavHry) {
        while (!isExit) {
            System.out.print(">> ");
            String input = scanner.nextLine();
            String command = input.trim().toLowerCase();

            if (commands.containsKey(command)) {
                System.out.println(commands.get(command).execute(stavHry));
                isExit = commands.get(command).exit(stavHry);
            } else {
                System.out.println("neznamy prikaz");
            }
        }
        scanner.close();
    }
}
