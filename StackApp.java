/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author EYE TEC COMPUTERS
 */
public class StackApp {
    
    public static void main(String [] args){
        BoundedArrayStack theStack = new BoundedArrayStack (5);//create a stack with max size
        
        //push operation
        for (int i=1; i<7; i++){
            if (!theStack.isFull()){
            //insert items
            theStack.push(i * 10);
            } else {
                System.out.println("can not push. stack is full");
            }
        }
        
        theStack.print();
        //peek the top element
            if (!theStack.isEmpty()){
                System.out.println("top element is : " + theStack.peek());
            }else {
                System.out.println("stack is empty,nothing to peek");
            }
            
            //pop operation
            if (!theStack.isEmpty()){
            //unit the stack is empty,delete item from the stack
            int val = theStack.pop();
            System.out.println(val);
            System.out.println(" ");
            }else {
                System.out.println("Can not pop.stack is empty");
            }
            
 
    }
    
}
