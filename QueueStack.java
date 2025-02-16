package dsa;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack<T> {

    private Queue<T> queue1; // Primary queue
    private Queue<T> queue2; // Secondary queue (used temporarily)

    // Constructor
    public QueueStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push an element onto the stack
    public void push(T element) {
        // Add the new element to the empty secondary queue
        queue2.add(element);

        // Transfer all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the references of queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop the top element from the stack
    public T pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.remove(); // Remove the front element of queue1
    }

    // Peek at the top element without removing it
    public T peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek(); // Get the front element of queue1
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Override toString() to display the elements of the stack
    @Override
    public String toString() {
        return queue1.toString(); // Queue1 contains the stack elements in reversed order
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueStack<Integer> stack = new QueueStack<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushing: " + stack);

        // Peek at the top element
        System.out.println("Top element (peek): " + stack.peek());

        // Pop elements
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after popping: " + stack);

        // Check if empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
