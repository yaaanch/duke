import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        ArrayList<String> text = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("    Hello! I'm Duke!\n    What can I do for you?");
        String currentInput = input.nextLine();
        while (!currentInput.equals("bye")) {
            if (currentInput.equals("list")) {
                int i = 1;
                for (String s : text) {
                    System.out.println("    " + i++ + ". " + s);
                }
            } else {
                System.out.println("    added: " + currentInput);
                text.add(currentInput);
            }
            currentInput = input.nextLine();
        }
        System.out.println("    Bye. Hope to see you again soon!");
    }
}
