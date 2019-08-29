package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.UI;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        if (tasks.isEmpty()) {
            ui.showNoTasks();
            return;
        }
        ui.showTaskList(tasks);
    }
}