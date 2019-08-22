import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.print("    Hello! I'm Duke!\n    What can I do for you?\n");
        String currentInput = input.next();
        while (!currentInput.equals("bye")) {
            if (currentInput.equals("list")) {
                System.out.print("    Here are the tasks in your list:\n");
                int i = 1;
                for (Task t : tasks) {
                    System.out.print("    " + i++ + "." + t.getStatement() + "\n");
                }
                System.out.print(input.nextLine());
            } else if (currentInput.equals("done")) {
                System.out.print("    Nice! I've marked this task as done:\n");
                Task t = tasks.get(input.nextInt() - 1);
                t.setDone();
                System.out.print("    " + t.getStatement() + "\n");
                input.nextLine();
            } else {
                currentInput += input.nextLine();
                System.out.print("    added: " + currentInput + "\n");
                tasks.add(new Task(currentInput));
            }
            currentInput = input.next();
        }
        System.out.print("    Bye. Hope to see you again soon!\n");
    }
}
