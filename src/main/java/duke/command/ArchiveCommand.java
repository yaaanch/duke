package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public class ArchiveCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        String result = ui.showArchived(tasks);
        storage.archive(tasks);
        return result;
    }
}
