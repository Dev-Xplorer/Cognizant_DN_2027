## Library Search Analysis

### 1. Time Complexity Matrix

| Search Algorithm | Best Case | Average Case | Worst Case | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| **Linear Search** | **O(1)** | **O(N)** | **O(N)** | **O(1)** |
| **Binary Search** | **O(1)** | **O(log N)** | **O(log N)** | **O(1)** |

### 2. Algorithmic Selection Criteria

**When to use Linear Search:**
* **Small Datasets:** If a library branch only holds 50 books, the microsecond overhead of executing a linear search is negligible.
* **Unsorted Data:** If new books are constantly dropped onto a "returns cart" in random order, linear search is the only option. Sorting the cart takes `O(N log N)` time, making it significantly slower to sort-then-search than simply scanning linearly in `O(N)` time.

**When to use Binary Search:**
* **Massive Datasets:** For a national database like the Library of Congress (containing millions of records), `O(log N)` complexity is mandatory. Binary search can locate any book out of 10 million records in just 24 operations.
* **Pre-Indexed Systems:** Binary search is ideal when the backend system naturally maintains a sorted order (e.g., maintaining an alphabetical index of titles in a database). The heavy lifting of sorting is done once upon insertion, allowing all future searches to execute instantly.