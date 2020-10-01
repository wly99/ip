public class Parser {

    public Parser(){};

    public Event parseEvent(String input){
        String temp_string;
        String[] temp_split;
        temp_string = input.substring(6);
        temp_split = temp_string.split("/at");
        return new Event(temp_split[0].strip(), temp_split[1].strip());
    }

    public Deadline parseDeadline(String input) {
        String temp_string;
        String[] temp_split;
        temp_string = input.substring(9);
        temp_split = temp_string.split("/by");
        return new Deadline(temp_split[0].strip(), temp_split[1].strip());
    }

    public Todo parseTodo(String input) {
        return new Todo(input.substring(5));
    }

    public String parseCommand(String input) {
        String[] split = input.split(" ");
        return split[0].toLowerCase();
    }

    public String parseFind(String input) {
        return input.substring(5);
    }
}
