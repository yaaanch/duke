import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        ArrayList<Task> tasks = load();
        Scanner input = new Scanner(System.in);
        System.out.print("    Hello! I'm Duke!\n    What can I do for you?\n");
        String currentInput = input.nextLine();
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
    }
    public static ArrayList<Task> load() {
        File file = new File("data/duke.txt");
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
                        Deadline deadline = new Deadline(input[2], input[1].equals("1"), input[3]);
                        tasks.add(deadline);
                        break;
                    case "E":
                        Event event = new Event(input[2], input[1].equals("1"), input[3]);
                        tasks.add(event);
                        break;
                    default:
                        throw new FileLoadError();
                }
            }
        } catch (FileLoadError | FileNotFoundException e) {
            e.getMessage();
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return tasks;
    }

    public static void save(ArrayList<Task> arr) {
        Path out = Paths.get("data/duke.txt");
        ArrayList<String> strings = new ArrayList<>();
        for(Task t : arr) {
            strings.add(t.toSave());
        }
        try {
            Files.write(out, strings, Charset.defaultCharset());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
