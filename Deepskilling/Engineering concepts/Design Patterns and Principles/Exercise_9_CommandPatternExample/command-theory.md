## Understanding the Command Pattern

### Why the Command Pattern is Needed
In software development, you often need to issue requests to objects without knowing anything about the operation being requested or the receiver of the request. 

If you hardcode an action directly into a UI element (like placing `light.turnOn()` directly inside a `Button` class), your `Button` class becomes permanently tied to the `Light` class. If you want that same button to turn on a TV tomorrow, you have to rewrite the button's code.

The **Command Pattern** solves this by turning the *request itself* into a standalone object. This object contains all the information about the request, allowing you to pass commands as method arguments, delay or queue a command's execution, and support undoable operations.

## Purpose of the Home Automation System
In this exercise, we are building a universal smart remote (`RemoteControl`). By using the Command Pattern, the remote does not need to know the specific details of the appliances it controls. It just holds a `Command` object and calls `.execute()`. You can program the remote to control lights, garage doors, or thermostats simply by swapping out the `Command` object.

## Key Components of the Command Pattern

### 1. Command Interface (`Command`)
* Declares a single execution method (usually `execute()`). This is the common interface that all commands must follow.

### 2. Concrete Commands (`LightOnCommand`, `LightOffCommand`)
* Classes that implement the Command interface. They hold a reference to the actual Receiver object and define exactly what should happen when `execute()` is called.

### 3. Invoker (`RemoteControl`)
* The object that initiates the request. It does not know *how* the request is fulfilled. It just holds a Command object and calls its `execute()` method when triggered.

### 4. Receiver (`Light`)
* The class that contains the actual business logic. It knows how to perform the operations required to carry out the request.

### 5. Client (`Main`)
* The application code that creates the Receiver, creates the Concrete Commands, and plugs those commands into the Invoker.

## Benefits of Using Command Pattern

### Decoupling
* The object that invokes the operation (`RemoteControl`) is completely isolated from the object that performs the operation (`Light`).

### Extensibility (Open/Closed Principle)
* You can easily add new commands (like `DimLightCommand` or `TurnOnTVCommand`) without changing a single line of code in the `RemoteControl` invoker.

### Advanced Functionality (Undo/Queues/Macros)
* Because the command is an object, you can store it in a List or Queue.