# Linked Data Structures (Java)

## Overview
This repository contains custom Java implementations of fundamental data structures using a linked approach. This includes linked lists, queues, and stacks. These data structures have been implemented from scratch to better understand how these structures work under the hood.

### Data Structures Implemented

These are the data structures implemented. These structures use custom List, Queue, and Stack interfaces appropriatly.

- **LinkedList**: A custom implementation of a singly linked list with a reference to the tail.
- **LinkedQueue**: A queue implementation using the `LinkedList` as its underlying data structure.
- **LinkedStack**: A stack implementation using the `LinkedList` as its underlying data structure.

## Table of Contents

- [LinkedList](#linkedlist)
- [LinkedQueue](#linkedqueue)
- [LinkedStack](#linkedstack)
- [Usage & Installation](#usage-and-installation)
- [Contributing](#contributing)
- [License](#license)

## LinkedList

### Overview

The `LinkedList` class is a custom implementation of a singly linked list. It provides various methods for adding, removing, and retrieving elements, including the ability to add elements at the beginning, end, or specific index. This class implements the List interface.

### Key Methods

- **`add(E data)`**: Adds an object at the end of the list.
- **`add(int index, E data)`**: Adds an object at the specified index.
- **`remove()`**: Removes the first object in the list.
- **`remove(int index)`**: Removes the object at the specified index.
- **`get(int index)`**: Retrieves the object at the specified index.
- **`size()`**: Returns the number of objects in the list.

### Example Usage

```java
LinkedList<Integer> list = new LinkedList();
list.add(1);
list.add(2);
list.add(3);

System.out.println(list.get(0));  // Output: 1
System.out.println(list.size());  // Output: 3
list.remove(1);
System.out.println(list.size());  // Output: 2
```

## LinkedQueue

### Overview

The `LinkedQueue` class is a custom implementation of a queue that wraps the `LinkedList` class. It follows the First-In-First-Out (FIFO) principle. This class implements the Queue interface.

### Key Methods

- **`add(E data)`**: Adds an object to the end of the queue.
- **`peek()`**: Returns the object at the front of the queue without removing it.
- **`poll()`**: Removes and returns the object at the front of the queue.
- **`isEmpty()`**: Checks if the queue is empty.

### Example Usage

```java
LinkedQueue<Integer> queue = new LinkedQueue();
queue.add(1);
queue.add(2);

System.out.println(queue.peek());  // Output: 1
queue.poll();  // Removes 1
System.out.println(queue.peek());  // Output: 2
```

## LinkedStack

### Overview

The `LinkedStack` class is a custom implementation of a stack that wraps the `LinkedList` class. It follows the Last-In-First-Out (LIFO) principle. This class implements the Stack interface.

### Key Methods

- **`push(E data)`**: Adds an object to the top of the stack.
- **`peek()`**: Returns the object at the top of the stack without removing it.
- **`pop()`**: Removes and returns the object at the top of the stack.
- **`isEmpty()`**: Checks if the stack is empty.

### Example Usage

```java
LinkedStack<Integer> stack = new LinkedStack();
stack.push(1);
stack.push(2);

System.out.println(stack.peek());  // Output: 2
stack.pop();  // Removes 2
System.out.println(stack.peek());  // Output: 1
```

## Usage & Installation

You can use the data structures in this repository in two ways:

### Using Precompiled Binaries

1. Download the `.zip` file from the [Releases](https://github.com/yousefalshaikh17/java-linked-data-structures/releases).  
2. Extract the package folder into your Java project.  
3. Import the package and use the classes as follows:
```java
import com.linkeddatastructures.LinkedList;
import com.linkeddatastructures.LinkedQueue;
import com.linkeddatastructures.LinkedStack;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        LinkedQueue<String> list = new LinkedQueue();
        LinkedStack<Float> list = new LinkedStack();
    }
}
```

### Compiling from Source  

If you prefer to compile the source code manually, follow these steps:  

1. Clone the repository:  
   ```bash
   git clone https://github.com/yousefalshaikh17/java-linked-data-structures.git
   ```  
2. Navigate to the repository:  
   ```bash
   cd java-linked-data-structures
   ```  
3. Compile the source files:  
   ```bash
   javac -d bin com/yousefalshaikh17/linkeddatastructures/*.java
   ```  
4. Add the compiled .class files to your Java project's classpath (either by copying them into your own project's lib/ folder or by adding bin/ to the classpath). 

## Contributing

Feel free to fork the repository, make improvements, and submit pull requests. Please ensure that any changes are well-documented and tested.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
