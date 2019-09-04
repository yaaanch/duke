package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Deadline;
import duke.task.Task;

import java.util.Date;

public class DeadlineCommand extends AddCommand {
    private String description;
    private Date by;

    public DeadlineCommand(String description, Date by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task deadline = new Deadline(description, by);
        tasks.addTask(deadline);
        ui.showAddTask(deadline, tasks.getSize());
        storage.save(tasks);
    }
}
