interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing $" + amount + " via Credit Card ending in " 
                           + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements PaymentStrategy {
    private String emailId;

    public PayPalPayment(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing $" + amount + " via PayPal account: " + emailId);
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: No payment strategy selected!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        
        System.out.println("--- Customer Checkout Process ---");

        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234567890123456");
        
        PaymentContext cart = new PaymentContext(creditCard);
        cart.executePayment(250.00);

        System.out.println("\n--- Customer changes mind ---");
        System.out.println("Switching payment method to PayPal...");

        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com");
        
        cart.setPaymentStrategy(payPal);
        cart.executePayment(250.00);
    }
}