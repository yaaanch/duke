package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.UI;
import duke.task.Event;
import duke.task.Task;

import java.util.Date;

public class EventCommand extends AddCommand {
    String description;
    Date at;

    public EventCommand(String description, Date at) {
        this.description = description;
        this.at = at;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        Task event = new Event(description, at);
        tasks.addTask(event);
        ui.showAddTask(event, tasks.getSize());
        storage.save(tasks);
    }
}
