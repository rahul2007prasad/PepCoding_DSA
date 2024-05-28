package com.dsa.level1.binarytree;

public class BinaryTree {

	
	public static class Node{
		Node left;
		Node right;
		int data;
		
		Node(Node left , Node right , int data){
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}
	
	
	//size
	
	public static int size(Node node) {
		if(node == null) {
			return 0;
		}
		
		int ls = size(node.left);
		int rs = size(node.right);
		int ts = ls + rs + 1;
		
		return ts;
	}
	
	//sum of all node
	public static int sum(Node node) {
		if(node == null) {
			return 0;
		}
		int lsm = sum(node.left);
		int rsm = sum(node.right);
		int tsm = lsm + rsm + node.data;
		
		return tsm;
		
	}
	
	
	// max of tree
	public static int max(Node node) {
		if(node == null) {
			return Integer.MIN_VALUE;
		}
		
		int lmax = max(node.left);
		int rmax = max(node.right);
		int tmax = Math.max(node.data ,(Math.max(lmax, rmax)));
		return tmax;
		
	}
	
	
	//height of tree(deepth of deepest node)
	public static int height(Node node) {
		if(node == null) {
			return -1; // -1 for edges and , 0 for nodes
		}
		
		int lheight = height(node.left);
		int rheight = height(node.right);
		int theight = Math.max(lheight, rheight) + 1;
		
		return theight;
		
	}
	
	public static void display(Node node) {
		if(node == null) {
			return;
		}
		String str = "";
		str += node.left == null ? "."  : node.left.data +"";
		str +="<- " + node.data + " ->";
		str += node.right == null ?"." : node.right.data +"";
		
		System.out.println(str);
		display(node.left);
		display(node.right);
		
	}
	
	public static void traversal(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.println(node.data  +"in preosder"); //euler left --> pre
		traversal(node.left);
		System.out.println(node.data +"in inordder");
		
		traversal(node.right);
		System.out.println(node.data +"in post order");
		
		
	}
	
	//level order traversal
	
	
	
	
}
