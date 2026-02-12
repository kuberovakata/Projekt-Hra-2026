package Command;

import Hra.StavHry;

/**
 * Spravuje interface command.
 * * @author Katka
 */

public interface Command {

    String execute(StavHry stavHry);
    boolean exit(StavHry stavHry);
}
