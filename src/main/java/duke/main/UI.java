package duke.main;

import duke.error.DukeException;
import duke.task.Task;

import java.util.Scanner;

public class Ui {
    private Scanner input;

    public Ui() {
        input = new Scanner(System.in);
    }

    private void print(String s) {
        System.out.print("    " + s + "\n");
    }

    void showError(DukeException d) {
        print(d.getMessage());
    }

    void showWelcome() {
        print("Hello! I'm Duke!");
        print("What can I do for you?");
    }

    void showBye() {
        print("Bye. Hope to see you again soon!");
    }

    String readCommand() {
        return input.nextLine();
    }

    public void showNoTasks() {
        print("You have no tasks in your list.");
    }

    public void showNoFindTasks() {
        print("You have no tasks with that keyword in your lists.");
    }

    public void showTaskList(TaskList tasks) {
        print("Here are the tasks in your list:");
        for (String s : tasks.toUiStringList()) {
            print(s);
        }
    }

    public void showDoneTask(Task task) {
        print("Nice! I've marked this task as done:");
        print(task.toString());
    }

    public void showDeleteTask(Task task, int size) {
        print("Noted. I've removed this task:");
        print(task.toString());
        print("Now you have " + size + " tasks in the list.");
    }

    public void showAddTask(Task task, int size) {
        print("Got it. I've added this task:");
        print(task.toString());
        print("Now you have " + size + " tasks in the list.");
    }

    public void showFindTaskList(TaskList tasks) {
        print("Here are the matching tasks in your list:");
        for (String s : tasks.toUiStringList()) {
            print(s);
        }
    }
}
