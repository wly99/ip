public class Ui {

    public Ui(){}

    /**
     * Says goodbye to user
     */
    public static void goodbyeUser() {
        String goodbye = "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";
        System.out.println(goodbye);
    }

    /**
     * Greets user
     */
    public static void greetUser() {
        String greet = "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(greet);
    }
}
