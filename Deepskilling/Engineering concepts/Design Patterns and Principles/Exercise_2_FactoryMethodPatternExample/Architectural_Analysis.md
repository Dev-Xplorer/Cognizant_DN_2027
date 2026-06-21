# Architectural Analysis: Factory Method Design Pattern

## Executive Summary
In object-oriented design, directly instantiating objects using the `new` keyword tightly couples the client code to specific implementations. If object creation requires complex logic, scattering `new` statements throughout the application makes the codebase rigid and difficult to maintain. 

The **Factory Method Pattern** resolves this by defining an interface for creating an object, but allowing subclasses to alter the type of objects that will be created.

## The Domain Problem: Document Management
In this exercise, our Document Management System must handle Word, PDF, and Excel files. If we instantiate these directly in our application layer, adding a new format (like `PowerPointDocument`) in the future would require us to hunt down and modify existing application logic, risking new bugs.

## Implementation Architecture
1. **The Product Interface (`Document`):** Establishes a strict contract (e.g., `open()`, `save()`). The application layer only ever talks to this interface, completely ignoring the concrete implementations.
2. **The Abstract Creator (`DocumentFactory`):** Declares the `createDocument()` factory method. It defers the actual instantiation to its subclasses.
3. **Concrete Creators:** Each document type gets its own factory (e.g., `PdfDocumentFactory`). These factories encapsulate all the complex initialization logic required to build that specific object.

## Engineering Benefits
* **Loose Coupling:** The application relies on abstractions (`Document` and `DocumentFactory`), not concrete classes. 
* **Single Responsibility Principle:** The code that *uses* the document is completely separated from the code that *creates* the document.
* **Open/Closed Principle:** The system is open for extension but closed for modification. If we need to add PowerPoint support tomorrow, we simply create a `PowerPointDocument` and a `PowerPointFactory`. We do not have to touch a single line of the existing `Main.java` or other factory classes to make it work.