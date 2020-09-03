import java.util.Scanner;

public class Duke {

    final static int MAX_SIZE = 100;
    static int idx = 0;
    static Task[] tasks = new Task[MAX_SIZE];

    public static void main(String[] args) {

        greetUser();

        serveUser();

        goodbyeUser();

    }

    private static void serveUser() {
        Scanner in = new Scanner(System.in);
        String input;
        String[] split;
        String command;
        boolean isBye = false;
        do {
            input = in.nextLine();
            split = input.split(" ");
            command = split[0].toLowerCase();
            switch (command){
                case "list":
                    listTasks(tasks, idx);
                    break;
                case "done":
                    markAsDone(tasks, input);
                    break;
                case "todo":
                    addTodo(tasks, input);
                    break;
                case "deadline":
                    addDeadline(input);
                    break;
                case "event":
                    addEvent(input);
                    break;
                case "bye":
                    isBye = true;
                    break;
            }
        } while (!isBye);
    }

    private static void addEvent(String input) {
        String temp_string;
        String[] temp_split;
        temp_string = input.substring(6);
        temp_split = temp_string.split("/at");
        tasks[idx] = new Event(temp_split[0].strip(), temp_split[1].strip());
        idx++;
        System.out.println("    I added '" + temp_split[0].strip() + "' to the list");
    }

    private static void addDeadline(String input) {
        String temp_string;
        String[] temp_split;
        temp_string = input.substring(9);
        temp_split = temp_string.split("/by");
        tasks[idx] = new Deadline(temp_split[0].strip(), temp_split[1].strip());
        idx++;
        System.out.println("    I added '" + temp_split[0].strip() + "' to the list");
    }

    private static void addTodo(Task[] tasks, String input) {
        tasks[idx] = new Todo(input.substring(5));
        idx++;
        System.out.println("    I added '" + input.substring(5) + "' to the list");
    }

    private static void markAsDone(Task[] tasks, String input) {
        String done_temp;
        int done_idx;
        done_temp = input.split(" ")[1];
        done_idx = Integer.parseInt(done_temp);
        tasks[done_idx-1].markTaskAsDone();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println(done_idx + "." + tasks[done_idx-1].toString());
    }

    private static void listTasks(Task[] tasks, int idx) {
        int i;
        System.out.println("Here's what you have in the list:");
        for (i = 0; i < idx; i++) {
            System.out.println((i + 1) + "." + tasks[i].toString());
        }
    }

    private static void goodbyeUser() {
        String goodbye = "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";
        System.out.println(goodbye);
    }

    private static void greetUser() {
        String greet = "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(greet);
    }
}
