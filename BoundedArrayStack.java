
package dsa;


import java.util.NoSuchElementException;

public class BoundedArrayStack {
    private int maxSize; //size of the stack array
    private int[] Array;//array creation
    private int tos;// top of the stack
    
    public BoundedArrayStack(int s){
        maxSize = s; //set array size
        Array = new int [maxSize];
        tos = -1; // no items

    }
    
    //is empty method
    public boolean isEmpty(){
        return tos == -1;}// stack is empty if the top is -1
    
    //is fully method
    public boolean isFull(){
        return tos == maxSize -1;}
    
    //push operation
    public void push(int j){
    //check whether the stack is full
        if(isFull()){
            throw new IllegalStateException("stack is full");
        }else {
                  //increment top
                  //insert item
                  Array[++tos] = j;}
        
    }
    //pop operation
    public int pop(){
    //check whether stack is empty
    //if not
    //access item
    if(isEmpty()){
        throw new NoSuchElementException("stack is empty");
    } else{
        return Array[tos--];
    
    }

}

    //peek operation
    public int peek(){
        if (tos == -1){
            throw new NoSuchElementException("stack is empty");
    } else{
        return Array[tos];}
    }
    
    public void print(){
        System.out.print("stack element: [");
            for (int i = tos; i>=0; i--){ //traverse from top to bottom
                System.out.print(Array[i] + " ");
            }
        System.out.println("]");
    }
    
}
