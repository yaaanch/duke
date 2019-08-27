package duke.error;

public class IncorrectDateTimeError extends DukeException {
    public IncorrectDateTimeError() {
        super("I need the date and time in dd/mm/yyyy hh:mm. For example, 26/01/2019 2103");
    }
}
