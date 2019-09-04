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
        return "    " + s + "\n";
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
}
