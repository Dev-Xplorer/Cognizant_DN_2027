## Understand Array Representation
### How Arrays are Represented in Memory
**When you instantiate an array in Java, the JVM allocates a single, contiguous block of memory.**
* The array variable itself holds a reference to the base memory address (the location of the first element).
* Because the memory block is unbroken, the system can instantly calculate the exact physical location of any element using basic pointer arithmetic: `Target Address = Base Address + (Index * Size of Element)`.
### Advantages of Arrays:
1. Instant Access ($O(1)$): Due to the pointer arithmetic mentioned above, grabbing the 10,000th element takes the exact same fraction of a millisecond as grabbing the 1st element.
2. CPU Cache Friendliness: Modern processors load memory in chunks. Because array data sits directly next to each other physically, iterating through an array causes almost zero cache misses, making it the fastest possible data structure for sequential reading.