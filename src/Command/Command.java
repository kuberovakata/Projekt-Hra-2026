package Command;

import Inventář.InventářProOdpad;

public interface Command {
    String execute();
    boolean exit();
}
