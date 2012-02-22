package cracking;
import java.util.ArrayList;
import java.util.LinkedList;

import cracking.dataStruct.*;
public class BinaryTreeLauncher {

	public static void main(String[] args){
		ArrayList<Integer> data=new ArrayList<Integer>();
		int treeSize=20;
		for(int i=0;i<treeSize;i++){
			data.add(i);
		}
		
		BinaryTree<Integer> bst = BinaryTree.fromSortedArray(data, 0, treeSize-1);
		ArrayList<LinkedList<Integer>> layers = bst.getLayers();
		
		for(LinkedList<Integer> l:layers){
		    for(Integer i:l){
		    	System.out.print(i + "->");
		    }
		    System.out.println();
		}
		
		try {
			boolean isBST=bst.isBST();
			System.out.println(isBST);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			int data1=10;
			int data2=14;
			int commonAncestor= bst.getLowestCommonAncestor(data2, data1);
			System.out.printf("the common ancestor value for %s and %s is %s", data1, data2, commonAncestor);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
