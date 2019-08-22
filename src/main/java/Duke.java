import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("    Hello! I'm Duke!\n    What can I do for you?");
        String currentInput = input.nextLine();
        while (!currentInput.equals("bye")) {
            System.out.println("    " + currentInput);
            currentInput = input.nextLine();
        }
        System.out.println("    Bye. Hope to see you again soon!");
    }
}
