package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public class HelpCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.showHelp();
    }
}
