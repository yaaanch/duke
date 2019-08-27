package duke.error;

public class NoSuchTaskError extends DukeException {
    public NoSuchTaskError() {
        super("There is no such task.");
    }
}
