import java.util.Date;

public class Event extends Task {
    protected Date at;

    public Event(String description, Date at) {
        super(description);
        this.at = at;
    }

    public Event(String description, boolean isDone, String at) {
        super(description, isDone);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + DateTimeParser.format(at) + ")";
    }

    public String toSave() {
        return "E | " + (super.isDone ? 1 : 0) + " | " + super.description + " | " + at;
    }
}
