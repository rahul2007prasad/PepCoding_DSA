package com.dsa.level1.bst;

public class BinarySearchTree {
	public static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data , Node left , Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void display(Node node) {
		if(node == null) {
			return;
		}
		String str ="";
		
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data +"";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static Node constructor(int[] arr , int low , int high ) {
		if(low > high) {
			return null;
		}
		
		int mid  = low + (high - low) /2;
		int data = arr[mid];
		Node lc = constructor(arr, low, mid -1);
		Node rc = constructor(arr, mid + 1, high);
		Node node = new Node(data , lc , rc);
		
		return node;
	}
	
	public static Node addNode(Node node ,int data) {
		if(node == null) {
			return new Node(data , null , null);
		}
		
		if(data < node.data) {
			node.left =  addNode(node.left, data);
		}else if(data  > node.data) {
		   node.right =	addNode(node.right, data);
		}else {
			// nothing to do
		}
		return node;
	}
	
	public static void main(String[] args) {
		int [] arr = {12 , 25 , 37 , 50 , 62 , 75 , 87};
		Node root = constructor(arr , 0 , arr.length - 1);
		
		
		
		display(root);
		
		//add node
		addNode(root, 38);
		System.out.println("-----");
		display(root);
	}
}
