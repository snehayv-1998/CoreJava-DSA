# I. Java Architecture

## 1. How Java Code Executes:

Java code is executed through the Java Virtual Machine (JVM), which is responsible for interpreting and running the compiled Java bytecode. The process involves several components working together.

## 2. JDK V/S JRE V/S JVM V/S JLT

### 2.1 JDK (Java Development Kit):

JDK is a software development kit that provides tools for developing, debugging, and monitoring Java applications. It includes JRE and additional development tools such as compilers and debuggers.

### 2.2 JRE (Java Runtime Environment):

JRE is the runtime environment where Java applications run. It includes the JVM and necessary libraries, but lacks development tools.

### 2.3 Compile time V/S Runtime:

Compilation is the process of translating Java source code into bytecode. Compile time refers to the time when the code is compiled, while runtime is when the Java program is executed.

### 2.4 How JVM Works:

JVM interprets and executes Java bytecode. It loads classes, performs bytecode verification, and manages memory and resources during runtime.

# II. Memory Management

## How Java Memory Works?

### Stack:

The stack is used for storing method call information, local variables, and control flow data. It operates on a last-in, first-out (LIFO) basis.

### Heap:

The heap is used for dynamic memory allocation, including objects and arrays. It is managed by the garbage collector.

### Metaspace v/s PermGen Memory:

Metaspace is a memory space for class metadata, introduced in Java 8, replacing PermGen space.

## Types of Complexities (Time and Space):

### Sorting Algorithm and Their Time and Space Complexity:

- **Bubble Sort:** Time - O(n^2), Space - O(1)
- **Selection Sort:** Time - O(n^2), Space - O(1)
- **Insertion Sort:** Time - O(n^2), Space - O(1)
- **Cyclic Sort:** Time - O(n), Space - O(1)

# III. Java Basics

## 1. Meaning of `public static void main(String[] args)`:

The main method is the entry point for a Java program. It must have this signature for the JVM to recognize and execute it.

## 2. Meaning of `System.out.println()`:

Used for printing output to the console. `println` adds a newline after printing.

## 3. Data Types:

Java supports various data types, including primitive (int, float) and reference types (objects).

## 4. Conditional Statement:

### If-else, switch-case for decision-making.

## 5. Loops:

### 5.1 For Loop:
### 5.2 For Each Loop:
### 5.3 While Loop:
### 5.4 Do While Loop:

## 6. Switch:

### 6.1 Old Switch
### 6.2 Enhanced Switch

## 7. Pass-by-Value:

### 7.1 Primitives Pass by Value:
### 7.2 Passing Object References

## 8. Array:

### 2D Array, ArrayList

## 9. Linear Search:

### Time Complexity: O(n)

## 10. Binary Search:

### Time Complexity: O(log n)

## 11. String and StringBuffer:

### String Pool, String Intern, String Concatenation
### String Builder v/s StringBuffer

# IV. Math for DSA

## 1. Bitwise Operator:

### AND, OR, XOR, Base Conversion, Left Shift, Right Shift

## 2. Important Tips

# V. Collection Framework

## Collection Framework:

### Array v/s Collections, HashMap, Tree

## Basic Tree Terminology:

### Types of Tree, Binary Trees Based on Structural Properties

1. Full Binary Tree
2. Complete Binary Tree
3. Perfect Binary Tree
4. Balanced Binary Tree
5. Degenerate (or Pathological) Tree
6. Skewed Binary Tree
7. Threaded Binary Tree

### Heap, Max Heapify Algorithm, Build Max Heap, Extract Max Heap

## Tree Traversal:

### Depth-First Search
### Inorder, Preorder, Postorder Traversal
### Breadth-First Search

## AVL Tree:

### Balancing an AVL, Right Rotation, Left Rotation, Insertion Steps

## Graph:

### Terminology, Structure, Edge Weight, Greedy

# VI. Design Patterns

Coming Soon...
