import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        int MAX_SIZE = 100;
        String[] data = new String[MAX_SIZE];
        int idx = 0;
        String[] temp;
        int i;

        String greet = "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        String goodbye = "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";
        System.out.println(greet);

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!(input.equals("bye"))){
            switch (input){
                case "list":
                    System.out.println("Here's what you have in the list:");
                    for (i=0; i<idx; i++){
                        System.out.println((i+1) + ". " + data[i]);
                    }
                    break;
                default:
                    data[idx] = input;
                    idx++;
                    System.out.println("    I added '" + input + "' to the list");
                    break;
            }
            input = in.nextLine();
        }
        System.out.println(goodbye);
    }
}
