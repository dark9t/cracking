package cracking.dataStruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {

	private Node<T> root;
	
	public boolean isBST() throws Exception{
		return isBST(root, min(), max());
	}
	
	public T min(){
		Node<T> current=root;
		if(current==null)
			return null;
		while(current.left!=null){
			current=current.left;
		}
		return current.data;	
	}
	
	public T max(){
		Node<T> current=root;
		if(current==null)
			return null;
		while(current.right!=null){
			current=current.right;
		}
		return current.data;
	}
	
	//[recursive version] tell whether a binary is a binary search tree
	private static <T extends Comparable<T>> boolean isBST(Node<T> root, T min, T max) throws Exception{
		if(min.compareTo(max)>0)
			throw new Exception("invalid input");	
		if(root==null)
			return true;
		if(root.data.compareTo(min)<0 || root.data.compareTo(max)>0)
			return false;
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}
	
	private static class Node<T extends Comparable<T>>{
		Node<T> left;
		Node<T> right;
		T data;
		
		Node(T newData){
			left=null;
			right=null;
		    data=newData;
		}
	}
	
	public BinaryTree(T data){
		if(data!=null){
			root=new Node<T>(data);
		}
		else
			root=null;
	}
	
	public boolean lookup(T data){
		return lookup(root, data);
	}
	
	public void insert(T data){
		root=insert(root,data);
	}
	private Node<T> insert(Node<T> root, T data) {
		if(root==null)
		{
			root = new Node<T>(data);
		}
		if(root.data.compareTo(data)<0)
		{
			root.left = insert(root.left, data);
		}
		else
		{
			root.right = insert(root.right, data);
		}
		
		return root;
	}

	private boolean lookup(Node<T> node, T data){
		if(node==null){
			return false;
		}
		if(data==node.data)
		{
			return true;
		}
		else if(node.data.compareTo(data)<0){
			return lookup(node.left, data);
		}
		else
		{
			return lookup(node.right, data);
		}
	}
	
	public static <N extends Number> double sum(){
		return (Double) null;
	}
	
	//assume that the given binary tree contains nodes with values: data1, data2
	public T getLowestCommonAncestor(T data1, T data2) throws Exception{
		if(root==null || data1==null || data2==null)
			return null;
		
		//determine which one is smaller and which one is larger.
		T smaller, larger;
		if(data1.compareTo(data2)<0)
		{
			smaller=data1;
			larger=data2;
		}
		else if(data1.compareTo(data2)>0){
			smaller=data2;
			larger=data1;
		}
		else
			throw new Exception("Two nodes cannot have the same value.");
		
		Node<T> current=root;
		boolean tooLarge;
		boolean tooSmall;
		do{
			 tooSmall=current.data.compareTo(smaller)<0;
			 tooLarge=current.data.compareTo(larger)>0;
			if(tooSmall)
				current=current.right;
			if(tooLarge)
				current=current.left;
		}while(tooSmall || tooLarge);
		
		return current.data;
	}
	
//	public Node<T> getSuccessor(Node<T> given){
//		if(given==null)
//			return null;
//		
//		//if the given node does not right subtree
//		if(given.right==null){
//			Stack<Node<T>> path=new Stack<Node<T>>();
//			if(root!=null){
//				Node<T> current=root;
//				path.push(current);
//				int result;
//				//trace the path from root to the given node
//				while((result =given.data.compareTo(current.data))!=0){
//					if(result>0){
//						current=current.left;
//					}
//					else{
//						current=current.right;
//					}
//					if(current==null) //didn't found the given value
//						return null;
//					else
//						path.push(current);
//				}
//				
//				
//			}
//		}
//		while(given.right!=null){
//			given=given.right;
//		}
//	
//	}
	public int height(){
		return height(root);
	}
	
	private static<T extends Comparable<T>> int height(Node<T> root){
		if(root==null)
			return 0;
		int lHeight=height(root.left);
		int rHeight=height(root.right);
		if(lHeight>rHeight)
			return lHeight+1;
		else
			return rHeight+1;
	}
	
	public boolean isBalanced(){
		return isBalanced(root);
	}
	
	private static<T extends Comparable<T>> boolean isBalanced(Node<T> root){
		if(root==null)
			return true;
		int lHeight=height(root.left);
		int rHeight=height(root.right);
		if(Math.abs(lHeight-rHeight)>1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static <T extends Comparable<T>> BinaryTree<T> fromSortedArray(ArrayList<T> data, int start, int end){
		if(data==null)
			return new BinaryTree<T>(null);
		if(start>end)
			return null;
		if(start==end)
		{
			return new BinaryTree<T>(data.get(start));
		}
		int len= end-start+1;
		int mid=start + (int) Math.floor(len/2);
		BinaryTree<T> tree=new BinaryTree<T>(data.get(mid));
		BinaryTree<T> leftSub=fromSortedArray(data, start, mid-1);
		BinaryTree<T> rightSub=fromSortedArray(data, mid+1, end);
		tree.root.left=leftSub==null?null:leftSub.root;
		tree.root.right=rightSub==null?null:rightSub.root;
		
		return tree;
	}
	
	public ArrayList<LinkedList<T>> getLayers(){
		ArrayList<LinkedList<T>> layers=new ArrayList<LinkedList<T>>();
		getLayers(root, layers, 0);
		return layers;
	}
	
	private static <T extends Comparable<T>> void getLayers(Node<T> root, ArrayList<LinkedList<T>> layers,int layerId){
		if(root==null)
			return;
		if(layers.size()==layerId)
			layers.add(new LinkedList<T>());
		LinkedList<T> currentLayer = layers.get(layerId);
		currentLayer.add(root.data);
		getLayers(root.left, layers, layerId+1);
		getLayers(root.right, layers, layerId+1);
	}
}
