package cracking;

import cracking.dataStruct.Node;

public class Launcher2 {
	public static void main(String[] args){
		Node n1=new Node(5);
		Node n2=new Node(3);
		Node n3=new Node(2);
		Node n4=new Node(0);
		Node n5=new Node(100);
		Node n6=new Node(25);
		Node n7=new Node(34);
		Node n8=new Node(1);
		Node n9=new Node(50);
		//testing Node class
		n1.appendToTail(n2);
		n1.appendToTail(n3);
		n1.appendToTail(n4);
		n1.appendToTail(n5);
		n1.appendToTail(n6);
		n1.appendToTail(n7);
		n1.appendToTail(n8);
		n1.appendToTail(n9);
		Ch2.printList(n1);
		
		//testing findElement function (2.2)
		Node n=Ch2.findElement(n1, 6);
		System.out.println(n.data);
		
		//testing partitionList (2.4)
		Node reOrdered=Ch2.partitionList(n1, 1);
		Ch2.printList(reOrdered);
		
		//testing sum (2.5) 
		//num1:123
		System.out.println("Testing sum function*****");
		Node num1=new Node(8);
		num1.appendToTail(new Node(9));
		num1.appendToTail(new Node(1));
		num1.appendToTail(new Node(3));
		Ch2.printList(num1);
		
		Node num2=new Node(6);
		num2.appendToTail(new Node(5));
		num2.appendToTail(new Node(4));
		Ch2.printList(num2);
		
		Node result=Ch2.sum1(num1, num2);
		Ch2.printList(result);
	}
}
