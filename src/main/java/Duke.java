import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Duke {

    static int idx = 0;
    //static ArrayList<Task> tasks = new ArrayList<>();
    static TaskList tasks = new TaskList();
    static Ui ui = new Ui();
    static Parser parser = new Parser();

    public static void main(String[] args) {

        ui.greetUser();

        loadData();

        serveUser();

        ui.goodbyeUser();

    }

    private static void loadData() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("Duke.txt"));
            String line = in.readLine();
            String isDoneStatus, command, input;
            String[] temp;
            while (line != null) {
                temp = line.split(" ", 2);
                isDoneStatus = temp[0];
                input = temp[1];
                temp = temp[1].split(" ", 2);
                command = temp[0].toLowerCase();
                switch (command) {
                    case "todo":
                        addTodo(input);
                        if (isDoneStatus.equals("true")) {
                            tasks.get(idx - 1).markTaskAsDone();
                        }
                        break;
                    case "deadline":
                        addDeadline(input);
                        if (isDoneStatus.equals("true")) {
                            tasks.get(idx - 1).markTaskAsDone();
                        }
                        break;
                    case "event":
                        addEvent(input);
                        if (isDoneStatus.equals("true")) {
                            tasks.get(idx - 1).markTaskAsDone();
                        }
                }
                line = in.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found when loading data.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void writeData() {
        try {
            PrintWriter writer = new PrintWriter("Duke.txt");
            for (Task task: tasks) {
                writer.write(task.getWritable());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found when writing data.");
        }
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
            switch (command) {
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
                    writeData();
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
            Event newEvent = parser.parseEvent(input);
            tasks.add(idx, newEvent);
            idx++;
            System.out.println("    I added '" + newEvent.getDescription() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
        }
    }

    private static void addDeadline(String input) {
        try {
            Deadline newDeadline = parser.parseDeadline(input);
            tasks.add(idx, newDeadline);
            idx++;
            System.out.println("    I added '" + newDeadline.getDescription() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    private static void addTodo(String input) {
        try {
            Todo newTodo = parser.parseTodo(input);
            tasks.add(idx, newTodo);
            idx++;
            System.out.println("    I added '" + newTodo.getDescription() + "' to the list");
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

}
