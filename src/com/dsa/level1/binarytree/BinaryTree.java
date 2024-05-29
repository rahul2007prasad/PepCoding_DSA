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
	
	//print k level down
	
	public static void printKLevelsDown(Node node , int k , Node blocker) {
		if(node == null || k < 0 || node == blocker) {
			return ;
		}
		
		if(k == 0) {
			System.out.println(node.data);
		}
		printKLevelsDown(node.left, k - 1 , blocker);
		printKLevelsDown(node.right, k - 1 , blocker);
	}
	
	//print k level far
	
	public static void printKLevelFar(Node node ,int data , int k) {
		ArrayList<Node > path  = new ArrayList<BinaryTree.Node>();
				find(node ,data);
		for(int i =0 ; i < path.size() && i <= k; i++) {
			printKLevelsDown(path.get(i), k -1 , i == 0 ? null : path.get(i));
		}
	}
	
	
	//path to leaf from root
	
	public static void pathTOLeafFromRoot(Node node , String path , int sum , int low , int high) {
		
		if(node == null) {
			return;
		}
		if(node.left == null && node.right == null) {
			sum += node.data;
			if(sum >= low && sum <= high) {
				System.out.println(path + node.data);
			}
			return;
		}
		
		pathTOLeafFromRoot(node.left, path + node.data, sum + node.data, low, high);
		
		pathTOLeafFromRoot(node.right, path + node.data, sum + node.data, low, high);
		
	}
	
	
	
	//transormed to  left cloned tree
	public static Node createLeftClonedTree(Node node) {
		if(node == null) {
			return null;
		}
		Node lcr = createLeftClonedTree(node.left);
		Node rcr = createLeftClonedTree(node.right);
		
		Node nn = new Node( lcr,null , node.data );
		node.left = nn;
		node.right = rcr;
		
		return node;
		
	}
	
	//transformed back from a left cloned tree
	public static Node transBackFromLeftClonedTree(Node node) {
		if(node == null) {
			return null;
		}
		
		Node lnn = transBackFromLeftClonedTree(node.left.left);
		Node rnn = transBackFromLeftClonedTree(node.right);
		
		node.left = lnn;
		node.right = rnn;
		return node;
		
	}
	
	
	
	//print single child nodes
	public static void printSingleChildNode(Node node , Node parent) {
		if(node == null) {
			return;
		}
		if(parent != null  && parent.left == node && parent.right == null ) {
			System.out.println(node.data);
		}else if(parent != null && parent.right == node &&  parent.left == null) {
			System.out.println(node.data);	
		}
		
		printSingleChildNode(node.left, node);
		printSingleChildNode(node.right, node);
		
		
	}
	
	//remove leaves
	public static Node removeLeaves(Node node) {
		if(node == null) {
			return null;
		}
		
		if(node.left == null && node.right == null) {
			return null;
		}
		
		Node nlr = removeLeaves(node.left);
		Node nrr = removeLeaves(node.right);
		
		node.left = nlr ;
		node.right = nrr;
		
		return node;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		//pathTOLeafFromRoot(root,"",0 , lo ,hi);
	}
}
