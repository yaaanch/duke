package duke.main;

import duke.command.*;
import duke.error.InsufficientArgumentError;
import duke.error.MissingKeywordError;
import duke.error.UnknownCommandError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parse_correctCommand_success() throws Exception {
        assertTrue(Parser.parse("list") instanceof ListCommand);
        assertTrue(Parser.parse("done 2") instanceof DoneCommand);
        assertTrue(Parser.parse("delete 2") instanceof DeleteCommand);
        assertTrue(Parser.parse("todo borrow book") instanceof TodoCommand);
        assertTrue(Parser.parse("deadline return book /by 01/02/2019 0123") instanceof DeadlineCommand);
        assertTrue(Parser.parse("event book party /at 3/9/2019 2103") instanceof EventCommand);
        assertTrue(Parser.parse("bye") instanceof ExitCommand);
    }

    @Test
    void parse_incorrectCommand_exceptionThrown() {
        try {
            Parser.parse("todoo");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof UnknownCommandError);
        }
        try {
            Parser.parse("@@@@@@@@@@@");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof UnknownCommandError);
        }
        try {
            Parser.parse("todo");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof InsufficientArgumentError);
        }
        try {
            Parser.parse("deadline /by today or tomorrow");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof InsufficientArgumentError);
        }
        try {
            Parser.parse("event all the time //at today");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof MissingKeywordError);
        }
    }

}