# Exercise 8: Implementing the Strategy Pattern

## Understanding the Strategy Pattern

### Why the Strategy Pattern is Needed
In software development, you frequently encounter scenarios where an application needs to perform a specific task (like sorting data, routing a map, or processing a payment), but there are multiple ways (algorithms) to accomplish that task.

Without the Strategy Pattern, developers usually place all these algorithms inside a single class and use massive `if/else` or `switch` statements to choose between them:
```java
if (type.equals("CreditCard")) {
    // 50 lines of Credit Card logic
} else if (type.equals("PayPal")) {
    // 50 lines of PayPal logic
} else if (type.equals("Crypto")) { ... }