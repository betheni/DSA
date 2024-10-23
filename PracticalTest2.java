import java.util.LinkedList;
import java.util.SequencedCollection;

 public class PracticalTest2{
	public PracticalTest2(){
		SequencedCollection sc = new LinkedList();
		sc.addFirst(5);
		sc.addFirst(8);
		sc.addLast(7);
		System.out.println(sc.getFirst());
		System.out.println(sc.removeLast());
		System.out.println(sc);
		System.out.println(sc.reversed());
		
	}
	
	public static void main(String[]args){
		new PracticalTest2();
	}
 }