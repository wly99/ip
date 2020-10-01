import java.io.*;
import java.util.Scanner;

public class Duke {

    static TaskList tasks = new TaskList();
    static Ui ui = new Ui();
    static Parser parser = new Parser();
    static Storage storage = new Storage();

    public static void main(String[] args) {

        ui.greetUser();

        tasks = storage.loadData();

        serveUser();

        ui.goodbyeUser();

    }

    private static void serveUser() {
        Scanner in = new Scanner(System.in);
        String input;
        String command;
        boolean isBye = false;
        do {
            input = in.nextLine();
            command = parser.parseCommand(input);
            switch (command) {
                case "list":
                    tasks.listTasks();
                    break;
                case "done":
                    tasks.markAsDone(input);
                    break;
                case "todo":
                    tasks.addTodo(input);
                    break;
                case "deadline":
                    tasks.addDeadline(input);
                    break;
                case "event":
                    tasks.addEvent(input);
                    break;
                case "bye":
                    isBye = true;
                    storage.writeData(tasks);
                    break;
                case "delete":
                    tasks.deleteTask(input);
                    break;
                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } while (!isBye);
    }

}
