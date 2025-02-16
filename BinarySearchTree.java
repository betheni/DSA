package dsa;

/**
 *
 * @author EYE TEC COMPUTERS
 */
public class BinarySearchTree {

    // Node class for BST
    class Node {
        int key;
        Node leftChild, rightChild;

        public Node(int item) {
            key = item;
            leftChild = rightChild = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a new node with a given key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key)
            root.leftChild = insertRec(root.leftChild, key);
        else if (key > root.key)
            root.rightChild = insertRec(root.rightChild, key);

        return root;
    }

    // Inorder traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.leftChild);
            System.out.print(root.key + " ");
            inorderRec(root.rightChild);
        }
    }

    // Search a key in BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        return key < root.key ? searchRec(root.leftChild, key) : searchRec(root.rightChild, key);
    }

    // Find minimum value in BST
    public int findMin() {
        if (root == null)
            throw new IllegalStateException("Tree is empty");
        return findMinRec(root);
    }

    private int findMinRec(Node root) {
        while (root.leftChild != null) {
            root = root.leftChild;
        }
        return root.key;
    }

    // Find maximum value in BST
    public int findMax() {
        if (root == null)
            throw new IllegalStateException("Tree is empty");
        return findMaxRec(root);
    }

    private int findMaxRec(Node root) {
        while (root.rightChild != null) {
            root = root.rightChild;
        }
        return root.key;
    }

    // Method to delete a node
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.leftChild = deleteRec(root.leftChild, key);
        } else if (key > root.key) {
            root.rightChild = deleteRec(root.rightChild, key);
        } else {
            // Node with only one child or no child
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }

            // Node with two children: Get the inorder successor (smallest in right subtree)
            root.key = findMinRec(root.rightChild);

            // Delete the inorder successor
            root.rightChild = deleteRec(root.rightChild, root.key);
        }
        return root;
    }

    // Main method for testing
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal:");
        tree.inorder();

        // Search for elements
        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 90: " + tree.search(90));

        // Find min and max
        System.out.println("Minimum value: " + tree.findMin());
        System.out.println("Maximum value: " + tree.findMax());

        // Delete a node
        System.out.println("Deleting node 30...");
        tree.delete(30);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder();
    }
}
