package duke.main;

import duke.command.Command;
import duke.error.DukeException;
import duke.error.FileLoadError;
import duke.error.IncorrectDateTimeError;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    private Duke(String filePath) {
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

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}
