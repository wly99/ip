import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    final static int MAX_SIZE = 100;
    static int idx = 0;
    static ArrayList<Task> tasks = new ArrayList<>();

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
                    listTasks();
                    break;
                case "done":
                    markAsDone(input);
                    break;
                case "todo":
                    addTodo(input);
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
                case "delete":
                    deleteTask(input);
                    break;
                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } while (!isBye);
    }

    private static void deleteTask(String input) {
        try {
            String[] temp_split;
            temp_split = input.split(" ");
            int index = Integer.parseInt(temp_split[1]) - 1;
            String temp_print = tasks.get(index).toString();
            tasks.remove(index);
            idx--;
            System.out.println("Noted. I've removed this task: ");
            System.out.println("  " + temp_print);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! You need to specify the task number.");
        }
    }

    private static void addEvent(String input) {
        try {
            String temp_string;
            String[] temp_split;
            temp_string = input.substring(6);
            temp_split = temp_string.split("/at");
            tasks.add(idx, new Event(temp_split[0].strip(), temp_split[1].strip()));
            idx++;
            System.out.println("    I added '" + temp_split[0].strip() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
        }
    }

    private static void addDeadline(String input) {
        try {
            String temp_string;
            String[] temp_split;
            temp_string = input.substring(9);
            temp_split = temp_string.split("/by");
            tasks.add(idx, new Deadline(temp_split[0].strip(), temp_split[1].strip()));
            idx++;
            System.out.println("    I added '" + temp_split[0].strip() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    private static void addTodo(String input) {
        try {
            tasks.add(idx, new Todo(input.substring(5)));
            idx++;
            System.out.println("    I added '" + input.substring(5) + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    private static void markAsDone(String input) {
        String done_temp;
        int done_idx;
        done_temp = input.split(" ")[1];
        done_idx = Integer.parseInt(done_temp);
        tasks.get(done_idx-1).markTaskAsDone();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println(done_idx + "." + tasks.get(done_idx-1).toString());
    }

    private static void listTasks() {
        int i;
        System.out.println("Here's what you have in the list:");
        for (i = 0; i < idx; i++) {
            System.out.println((i + 1) + "." + tasks.get(i).toString());
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
