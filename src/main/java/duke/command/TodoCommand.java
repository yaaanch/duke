package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.UI;
import duke.task.Task;
import duke.task.Todo;

public class TodoCommand extends AddCommand {
    String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        Task todo = new Todo(description);
        tasks.addTask(todo);
        ui.showAddTask(todo, tasks.getSize());
        storage.save(tasks);
    }
}
