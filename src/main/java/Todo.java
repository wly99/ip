/**
 * Todo only has a description
 */
public class Todo extends Task {

    /**
     * Creates new Todo
     * @param description of Todo
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * @return a String for printing
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * @return a String to write to txt file
     */
    @Override
    public String getWritable() {
        return isDone + " todo " + description + "\n";
    }

}
