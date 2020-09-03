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
        String[] split = input.split(" ");
        String[] temp_split;
        String temp_string;
        while (!(split[0].equals("bye"))) {
            if (split[0].equals("list")) {
                System.out.println("Here's what you have in the list:");
                for (i = 0; i < idx; i++) {
                    System.out.println((i + 1) + tasks[i].toString());
                }
            } else if (split[0].equals("done")) {
                done_temp = input.split(" ")[1];
                done_idx = Integer.parseInt(done_temp);
                tasks[done_idx-1].markTaskAsDone();
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println(done_idx +"." + tasks[done_idx-1].toString());
            } else if (split[0].equals("todo")) {
                tasks[idx] = new Todo(input.substring(5));
                idx++;
                System.out.println("    I added '" + input.substring(5) + "' to the list");
            } else if (split[0].equals("deadline")) {
                temp_string = input.substring(9);
                temp_split = temp_string.split("/by");
                tasks[idx] = new Deadline(temp_split[0].strip(), temp_split[1].strip());
                idx++;
            } else if (split[0].equals("event")) {
                temp_string = input.substring(6);
                temp_split = temp_string.split("/at");
                tasks[idx] = new Event(temp_split[0].strip(), temp_split[1].strip());
                idx++;
            }
            input = in.nextLine();
            split = input.split(" ");
        }
        System.out.println(goodbye);
    }
}
