package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.UI;

public class ExitCommand extends Command {
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
    }
}
