package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public class ExitCommand extends Command {
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.showBye();
    }
}
