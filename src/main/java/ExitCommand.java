public class ExitCommand extends Command {
    @Override
    public boolean isExit() {
        return true;
    }
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
    }
}
