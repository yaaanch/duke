package duke.error;

public class UnknownCommandError extends DukeException {
    public UnknownCommandError() {
        super("I don't know what that means.");
    }
}
