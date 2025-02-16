package dsa;

/**
 *
 * @author EYE TEC COMPUTERS
 */
public class LinkedList {
    private Node head; // Head of the list

    // Node class for singly linked list
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Parameterless constructor to initialize an empty list
    public LinkedList() {
        this.head = null;
    }

    // Add a new node to the end of the list
    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the end of the list
        }
        current.next = newNode; // Link the new node at the end
    }

    // Insert at the beginning of the list
    public void insertBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Insert after a specific value
    public void insertAfter(int value, int afterValue) {
        Node current = head;
        while (current != null && current.value != afterValue) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value " + afterValue + " not found.");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Find the last node
    public Node findLast() {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    // Find a specific node
    public Node find(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return current;
            }
            current = current.next;
        }
        return null; // Value not found
    }

    // Insert before a specific value
    public void insertBefore(int value, int beforeValue) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.value == beforeValue) {
            insertBeginning(value); // Special case: insert before head
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value != beforeValue) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value " + beforeValue + " not found.");
        } else {
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Delete the first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    // Delete the last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) { // Only one node in the list
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) { // Traverse to the second last node
            current = current.next;
        }
        current.next = null; // Remove the last node
    }

    // Remove a node by its value
    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.value == value) {
            head = head.next; // Remove the head node if it matches the value
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next; // Traverse until the node before the target node
        }

        if (current.next == null) {
            System.out.println("Element not found."); // Value not in the list
        } else {
            current.next = current.next.next; // Unlink the target node
        }
    }

    // Override toString() to display the linked list
    @Override
    public String toString() {
        if (head == null) {
            return "List is empty.";
        }

        StringBuilder result = new StringBuilder();
        Node current = head;

        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.next;
        }

        result.append("null");
        return result.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Append nodes
        list.append(10);
        list.append(20);
        list.append(30);
        System.out.println("Linked List after appending: " + list);

        // Insert at beginning
        list.insertBeginning(5);
        System.out.println("After inserting at beginning: " + list);

        // Insert after a value
        list.insertAfter(25, 20);
        System.out.println("After inserting 25 after 20: " + list);

        // Insert before a value
        list.insertBefore(15, 20);
        System.out.println("After inserting 15 before 20: " + list);

        // Find a node
        System.out.println("Finding node with value 25: " + (list.find(25) != null));

        // Delete first node
        list.deleteFirst();
        System.out.println("After deleting first node: " + list);

        // Delete last node
        list.deleteLast();
        System.out.println("After deleting last node: " + list);

        // Delete a specific node
        list.delete(20);
        System.out.println("After deleting node with value 20: " + list);
    }
}
