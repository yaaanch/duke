public class MissingKeywordError extends DukeException {
    public enum Keyword {
        BY, AT;
    }
    public MissingKeywordError(Keyword keyword) {
        super("I need the keyword " + getKeywordString(keyword) + " to work.");
    }
    private static String getKeywordString(Keyword keyword) {
        switch (keyword) {
            case BY:
                return "/by";
            case AT:
                return "/at";
            default:
                return "";
        }
    }
}
