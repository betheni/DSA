package dsa;

import java.util.NoSuchElementException;
import java.util.Stack;

class StackQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue an element into the queue
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }

        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Pop from stack2 which gives the queue element
        return stack2.pop();
    }

    // Peek the front element of the queue
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }



    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue and print
        System.out.println(queue.dequeue()); // Outputs 10
        System.out.println(queue.dequeue()); // Outputs 20

        queue.enqueue(40);

        // Peek the front element
        System.out.println(queue.peek());   // Outputs 30

        // Dequeue and print remaining
        System.out.println(queue.dequeue()); // Outputs 30
        System.out.println(queue.dequeue()); // Outputs 40
    }
 }

