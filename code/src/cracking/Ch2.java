package cracking;

import cracking.dataStruct.Node;

public class Ch2 {
	public static Node findElement(Node head, int k){
		int count=0;
		if(head==null) return null;
		Node current=head;
		do{
			count++;
			current=current.next;
		}while(current!=null);
		if(count<k)//invalid k	
			return null;
		int distance=count-k;
		current=head;
		while(distance>0){
			current=current.next;
			distance--;
		}
		return current;
	}
	
	public static void printList(Node head){
		if(head==null) return;
		Node n=head;
		do{
			System.out.format("%s->", n.data);
			n=n.next;
		}while(n!=null);
		System.out.println("||");
	}
	
	public static Node partitionList(Node head, int x){
		Node small=null;
		Node large=null;
		Node equalX=null;
		
		if(head==null)return null;
		Node current=head;
		do{
			Node next=current.next;
			current.next=null;
			if(current.data<x){
				if(small==null)
					small=current;
				else
					small.appendToTail(current);
			}else if(current.data==x){
				if(equalX==null)
					equalX=current;
				else
					equalX.appendToTail(current);
			}
			else{
				if(large==null)
					large=current;
				else
					large.appendToTail(current);
			}
			current=next;
		}while(current!=null);
		if(equalX==null)
			small.appendToTail(large);
		else{
			equalX.appendToTail(large);
			small.appendToTail(equalX);
		}
		return small;
	}
	
	//Intro: use linked list to represent numbers, for example, 123 is: 3->2->1
	//add two numbers up
	public static Node sum1(Node n1, Node n2){
		int overflow=0;
		Node sum=null;
		Node c1=n1, c2=n2;
		while(c1!=null || c2!=null){
			int temp=((c1!=null)?c1.data:0)+((c2!=null)?c2.data:0)+overflow;
			int digitResult=temp%10;
			overflow=(int)Math.floor(temp/10);
			if(sum==null)
				sum=new Node(digitResult);
			else
				sum.appendToTail(new Node(digitResult));
			if(c1!=null)
				c1=c1.next;
			if(c2!=null)
				c2=c2.next;
		}
		return sum;
	}
}
