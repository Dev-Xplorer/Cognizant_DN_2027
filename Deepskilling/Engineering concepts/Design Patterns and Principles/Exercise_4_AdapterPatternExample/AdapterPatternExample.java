interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("PayPal Gateway: Successfully processed payment of $" + amount);
    }
}

class StripeGateway {
    public void charge(double totalAmount) {
        System.out.println("Stripe Gateway: Successfully charged $" + totalAmount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.charge(amount);
    }
}

public class AdapterPatternExample {

    public static void main(String[] args) {
        
        System.out.println("--- Processing E-Commerce Cart ---");

        PayPalGateway payPalApi = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalApi);
        payPalProcessor.processPayment(150.50);

        StripeGateway stripeApi = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeApi);
        stripeProcessor.processPayment(299.99);
    }
}