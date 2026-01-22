package Hra;

import java.util.Scanner;
import java.util.HashMap;
import Command.Command;
import Command.Jdi;


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
        commands.put("jdi", new Jdi());
    }

    public void execute() {
        while (!isExit) {
            System.out.print(">> ");
            String input = scanner.nextLine();
            String command = input.trim().toLowerCase();

            if (commands.containsKey(command)) {
                System.out.println(commands.get(command).execute());
                isExit = commands.get(command).exit();
            } else {
                System.out.println("neznamy prikaz");
            }
        }
        scanner.close();
    }
}
