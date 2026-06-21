## Understanding the Decorator Pattern

### Why the Decorator Pattern is Needed
When you need to add new behaviors to an object, the standard object-oriented approach is to use inheritance (creating a subclass). However, inheritance is static. You cannot change how an object behaves at runtime, and if you have many optional features, you will suffer from "Class Explosion" (creating dozens of subclasses to handle every possible combination of features).

The **Decorator Pattern** offers a flexible alternative to subclassing. It allows you to attach new responsibilities to an object dynamically at runtime by placing the object inside a special wrapper class that contains these new behaviors.

## Purpose of the Notification System
In this exercise, a system needs to alert users. Some users only want Emails. Others want Emails and SMS. IT Admins might want Email, SMS, and a Slack message. Instead of writing complex `if/else` logic or creating rigid subclasses for every combination, we use Decorators. We start with a base `EmailNotifier` and dynamically wrap it in `SMS` or `Slack` decorators as needed.

## Key Components of the Decorator Pattern

### 1. Component Interface (`Notifier`)
* Defines the standard methods that both the base objects and the decorators must implement.

### 2. Concrete Component (`EmailNotifier`)
* The core, foundational object that is going to be decorated. It provides the base behavior.

### 3. Base Decorator (`NotifierDecorator`)
* An abstract class that implements the Component Interface. Crucially, it contains a field for storing a reference to a wrapped Component (`protected Notifier wrappedNotifier`). It delegates all operations to this wrapped object.

### 4. Concrete Decorators (`SMSNotifierDecorator`, `SlackNotifierDecorator`)
* Classes that extend the Base Decorator. They override the standard methods to execute their own unique behavior either *before* or *after* calling the parent method (`super.send()`).

## Working of the Decorator Pattern
1. The client wraps the base object in one or more decorators (e.g., `Slack( SMS( Email() ) )`).
2. The client calls the `send()` method on the outermost wrapper (`Slack`).
3. The `Slack` wrapper delegates the call to the object inside it (`SMS`).
4. The `SMS` wrapper delegates the call to the object inside it (`Email`).
5. The `Email` executes. Then `SMS` executes its extra feature. Finally, `Slack` executes its extra feature. 

## Benefits of Using Decorator Pattern

### Extreme Flexibility
* You can combine behaviors in completely unpredictable ways at runtime without rewriting code.

### Single Responsibility Principle
* Instead of having one massive class burdened with the logic for Email, SMS, and Slack, you divide the functionality into three small, focused classes.

### Open/Closed Principle
* You can introduce new decorators (like `WhatsAppNotifierDecorator`) without changing any of the existing code.

## Common Applications of Decorator Pattern
* **Java I/O Streams:** The entire `java.io` package is built on this. When you write `new BufferedReader(new FileReader(file))`, you are decorating a file reader with a buffering feature!
* **UI Components:** Adding scrollbars, borders, or shadows to a basic window or text box.
* **Middleware in Web Servers:** Wrapping an HTTP request object with logging, authentication, and compression decorators before passing it to the database.