/**
 * Event typically has a description and time
 */
public class Event extends Task {

    protected String at;

    /**
     * Creates a new Event
     * @param description of the Event
     * @param at time of the Event
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String getWritable() {
        return isDone + " event " + description + " /at " + at + "\n";
    }
}
