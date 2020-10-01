import java.io.*;

/**
 * Handles reading and writing of files so the lists of
 * tasks will be saved even after closing the session
 */
public class Storage {

    public Storage(){}

    /**
     * Saves all the tasks to a txt file
     * @param tasks the TaskList that contains all the tasks
     */
    public void writeData(TaskList tasks){
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

    /**
     * Loads tasks from a txt file into tasks
     * @return a TaskList with all the tasks from txt file
     */
    public static TaskList loadData() {
        TaskList tasks = new TaskList();
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
                        tasks.addTodo(input);
                        if (isDoneStatus.equals("true")) {
                            tasks.get(tasks.size() - 1).markTaskAsDone();
                        }
                        break;
                    case "deadline":
                        tasks.addDeadline(input);
                        if (isDoneStatus.equals("true")) {
                            tasks.get(tasks.size() - 1).markTaskAsDone();
                        }
                        break;
                    case "event":
                        tasks.addEvent(input);
                        if (isDoneStatus.equals("true")) {
                            tasks.get(tasks.size() - 1).markTaskAsDone();
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
        return tasks;
    }
}
