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
