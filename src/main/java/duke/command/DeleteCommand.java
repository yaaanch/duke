package duke.command;

import duke.error.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public class DeleteCommand extends Command {
    private int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        storage.save(tasks);
        return ui.showDeleteTask(tasks.deleteTask(taskNumber), tasks.getSize());
    }
}
