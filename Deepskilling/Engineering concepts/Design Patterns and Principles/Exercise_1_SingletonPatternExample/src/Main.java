public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application has started.");
        logger2.log("A new user just logged in.");

        System.out.println("\n--- Memory Test ---");
        if (logger1 == logger2) {
            System.out.println("Success: logger1 and logger2 are the exact same object in memory!");
        } else {
            System.out.println("Failed: They are different objects.");
        }
    }
}