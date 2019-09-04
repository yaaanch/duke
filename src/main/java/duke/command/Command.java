package duke.command;

import duke.error.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public abstract class Command {
    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    public boolean isExit() {
        return false;
    }
}
