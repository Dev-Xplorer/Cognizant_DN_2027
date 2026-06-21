## Complexity Analysis

# Evaluating the performance constraints of the array implementation methods:

| Operation | Time Complexity | Reason for Complexity |
| :--- | :--- | :--- |
| **Add** | $O(1)$ | Inserts directly into the array boundary using the tracked `size` tracking pointer. |
| **Search** | $O(n)$ | Requires iterating through the elements sequentially from the index start to find an ID match. |
| **Traverse** | $O(n)$ | Requires sequentially visiting and printing every active cell up to the current system size. |
| **Delete** | $O(n)$ | Finding the item requires a scan, and removing it requires shifting all subsequent elements down to preserve contiguity. |