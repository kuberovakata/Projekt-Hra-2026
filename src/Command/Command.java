package Command;

import Hra.StavHry;

public interface Command {

    String execute(StavHry stavHry);
    boolean exit(StavHry stavHry);
}
