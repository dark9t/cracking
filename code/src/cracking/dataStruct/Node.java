package cracking.dataStruct;

public class Node {
	public Node next;
	public int data;
	
	public Node(int value){
		data=value;
	}
	
	public void appendToTail(Node newNode){
		if(next==null){
			this.next=newNode;
			return;
		}
		Node n=this;
		while(n.next!=null){
			n=n.next;
		}
		n.next=newNode;
		return;
	}
}
