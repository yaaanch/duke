package duke.command;

import duke.error.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.UI;

public abstract class Command {
    public abstract void execute(TaskList tasks, UI ui, Storage storage) throws DukeException;

    public boolean isExit() {
        return false;
    }
}
