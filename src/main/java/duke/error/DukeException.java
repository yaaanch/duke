package duke.error;

public class DukeException extends Exception {
    public DukeException(String s) {
        super("\u2639 Sorry. " + s);
    }
}
