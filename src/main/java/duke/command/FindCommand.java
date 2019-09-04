package duke.command;

import duke.error.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public class FindCommand extends Command {
    private String searchTerm;

    public FindCommand(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList foundTasks = tasks.find(searchTerm);
        if (foundTasks.isEmpty()) {
            ui.showNoFindTasks();
            return;
        }
        ui.showFindTaskList(foundTasks);
    }
}
