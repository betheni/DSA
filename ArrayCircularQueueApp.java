/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author EYE TEC COMPUTERS
 */
import java.util.NoSuchElementException;

public class ArrayCircularQueueApp {
    
    int SIZE = 5; // Size of Circular Queue
	int front, rear;
	int items[] = new int[SIZE];

	ArrayCircularQueueApp() {
		 front = -1;
		 rear = -1;
	}

	// Check if the queue is full
	boolean isFull() {
		 return (front == 0 && rear == SIZE - 1) || front == rear + 1;
	}

	// Check if the queue is empty
	boolean isEmpty() {
		 return front == -1;
	}

	// Adding an element
	void enQueue(int element) {
		 if (isFull()) {
			 System.out.println("Queue is full");
		 } 
		 else {
			   if (front == -1)
				   front = 0;

			   rear = (rear + 1) % SIZE;
			   items[rear] = element;
			   System.out.println("Inserted: " + element);
		 }
	}

// Removing an element
	int deQueue() {
		 int element;

		 if (isEmpty()) {
			 throw new NoSuchElementException("Queue is empty!");
		 } 
		 else {
			   element = items[front];

			   if (front == rear) {
				   front = -1;
				   rear = -1;
		   } /* Queue has only one element, so we reset the queue after deleting it. */
		   else {
			   front = (front + 1) % SIZE;
		   }
			   return (element);
		 }
	}

void display() {
	 /* Function to display status of Circular Queue */
	 int i;

	System.out.print("Items: [");

	for (i = front; i != rear; i = (i + 1) % SIZE)
	      System.out.print(items[i] + " ");

	      System.out.println(items[i] + "]");

	      System.out.print("Indexes: ");
	      for (i = front; i != rear; i = (i + 1) % SIZE) {
	          System.out.print(i + " ");
	      }
	      System.out.println(i); // Print the last index


}
}
