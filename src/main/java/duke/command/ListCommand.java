package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public class ListCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.isEmpty()) {
            return ui.showNoTasks();
        }
        return ui.showTaskList(tasks);
    }
}
