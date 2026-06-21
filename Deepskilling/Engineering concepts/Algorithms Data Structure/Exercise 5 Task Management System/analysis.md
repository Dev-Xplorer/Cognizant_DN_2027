### 1. Time Complexity Analysis (Singly Linked)

| Operation | Time Complexity | Justification |
| :--- | :--- | :--- |
| **Add** | **O(N)** | We must traverse from the `head` pointer to the absolute end of the chain to append the new node. *(Can be optimized to O(1) by maintaining a `tail` reference).* |
| **Search** | **O(N)** | We must traverse the chain sequentially by following pointers until the target is found. |
| **Traverse** | **O(N)** | Every node in the chain is visited by resolving the `next` pointers. |
| **Delete** | **O(N)** | Finding the target takes `O(N)`. However, the actual deletion is `O(1)`, achieved simply by rerouting the previous node's pointer to bypass the target. |

### 2. Trade-offs: Linked Lists vs. Arrays
Linked Lists provide massive advantages for dynamic data structures:
1. **Infinite Scaling:** A Linked List is never "full" (unless the physical server runs out of RAM). It scales dynamically step-by-step as data is added.
2. **Zero Memory Shifting:** Deleting an item in an array forces massive memory shifts. Deleting an item in a Linked List simply updates a single memory pointer. The surrounding data remains physically untouched, saving immense processing power during large-scale data mutations.
3. **100% Memory Efficiency:** A Linked List holding exactly 5 tasks u
tilizes memory strictly for those 5 tasks. There are zero empty or wasted indices holding null values.