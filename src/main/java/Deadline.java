/**
 * Deadline typically has a description and time
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Creates new Deadline
     * @param description of Deadline
     * @param by time of Deadline
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Sets time of Deadline
     * @param by time of Deadline
     */
    public void setBy(String by) {
        this.by = by;
    }

    /**
     * Get the time of Deadline
     * @return the time of Deadline
     */
    public String getBy() {
        return by;
    }

    /**
     * Gets a String description of Deadline for easy printing
     * @return a String of Deadline
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * Parses Deadline in a nice format for writing to a txt file
     * @return a String to write to txt file
     */
    @Override
    public String getWritable() {
        return isDone + " deadline " + description + " /by " + by + "\n";
    }
}
