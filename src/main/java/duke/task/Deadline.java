package duke.task;

import duke.main.DateTimeParser;

import java.util.Date;

public class Deadline extends Task {

    protected Date by;

    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    public Deadline(String description, boolean isDone, Date by) {
        super(description, isDone);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + DateTimeParser.format(by) + ")";
    }

    public String toSave() {
        return "D | " + (super.isDone ? 1 : 0) + " | " + super.description + " | " + DateTimeParser.format(by);
    }
}