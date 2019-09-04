package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Task;
import duke.task.Todo;

public class TodoCommand extends AddCommand {
    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        Task todo = new Todo(description);
        tasks.addTask(todo);
        storage.save(tasks);
        return ui.showAddTask(todo, tasks.getSize());
    }
}
