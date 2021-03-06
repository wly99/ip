import java.util.ArrayList;
import java.util.Iterator;

/**
 * TaskList handles all the editing and saving of the tasks
 */
public class TaskList implements Iterable<Task> {

    private static ArrayList<Task> tasks;
    private static Parser parser = new Parser();

    /**
     * Creates new empty TaskList
     */
    public TaskList(){
        tasks = new ArrayList<>();
    }

    /**
     * Gets a Task object at specified index
     * @param index of object that you want
     * @return a Task at specified index
     */
    public Task get(int index){
        return tasks.get(index);
    }

    /**
     * @return int the number of tasks
     */
    public int size(){
        return tasks.size();
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    /**
     * Lists tasks for user to see
     */
    public static void listTasks() {
        System.out.println("Here's what you have in the list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i).toString());
        }
    }

    /**
     * Delete task
     * @param input containes the index of task to be deleted
     */
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

    /**
     * @param input contains Event to be added
     */
    public static void addEvent(String input) {
        try {
            Event newEvent = parser.parseEvent(input);
            tasks.add(tasks.size(), newEvent);
            System.out.println("    I added '" + newEvent.getDescription() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
        }
    }

    /**
     * @param input contains Deadline to be added
     */
    public static void addDeadline(String input) {
        try {
            Deadline newDeadline = parser.parseDeadline(input);
            tasks.add(tasks.size(), newDeadline);
            System.out.println("    I added '" + newDeadline.getDescription() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    /**
     * @param input contains Todo to be added
     */
    public static void addTodo(String input) {
        try {
            Todo newTodo = parser.parseTodo(input);
            tasks.add(tasks.size(), newTodo);
            System.out.println("    I added '" + newTodo.getDescription() + "' to the list");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    /**
     * @param input contains Task to be marked as done
     */
    public static void markAsDone(String input) {
        String done_temp;
        int done_idx;
        done_temp = input.split(" ")[1];
        done_idx = Integer.parseInt(done_temp);
        tasks.get(done_idx-1).markTaskAsDone();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println(done_idx + "." + tasks.get(done_idx-1).toString());
    }

    /** Print tasks that match the search query
     * @param input contains the words to search for
     */
    public void find(String input) {
        System.out.println("Here are the matching tasks in your list:");
        int result_index = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(input)) {
                System.out.println((result_index + 1) + "." + tasks.get(i).toString());
                result_index++;
            }
        }
    }
}
