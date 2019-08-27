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
