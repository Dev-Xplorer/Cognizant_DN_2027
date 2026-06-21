# Exercise 6: Implementing the Proxy Pattern

## Understanding the Proxy Pattern

### Why the Proxy Pattern is Needed
Creating complex objects like remote server connections, heavy database queries, or high-resolution images consumes massive amounts of system memory and network bandwidth. If an application instantiates these heavy objects before they are actually needed by the user, performance drops dramatically.

The **Proxy Pattern** solves this by providing a surrogate or placeholder for another object. A proxy controls access to the original object, allowing you to perform operations (like delaying its creation) without changing the client's code.

## Purpose of the Image Viewer
In this exercise, we simulate a photo gallery. Instead of downloading every image when the application starts, we use `ProxyImage` objects. These proxies store the filename but delay the actual network request until the user explicitly requests to `display()` the image. 

## Key Components of the Proxy Pattern

### 1. Subject Interface (`Image`)
* Defines the common interface for both the Real Subject and the Proxy. Because both classes implement this interface, the client code can treat the Proxy exactly like the Real Subject.

### 2. Real Subject (`RealImage`)
* The actual, heavy object that contains the core business logic (e.g., executing the network download and rendering the pixels).

### 3. Proxy (`ProxyImage`)
* The lightweight stand-in. It maintains a reference to the Real Subject. It controls access to the Real Subject, determining exactly *when* and *if* the heavy object should be instantiated or accessed.

## Working of the Proxy Pattern (Lazy Initialization)
1. The client requests a new object. The system immediately returns a lightweight `ProxyImage`.
2. The client interacts with the proxy, completely unaware it is not the real object.
3. When the client calls a critical method (like `display()`), the proxy intercepts the call.
4. The proxy checks if the `RealImage` exists in memory. If not, it halts, instantiates the `RealImage` (performing the heavy download), and saves it to a variable (Caching).
5. Finally, the proxy delegates the `display()` command to the newly created `RealImage`.

## Benefits of Using Proxy Pattern

### Memory & Performance Optimization
* **Lazy Initialization** ensures that system resources are only consumed at the exact moment they are strictly required. 
* **Caching** prevents redundant network calls or database queries if the same object is requested multiple times.

### Separation of Concerns
* The `RealImage` only has to worry about rendering itself. The `ProxyImage` worries about network management, caching, and lifecycle control. 

## Common Applications of Proxy Pattern
* **Virtual Proxy:** (Our exercise). Delaying the creation of expensive objects until needed.
* **Remote Proxy:** Representing an object that exists in a completely different server or address space (e.g., Java RMI or gRPC stubs).
* **Protection/Security Proxy:** Checking if the current user has the correct admin permissions before allowing them to call the methods of the Real Subject.
* **Smart Reference:** Keeping a count of how many clients are currently using a specific object so the system knows when it is safe to delete it from memory.