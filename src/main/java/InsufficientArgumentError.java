public class InsufficientArgumentError extends DukeException{
    public InsufficientArgumentError() {
        super("The description cannot be empty.");
    }
}
