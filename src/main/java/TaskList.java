import java.util.ArrayList;
import java.util.Iterator;

public class TaskList implements Iterable<Task> {

    private static ArrayList<Task> tasks;
    private static Parser parser = new Parser();

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public Task get(int index){
        return tasks.get(index);
    }

    public void remove(int index){
        tasks.remove(index);
    }

    public int size(){
        return tasks.size();
    }

    public void add(int index, Task task){
        tasks.add(index, task);
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    public static void listTasks() {
        System.out.println("Here's what you have in the list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i).toString());
        }
    }

    public static void deleteTask(String input) {
        try {
            String[] temp_split;
            temp_split = input.split(" ");
            int index = Integer.parseInt(temp_split[1]) - 1;
            String temp_print = tasks.get(index).toString();
            tasks.remove(index);
            System.out.println("Noted. I've removed this task: ");
            System.out.println("  " + temp_print);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! You need to specify the task number.");
        }
    }

    public static void addEvent(String input) {
        try {
            Event newEvent = parser.parseEvent(input);
            tasks.add(tasks.size(), newEvent);
            System.out.println("    I added '" + newEvent.getDescription() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
        }
    }

    public static void addDeadline(String input) {
        try {
            Deadline newDeadline = parser.parseDeadline(input);
            tasks.add(tasks.size(), newDeadline);
            System.out.println("    I added '" + newDeadline.getDescription() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    public static void addTodo(String input) {
        try {
            Todo newTodo = parser.parseTodo(input);
            tasks.add(tasks.size(), newTodo);
            System.out.println("    I added '" + newTodo.getDescription() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    public static void markAsDone(String input) {
        String done_temp;
        int done_idx;
        done_temp = input.split(" ")[1];
        done_idx = Integer.parseInt(done_temp);
        tasks.get(done_idx-1).markTaskAsDone();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println(done_idx + "." + tasks.get(done_idx-1).toString());
    }
}
