package duke.main;

import duke.error.DukeException;
import duke.task.Task;

import java.util.Scanner;

public class Ui {
    private Scanner input;

    public Ui() {
        input = new Scanner(System.in);
    }

    private String print(String s) {
        return s + "\n";
    }

    public String showError(DukeException d) {
        return print(d.getMessage());
    }

    public String showWelcome() {
        return print("Hello! I'm Duke!") + print("What can I do for you?");
    }

    public String showBye() {
        return print("Bye. Hope to see you again soon!");
    }

    public String showHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append(print("There are the following commands:"));
        sb.append(print("help - This command."));
        sb.append(print("list - Lists all your existing tasks."));
        sb.append(print("find <description> - Finds a task which contains the description."));
        sb.append(print(""));
        sb.append(print("todo <description> - Creates a to-do item with a description."));
        sb.append(print("event <description> /at <date and time> -" +
                " Creates an event with a description at a certain time."));
        sb.append(print("deadline <description> /by <date and time> -" +
                " Creates a deadline with a description to be completed by a certain time."));
        sb.append(print("Examples of <date and time>: tomorrow morning, next Mon night, two Tuesdays from now."));
        sb.append(print(""));
        sb.append(print("delete <index> - Deletes the task of that index."));
        sb.append(print("done <index> - Completes the task of that index."));
        sb.append(print(""));
        sb.append(print("archive - Archives all tasks."));
        sb.append(print("view - View all archived tasks."));
        sb.append(print(""));
        sb.append(print("bye - Exits the program."));
        return sb.toString();
    }

    String readCommand() {
        return input.nextLine();
    }

    public String showNoTasks() {
        return print("You have no tasks in your list.");
    }

    public String showNoFindTasks() {
        return print("You have no tasks with that keyword in your lists.");
    }

    public String showTaskList(TaskList tasks) {
        StringBuilder sb = new StringBuilder();
        sb.append(print("Here are the tasks in your list:"));
        for (String s : tasks.toUiStringList()) {
            sb.append(print(s));
        }
        return sb.toString();
    }

    public String showDoneTask(Task task) {
        return print("Nice! I've marked this task as done:") + print(task.toString());
    }

    public String showDeleteTask(Task task, int size) {
        return print("Noted. I've removed this task:") + print(task.toString())
                + print("Now you have " + size + " tasks in the list.");
    }

    public String showAddTask(Task task, int size) {
        return print("Got it. I've added this task:") + print(task.toString())
                + print("Now you have " + size + " tasks in the list.");
    }

    public String showFindTaskList(TaskList tasks) {
        StringBuilder sb = new StringBuilder();
        sb.append(print("Here are the matching tasks in your list:"));
        for (String s : tasks.toUiStringList()) {
            sb.append(print(s));
        }
        return sb.toString();
    }

    public String showArchived(TaskList tasks) {
        StringBuilder sb = new StringBuilder();
        sb.append(print("You have archived these tasks:"));
        for (String s : tasks.toUiStringList()) {
            sb.append(print(s));
        }
        return sb.toString();
    }
}
