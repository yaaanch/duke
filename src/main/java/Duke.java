import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private UI ui;

    public Duke(String filePath) {
        ui = new UI();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (FileLoadError | IncorrectDateTimeError e) {
            ui.showError(e);
            tasks = new TaskList();
        }
    }

    public void run() {
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
        /*
        ArrayList<Task> tasks = load();

        String[] currentInputArray = currentInput.split("\\s");
        while (!currentInputArray[0].equals("bye")) {
            try {
                switch (currentInputArray[0]) {
                    case "list":
                        if (tasks.isEmpty()) {
                            System.out.print("    You have no tasks in your list.\n");
                            break;
                        }
                        System.out.print("    Here are the tasks in your list:\n" );
                        int i = 1;
                        for (Task t : tasks) {
                            System.out.print("    " + i++ + "." + t + "\n" );
                        }
                        break;
                    case "done":
                        if (currentInputArray.length < 2) throw new InsufficientArgumentError();
                        if (!currentInputArray[1].matches("-?\\d+")) throw new MissingKeywordError(MissingKeywordError.Keyword.NUMBER);
                        int doneTaskNumber = Integer.parseInt(currentInputArray[1]) - 1;
                        if (doneTaskNumber < 0 || doneTaskNumber >= tasks.size()) throw new NoSuchTaskError();
                        System.out.print("    Nice! I've marked this task as done:\n" );
                        Task doneTask = tasks.get(doneTaskNumber);
                        doneTask.setDone();
                        System.out.print("      " + doneTask + "\n" );
                        save(tasks);
                        break;
                    case "delete":
                        if (currentInputArray.length < 2) throw new InsufficientArgumentError();
                        if (!currentInputArray[1].matches("-?\\d+")) throw new MissingKeywordError(MissingKeywordError.Keyword.NUMBER);
                        int deleteTaskNumber = Integer.parseInt(currentInputArray[1]) - 1;
                        if (deleteTaskNumber < 0 || deleteTaskNumber >= tasks.size()) throw new NoSuchTaskError();
                        System.out.print("    Noted. I've removed this task:\n" );
                        System.out.print("      " + tasks.get(deleteTaskNumber) + "\n" );
                        tasks.remove(deleteTaskNumber);
                        System.out.print("    Now you have " + tasks.size() + " tasks in the list.\n");
                        save(tasks);
                        break;
                    case "todo":
                        if (currentInputArray.length < 2) throw new InsufficientArgumentError();
                        Task todo = new Todo(currentInput.substring(5));
                        tasks.add(todo);
                        System.out.print("    Got it. I've added this task:\n      " + todo
                                + "\n    Now you have " + tasks.size() + " tasks in the list.\n" );
                        save(tasks);
                        break;
                    case "deadline":
                        if (currentInputArray.length < 2) throw new InsufficientArgumentError();
                        if (!currentInput.contains(" /by ")) throw new MissingKeywordError(MissingKeywordError.Keyword.BY);
                        String[] deadlineArr = currentInput.split(" /by " );
                        if (deadlineArr.length < 2 || deadlineArr[0].length() < 10) throw new InsufficientArgumentError();
                        System.out.print(deadlineArr[1]);
                        Date deadlineDate = DateTimeParser.parse(deadlineArr[1]);
                        Task deadline = new Deadline(deadlineArr[0].substring(9), deadlineDate);
                        tasks.add(deadline);
                        System.out.print("    Got it. I've added this task:\n      " + deadline
                                + "\n    Now you have " + tasks.size() + " tasks in the list.\n" );
                        save(tasks);
                        break;
                    case "event":
                        if (currentInputArray.length < 2) throw new InsufficientArgumentError();
                        if (!currentInput.contains(" /at ")) throw new MissingKeywordError(MissingKeywordError.Keyword.AT);
                        String[] eventArr = currentInput.split(" /at " );
                        if (eventArr.length < 2 || eventArr[0].length() < 7) throw new InsufficientArgumentError();
                        Date eventDate = DateTimeParser.parse(eventArr[1]);
                        Task event = new Event(eventArr[0].substring(6), eventDate);
                        tasks.add(event);
                        System.out.print("    Got it. I've added this task:\n      " + event
                                + "\n    Now you have " + tasks.size() + " tasks in the list.\n" );
                        save(tasks);
                        break;
                    default:
                        throw new UnknownCommandError();
                }
            } catch (DukeException d){
                System.out.print(d.getMessage());
            }
            currentInput = input.nextLine();
            currentInputArray = currentInput.split("\\s");
        }
        System.out.print("    Bye. Hope to see you again soon!\n");
        */
    }
}
