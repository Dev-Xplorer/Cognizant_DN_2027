## Understanding Dependency Injection

### Why Dependency Injection is Needed
In standard object-oriented programming, classes often depend on other classes to function. For example, a `CustomerService` class needs a `CustomerRepository` class to fetch data from the database. 

If you write `CustomerRepository repo = new CustomerRepositoryImpl();` directly inside the `CustomerService` class, you create a **Tight Coupling**. 
* What if you want to switch to a `MongoDbRepository` tomorrow? You have to rewrite the Service class.
* What if you want to write an automated test? You can't, because the Service will actually try to connect to the live production database!

**Dependency Injection (DI)** solves this by moving the creation of the object completely outside of the class. The class simply receives the dependency from the outside (usually via its constructor).

## Purpose of the Customer Management Application
In this exercise, our `CustomerService` handles the business logic, but it needs data. Rather than building its own database connection, it demands that a `CustomerRepository` be passed into its constructor. This guarantees that our Service is purely focused on business logic and entirely decoupled from the database architecture.

## Key Components of Dependency Injection

### 1. The Dependency Interface (`CustomerRepository`)
* Defines the contract that the tool must follow. It allows the dependent class to remain completely blind to the actual implementation.

### 2. The Concrete Dependency (`CustomerRepositoryImpl`)
* The actual object that performs the low-level work (like querying a SQL database).

### 3. The Dependent Class (`CustomerService`)
* The class that needs the tool to function. It holds a reference to the interface, not the concrete class.

### 4. The Injector (`Main`)
* The system that creates the Concrete Dependency and wires it into the Dependent Class. In modern Java, frameworks like **Spring** act as the Injector (using annotations like `@Autowired`).

## Benefits of Using Dependency Injection

### Mocking and Unit Testing
* Because the dependencies are injected, you can easily inject a "Fake" or "Mock" database during testing. This allows you to test the `CustomerService` logic without actually connecting to a real database.

### Single Responsibility Principle
* The `CustomerService` no longer has to worry about the lifecycle, configuration, or creation of database connections. It only worries about business rules.

### Swapability
* You can change how data is fetched globally by simply injecting a different repository (e.g., swapping `MySqlRepository` for `PostgreSqlRepository`), without touching a single line of code in your Service layer.

## Common Applications of Dependency Injection
* **Spring Framework (Inversion of Control):** This entire framework is built on DI. You create "Beans," and the Spring Application Context automatically injects them wherever they are needed.
* **Android Development (Dagger/Hilt):** Managing complex dependencies in mobile apps to prevent memory leaks and improve testing.
* **Angular (Frontend):** Angular natively uses constructor-based DI to provide services (like HTTP clients) to UI components.