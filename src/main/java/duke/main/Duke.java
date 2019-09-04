package duke.main;

import duke.command.Command;
import duke.command.ExitCommandEvent;
import duke.error.DukeException;
import duke.error.FileLoadError;
import duke.error.IncorrectDateTimeError;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;


    public Duke() {
    }

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (FileLoadError | IncorrectDateTimeError e) {
            ui.showError(e);
            tasks = new TaskList();
        }
    }

    private void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e);
            }
        }
        ui.showBye();
    }

    public String getResponse(String input) throws ExitCommandEvent {
        try {
//            String fullCommand = ui.readCommand();
            Command c = Parser.parse(input);
            String output = c.execute(tasks, ui, storage);
            if (c.isExit()) {
                throw new ExitCommandEvent();
            }
            return output;
        } catch (DukeException e) {
            return ui.showError(e);
        }
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}
