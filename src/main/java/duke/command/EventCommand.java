package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Event;
import duke.task.Task;

import java.util.Date;

public class EventCommand extends AddCommand {
    private String description;
    private Date at;

    public EventCommand(String description, Date at) {
        this.description = description;
        this.at = at;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        Task event = new Event(description, at);
        tasks.addTask(event);
        storage.save(tasks);
        return ui.showAddTask(event, tasks.getSize());
    }
}
