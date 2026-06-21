## Financial Forecasting Recursion Analysis

### 1. Time Complexity

| Approach | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **Standard Recursion** | **O(N)** | **O(N)** (Call Stack Overhead) |
| **Optimized Recursion** | **O(N)** | **O(N)** (Call Stack + Heap Map) |

*Note: In complex financial models where future values depend on multiple past states (e.g., branching recursive trees mimicking Fibonacci sequences), unoptimized time complexity degrades severely to **O(2^N)**.*

### 2. The Danger of Excessive Computation
While recursion is elegant, it has two major flaws in production environments:
1. **Redundant Calculations:** If a dashboard needs to render the forecast for Year 5, Year 10, and Year 15, standard recursion recalculates Year 1 through 4 from scratch every single time.
2. **Stack Overflow:** Every recursive call consumes memory on the JVM's call stack. Predicting 10,000 days into the future will crash the system with a `StackOverflowError`.

### 3. How to Optimize (Memoization)
To avoid excessive computation, we utilize **Memoization** (Caching), a core concept of Dynamic Programming. 

As implemented in the `calculateFutureValueOptimized` method, we introduce a `HashMap` to act as system memory. Before performing any recursive math for a specific period, the algorithm checks the Map. If the calculation for that year was already performed, it retrieves the answer instantly in **O(1)** time. If not, it calculates it, saves it to the Map, and passes it up. This ensures that no matter how many times the API is queried, a specific period is calculated exactly once.