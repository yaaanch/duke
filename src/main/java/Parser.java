import java.util.Date;

public class Parser {
    public static Command parse(String input) throws DukeException {
        String[] currentInputArray = input.split("\\s");
        switch (currentInputArray[0]) {
            case "list":
                return new ListCommand();
            case "done":
                if (currentInputArray.length < 2) throw new MissingKeywordError(MissingKeywordError.Keyword.NUMBER);
                if (!currentInputArray[1].matches("-?\\d+")) throw new MissingKeywordError(MissingKeywordError.Keyword.NUMBER);
                int doneTaskNumber = Integer.parseInt(currentInputArray[1]) - 1;
                return new DoneCommand(doneTaskNumber);
            case "delete":
                if (currentInputArray.length < 2) throw new MissingKeywordError(MissingKeywordError.Keyword.NUMBER);
                if (!currentInputArray[1].matches("-?\\d+")) throw new MissingKeywordError(MissingKeywordError.Keyword.NUMBER);
                int deleteTaskNumber = Integer.parseInt(currentInputArray[1]) - 1;
                return new DeleteCommand(deleteTaskNumber);
            case "todo":
                if (currentInputArray.length < 2) throw new InsufficientArgumentError();
                return new TodoCommand(input.substring(5));
            case "deadline":
                if (currentInputArray.length < 2) throw new InsufficientArgumentError();
                if (!input.contains(" /by ")) throw new MissingKeywordError(MissingKeywordError.Keyword.BY);
                String[] deadlineArr = input.split(" /by " );
                if (deadlineArr.length < 2 || deadlineArr[0].length() < 10) throw new InsufficientArgumentError();
                Date deadlineDate = DateTimeParser.parse(deadlineArr[1]);
                return new DeadlineCommand(deadlineArr[0].substring(9), deadlineDate);
            case "event":
                if (currentInputArray.length < 2) throw new InsufficientArgumentError();
                if (!input.contains(" /at ")) throw new MissingKeywordError(MissingKeywordError.Keyword.AT);
                String[] eventArr = input.split(" /at " );
                if (eventArr.length < 2 || eventArr[0].length() < 7) throw new InsufficientArgumentError();
                Date eventDate = DateTimeParser.parse(eventArr[1]);
                return new EventCommand(eventArr[0].substring(6), eventDate);
            case "bye":
                return new ExitCommand();
            default:
                throw new UnknownCommandError();
        }
    }
}
