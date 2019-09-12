package duke.command;

import duke.error.FileLoadError;
import duke.error.IncorrectDateTimeError;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public class ViewArchiveCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws FileLoadError, IncorrectDateTimeError {
        return ui.showArchived(storage.getArchive());
    }
}
