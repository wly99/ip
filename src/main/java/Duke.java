import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

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
            System.out.println(input);
            input = in.nextLine();
        }
        System.out.println(goodbye);
    }
}
