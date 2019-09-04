package duke.main;

import duke.error.FileLoadError;
import duke.error.IncorrectDateTimeError;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    ArrayList<Task> load() throws FileLoadError, IncorrectDateTimeError {
        File file = new File(filePath);
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data;
            String[] input;
            while ((data = br.readLine()) != null) {
                input = data.split(" \\| ");
                switch (input[0]) {
                case "T":
                    Todo todo = new Todo(input[2], input[1].equals("1"));
                    tasks.add(todo);
                    break;
                case "D":
                    Deadline deadline = new Deadline(input[2], input[1].equals("1"), DateTimeParser.parse(input[3]));
                    tasks.add(deadline);
                    break;
                case "E":
                    Event event = new Event(input[2], input[1].equals("1"), DateTimeParser.parse(input[3]));
                    tasks.add(event);
                    break;
                default:
                    throw new FileLoadError();
                }
            }
        } catch (IOException e) {
            throw new FileLoadError();
        }
        return tasks;
    }

    public void save(TaskList tasks) {
        Path out = Paths.get(filePath);
        if (Files.notExists(out)) {
            try {
                if (!Files.exists(out.getParent())) {
                    Files.createDirectories(out.getParent());
                }
                Files.createFile(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(out, tasks.toSaveStringList(), Charset.defaultCharset());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
