import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        int MAX_SIZE = 100;
        Task[] tasks = new Task[MAX_SIZE];
        int idx = 0;
        String[] temp;
        String done_temp;
        int done_idx;
        int i;

        String greet = "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        String goodbye = "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";
        System.out.println(greet);

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!(input.equals("bye"))) {
            if (input.contains("list")) {
                System.out.println("Here's what you have in the list:");
                for (i = 0; i < idx; i++) {
                    System.out.println((i + 1) + ".[" + tasks[i].getStatusIcon() + "] " + tasks[i].getDescription());
                }
            } else if (input.contains("done")) {
                done_temp = input.split(" ")[1];
                done_idx = Integer.parseInt(done_temp);
                tasks[done_idx-1].markTaskAsDone();
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println(("  [" + tasks[done_idx-1].getStatusIcon() + "] " + tasks[done_idx-1].getDescription()));
            } else {
                tasks[idx] = new Task(input);
                idx++;
                System.out.println("    I added '" + input + "' to the list");
            }
            input = in.nextLine();
        }
        System.out.println(goodbye);
    }
}
