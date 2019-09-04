package duke.command;

import duke.error.NoSuchTaskError;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public class DoneCommand extends Command {
    private int taskNumber;

    public DoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws NoSuchTaskError {
        storage.save(tasks);
        return ui.showDoneTask(tasks.doTask(taskNumber));
    }
}
