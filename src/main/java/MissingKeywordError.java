public class MissingKeywordError extends DukeException {
    public enum Keyword {
        NUMBER, BY, AT;
    }
    public MissingKeywordError(Keyword keyword) {
        super("I need the " + getKeywordString(keyword) + " to work.");
    }
    private static String getKeywordString(Keyword keyword) {
        switch (keyword) {
            case NUMBER:
                return "number of a task";
            case BY:
                return "keyword /by";
            case AT:
                return "keyword /at";
            default:
                return "";
        }
    }
}
