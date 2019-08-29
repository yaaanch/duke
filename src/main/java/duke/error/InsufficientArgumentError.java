package duke.error;

public class InsufficientArgumentError extends DukeException {
    public InsufficientArgumentError() {
        super("The description cannot be empty.");
    }
}
