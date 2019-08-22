import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("    Hello! I'm Duke!\n    What can I do for you?\n");
        String currentInput = input.nextLine();
        String[] currentInputArray = currentInput.split("\\s");
        while (!currentInputArray[0].equals("bye")) {
            switch (currentInputArray[0]) {
                case "list":
                    System.out.print("    Here are the tasks in your list:\n");
                    int i = 1;
                    for (Task t : tasks) {
                        System.out.print("    " + i++ + "." + t + "\n");
                    }
                    break;
                case "done":
                    System.out.print("    Nice! I've marked this task as done:\n");
                    Task doneTask = tasks.get(Integer.parseInt(currentInputArray[1]) - 1);
                    doneTask.setDone();
                    System.out.print("    " + doneTask + "\n");
                    break;
                case "todo":
                    Task todo = new Todo(currentInput.substring(5));
                    tasks.add(todo);
                    System.out.print("    Got it. I've added this task:\n      " + todo
                            + "\n    Now you have " + tasks.size() + " tasks in the list.\n");
                    break;
                case "deadline":
                    String[] deadlineArr = currentInput.split(" /by ");
                    Task deadline = new Deadline(deadlineArr[0].substring(9), deadlineArr[1]);
                    tasks.add(deadline);
                    System.out.print("    Got it. I've added this task:\n      " + deadline
                            + "\n    Now you have " + tasks.size() + " tasks in the list.\n");
                    break;
                case "event":
                    String[] eventArr = currentInput.split(" /at ");
                    Task event = new Event(eventArr[0].substring(6), eventArr[1]);
                    tasks.add(event);
                    System.out.print("    Got it. I've added this task:\n      " + event
                            + "\n    Now you have " + tasks.size() + " tasks in the list.\n");
                    break;
                default:
                    System.out.print("    error\n");
            }
            currentInput = input.nextLine();
            currentInputArray = currentInput.split("\\s");
        }
        System.out.print("    Bye. Hope to see you again soon!\n");
    }

}
