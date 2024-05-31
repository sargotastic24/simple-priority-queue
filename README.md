# simple-priority-queue

SimplePriorityQueue

Overview

In this project, I implemented a generic priority queue that can accommodate any type of item (e.g., strings, integers, library books). A priority queue is a container in which access is limited to the "minimum" item. The key operations findMin and deleteMin must run the fastest, which is achieved by maintaining the priority queue as a sorted array of items from largest to smallest.

Requirements

SimplePriorityQueue Class

The SimplePriorityQueue<E> class implements the provided PriorityQueue interface. The following constructors are provided:

Default Constructor:


public SimplePriorityQueue()


- Assumes elements are ordered using their natural ordering (E implements Comparable<? super E>).

Comparator Constructor:


public SimplePriorityQueue(Comparator<? super E> comparator)


- Assumes elements are ordered using the provided Comparator object.

Implementation Details

- Package: All new classes are added to the assign03 package.
- Array Backing: The SimplePriorityQueue is backed by a basic array. The array is dynamically resized as needed to accommodate new items without starting with a gigantic array.
- Insert Method: The insert method takes advantage of the array being sorted and implements a binary search for insertion. A loop is used for running time efficiency, avoiding recursion and not invoking Java's Arrays.binarySearch routine.
- Sorting: Java's Arrays.sort routine is not used, as sorting is not necessary for this implementation.
- No Binary Heap: The SimplePriorityQueue is not implemented as a binary heap, which is an advanced topic studied later in the course.

Created JUnit tests to verify the functionality of the SimplePriorityQueue class, covering all edge cases and ensuring compliance with the requirements.
