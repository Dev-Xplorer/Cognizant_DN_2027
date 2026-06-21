// 1. Interface
interface Notifier {
    void send(String message);
}

// 2. Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// 3. Abstract 
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {

        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    
// 5. Concrete Decorator 2
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack Message: " + message);
    }
}

// Test Class
public class DecoratorPatternExample {
    public static void main(String[] args) {
        String alertMessage = "Server 104 is down!";

        System.out.println("--- Scenario 1: Standard Email Alert ---");
        Notifier standardNotifier = new EmailNotifier();
        standardNotifier.send(alertMessage);

        System.out.println("\n--- Scenario 2: Email + SMS Alert ---");
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send(alertMessage);

        System.out.println("\n--- Scenario 3: Email + SMS + Slack Alert (Critical) ---");
        Notifier criticalNotifier = new SlackNotifierDecorator(
                                        new SMSNotifierDecorator(
                                            new EmailNotifier()));
        criticalNotifier.send(alertMessage);
    }
}