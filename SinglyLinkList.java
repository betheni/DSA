/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 * Implementation of a Singly Linked List data structure
 */
public class SinglyLinkList {
    
    // Node class represents each element in the linked list
    static class Node {
        int data;
        Node next;
        
        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Head of the list
    private Node head;
    
    // Constructor to initialize the linked list
    public SinglyLinkList() {
        head = null;
    }
    
    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }
        // Otherwise, traverse to the end and add the new node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    // Method to delete the first node with the specified data
    public void delete(int data) {
        // If the list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        // If the data is at the head
        if (head.data == data) {
            head = head.next;
            return;
        }
        
        // Otherwise, traverse the list to find the node to delete
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        // If the data is not found
        if (current.next == null) {
            System.out.println("Data not found");
        } else {
            current.next = current.next.next; // Delete the node
        }
    }
    
    // Method to print the elements of the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Main method to test the linked list operations
    public static void main(String[] args) {
        SinglyLinkList list = new SinglyLinkList();
        
        // Test insertion
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        
        System.out.println("Original Linked List:");
        list.printList();
        
        // Test deletion
        list.delete(20);
        System.out.println("After deleting 20:");
        list.printList();
        
        list.delete(50);  // Testing deletion of non-existent element
        
        list.delete(10);  // Testing deletion of head
        System.out.println("After deleting 10:");
        list.printList();
    }
}