/**
 * Parses input from the user so Duke can understand it
 */
public class Parser {

    public Parser(){};

    /**
     * Parses user input to return an Event
     * @param input is user's input
     * @return an Event
     */
    public Event parseEvent(String input){
        String temp_string;
        String[] temp_split;
        temp_string = input.substring(6);
        temp_split = temp_string.split("/at");
        return new Event(temp_split[0].strip(), temp_split[1].strip());
    }

    /**
     * Parses user input to return a Deadline
     * @param input is user's input
     * @return a Deadline
     */
    public Deadline parseDeadline(String input) {
        String temp_string;
        String[] temp_split;
        temp_string = input.substring(9);
        temp_split = temp_string.split("/by");
        return new Deadline(temp_split[0].strip(), temp_split[1].strip());
    }

    /**
     * Parses user input to return a Todo
     * @param input is user's input
     * @return a Todo
     */
    public Todo parseTodo(String input) {
        return new Todo(input.substring(5));
    }

    /**
     * Parses user input to return a command
     * @param input is user's input
     * @return a String that tells Duke what commands to execute
     */
    public String parseCommand(String input) {
        String[] split = input.split(" ");
        return split[0].toLowerCase();
    }

    /**
     * Parses user input to get what user is trying to find
     * @param input is user's input
     * @return a String
     */
    public String parseFind(String input) {
        return input.substring(5);
    }
}
