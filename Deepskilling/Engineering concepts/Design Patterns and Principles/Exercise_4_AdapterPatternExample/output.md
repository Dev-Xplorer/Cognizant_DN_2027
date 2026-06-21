## Output

```text
--- Processing E-Commerce Cart ---
PayPal Gateway: Successfully processed payment of $150.5
Stripe Gateway: Successfully charged $299.99

```

## Result
The Adapter Pattern was successfully implemented. The application code was able to interact with different payment gateways using a single, unified PaymentProcessor interface without modifying the third-party gateway classes.