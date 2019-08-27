package duke.command;

import duke.error.NoSuchTaskError;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.UI;

public class DoneCommand extends Command {
    int taskNumber;
    public DoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws NoSuchTaskError {
        ui.showDoneTask(tasks.doTask(taskNumber));
        storage.save(tasks);
    }
}
