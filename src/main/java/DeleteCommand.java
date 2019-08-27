public class DeleteCommand extends Command {
    int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws DukeException {
        ui.showDeleteTask(tasks.deleteTask(taskNumber), tasks.getSize());
        storage.save(tasks);
    }
}
