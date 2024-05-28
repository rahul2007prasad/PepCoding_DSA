package com.dsa.level1.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

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
	public static void levelOrderTraversal(Node node) {
		//rpa --remove --print --add
		
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(node);
		
		while(mq.size() > 0) {
			int count = mq.size();
			for(int i =0; i < count ; i++) {
				node = mq.remove();
				System.out.print(node.data +" ");
				
				if(node.left != null) {
					mq.add(node.left);
				}
				if(node.right != null) {
					mq.add(node.right);
				}
			}
			System.out.println();
		}
		
	}
	
	public static class Pair{
		Node node;
		int state;
		public Pair(Node node , int state) {
			this.node = node;
			this.state = state;
		}
	}
	
	//iterative pre ,post ,inorder traversal
	
	public static void iterativeTraversal(Node node) {
		
		//state 1 :pre ,++state
		//state 2 : inorder ,statte+
		//state 3: post order,pop
		
		Stack<Pair> st = new Stack();
		Pair rtp = new Pair(node , 1);
		st.push(rtp);
		
		String pre ="";
		String in = "";
		String post = "";
		
		while(st.size() > 0) {
			Pair top = st.peek();
			if(top.state == 1) { //pre ,s++,left
				pre += top.node.data + " ";
				top.state++;
				
				if(top.node.left != null) {
					Pair lp = new Pair(top.node.left , 1);
					st.push(lp);
				}
				
			}else if(top.state == 2) {// in , s++ , right
				in += top.node.data + " ";
				top.state++;
				
				if(top.node.right != null) {
					Pair rp = new Pair(top.node.right , 1);
					st.push(rp);
				}
				
			}else { //post ,pop
				post += top.node.data;
				st.pop();
			}
		}
		
		
		
	}
	
	//find
	public static boolean find(Node node ,int data) {
		
		ArrayList<Integer> path;
		path = new ArrayList<Integer>();
		if(node == null) {
			return false;
		}
		
		if(node.data == data) {
			path.add(node.data);
			return true;
		}
		boolean filc = find(node.left , data);
		if(filc)
		{
			path.add(node.data);
			return true;
		}
		boolean firc = find(node.right , data);
		if(firc) {
			path.add(node.data);
			return true;
		}
		return false;
		
	}
	
	//Node to path
	
	/*
	 * public static void nodeToRootPath(Node node , int data) {
	 * 
	 * ArrayList<Integer> path; path = new ArrayList<Integer>();
	 * 
	 * boolean find = find(node, data);
	 * 
	 * if(find == true) { path.add(node.data); }
	 * 
	 * }
	 */
	
	
	
}
