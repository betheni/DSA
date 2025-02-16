/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author EYE TEC COMPUTERS
 */
public class BSTTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree tree = new BinarySearchTree();

        // Insert some nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the tree
        System.out.println("Inorder traversal:");
        tree.inorder(); // Output: 20 30 40 50 60 70 80

        // Delete a key
        System.out.println("\nDeleting key 20");
        tree.delete(20);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder(); // Output: 30 40 50 60 70 80

        System.out.println("\nDeleting key 30");
        tree.delete(30);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder(); // Output: 40 50 60 70 80

        System.out.println("\nDeleting key 50");
        tree.delete(50);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder(); // Output: 40 60 70 80
    }
    
}

