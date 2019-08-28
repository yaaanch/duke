package duke.main;

import duke.error.DukeException;
import duke.task.Task;

import java.util.Scanner;

public class UI {
    Scanner input;

    public UI() {
        input = new Scanner(System.in);
    }

    private void print(String s) {
        System.out.print("    " + s + "\n");
    }

    public void showError(DukeException d) {
        print(d.getMessage());
    }

    public void showWelcome() {
        print("Hello! I'm Duke!");
        print("What can I do for you?");
    }

    public void showBye() {
        print("Bye. Hope to see you again soon!");
    }

    public String readCommand() {
        return input.nextLine();
    }

    public void showNoTasks() {
        print("You have no tasks in your list.");
    }

    public void showTaskList(TaskList tasks) {
        print("Here are the tasks in your list:");
        for (String s : tasks.toUIStringList()) {
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
}
