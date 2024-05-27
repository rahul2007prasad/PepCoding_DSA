package com.dsa.level1.generic.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {
	private class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	
	public static void display(Node node) {
		String str = node.data + " --> ";
		for(Node child : node.children) {
			str += child.data+ ", ";
		}
		str +=".";
		System.out.println(str);
		for(Node child : node.children) {
			display(child);
		}
	}
	
	public static int size(Node node) {
		int s=0;
		for(Node child : node.children) {
			int cs = size(child);
			s = s + cs;
		}
		s = s + 1;
		return s;
	}
	
	public static int maxTree(Node node) {
		
		int max = Integer.MIN_VALUE;
		for(Node child : node.children) {
			int cm = maxTree(child);
			max = Math.max(cm, max);
		}
		max = Math.max(node.data, max);
		return max;
	}
	
	public static int heightoFTree(Node node) {
		int height = -1;
		for(Node child : node.children) {
			int ch = heightoFTree(child);
			height = Math.max(ch, height);
		}
		height += 1;
		return height;
	}
	
	public static void traversal(Node node) {
		//area1
		//eulers left on the way deep int the recurssion
		
		System.out.println("Node pre " + node.data);
		for(Node child : node.children) {
			//edge pre
			System.out.println("Edge pre " + node.data + "-->" + child.data);
			traversal(child);
			
			//edge post
			System.out.println("Edge post " + node.data + "-->" + child.data);
			
		}
		//eulers right on the way deep out the recurssion , post area
		System.out.println("Node post " + node.data);
		
		
	}
	
	public static void levelOrderTraversal(Node node) {
		//r p a // remove print add
		Queue<Node> q = new ArrayDeque<GenericTree.Node>();
		q.add(node);
		
		while(q.size() > 0) {
			node = q.remove();
			System.out.print(node.data + " ");
			for(Node child : node.children) {
				q.add(child);
			}
		}
	}
	
	public static void levelOrderLineWiseTraversal(Node node) {
		Queue<Node> mq = new ArrayDeque<GenericTree.Node>();
		mq.add(node);
		Queue<Node> cq = new ArrayDeque<GenericTree.Node>();
		while(mq.size() > 0) {
			node = mq.remove();
			System.out.print(node.data +" ");
			
			for(Node child : node.children) {
				cq.add(child);
			}
			if(mq.size() == 0) {
				mq = cq;
				cq = new ArrayDeque<GenericTree.Node>();
				System.out.println();
				
			}
		}
	}
	public static void mirrorTree(Node node) {
		for(Node child : node.children) {
			mirrorTree(child);
		}
		
		Collections.reverse(node.children);
	}
	
	
	public static void removeLeavesFromGenericTree(Node node) {
		
		for(int i = node.children.size() - 1 ; i >= 0 ; i--) {
			Node child = node.children.get(i);
			if(child.children.size() == 0) {
				node.children.remove(child);
			}
		}
		
		for(Node child : node.children) {
			removeLeavesFromGenericTree(child);
		}
		
		
		
	}
	
	public static void linearizeGenericTree(Node node) {
		
		for(Node child : node.children) {
			linearizeGenericTree(child);
		}
		
		while(node.children.size() > 1) {
			Node lc = node.children.remove(node.children.size() -1); // last child
			Node sl = node.children.get(node.children.size() -1); //second last
			Node slt = getTail(sl) ;// second last tail
			slt.children.add(lc);
			
			
		}
		
	}
	//get tail
	private static Node getTail(Node node) {
		while(node.children.size() == 1) {
			node = node.children.get(0);
		}
		return node;
	}
	
	
	//find elements
	public static boolean findElements(Node node , int data) {
		
		if(node.data == data) {
			return true;
		}
		
		for(Node child : node.children) {
			boolean fic = findElements(child, data);
			if(fic) {
				return true;
			}
		}
		return false;
		
	}
	
	//node to root path
	public static ArrayList<Integer> nodeToRootPath(Node node , int data) {
		
		if(node.data == data) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(node.data);
			return list;
		}
		
		
		for(Node child : node.children) {
			ArrayList<Integer> pathTillChild = nodeToRootPath(child, data);
			
			if(pathTillChild.size() > 0) {
				pathTillChild.add(node.data);
				return pathTillChild;
			}
		}
		
		return new ArrayList<Integer>();
		
	}
	
	
	// lowest common ancestors
	public static int lowestCommonAncestors(Node node , int d1 , int d2) {
		ArrayList<Integer> p1 = nodeToRootPath(node, d1);
		ArrayList<Integer> p2 = nodeToRootPath(node, d2);
		
		int i = p1.size() - 1;
		int j = p2.size() -1 ;
		while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;
		return p1.get(i);
		
		
	}
	
	//distnace btwn two nodes
	public static int distanceBWNodes(Node node , int d1 , int d2) {
		ArrayList<Integer> p1 = nodeToRootPath(node, d1);
		ArrayList<Integer> p2 = nodeToRootPath(node, d2);
		
		int i = p1.size() - 1;
		int j = p2.size() -1 ;
		while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;
		
		return i + j;
		
	}
	
	
	
	//----
	//Are tree similar
	public static boolean areSimilar(Node node1, Node node2) {
		if(node1.children.size() != node2.children.size()) {
			return false;
		}
		
		for(int i=0 ; i < node1.children.size() ;i++) {
			Node c1 = node1.children.get(i);
			Node c2 = node2.children.get(i);
			
			if(areSimilar(c1, c2) == false) {
				return false;
			}
		}
		return true;
		
		
	}
	
	
	//----
	//Are tree miror in shape
	
	public static boolean areMirror(Node node1 , Node node2) {
		if(node1.children.size() != node2.children.size()) {
			return false;
		}
		
		for(int i =0 ; i < node1.children.size() ;i++) {
			int j = node1.children.size() -1 -i;
			Node c1 = node1.children.get(i);
			Node c2 = node2.children.get(j);
			
			if(areMirror(c1 , c2) == false) {
				return false;
			}
		}
		return true;
		
		
		
	}
	//-----
	
	//-------
	//--- is tree symettric
	public static boolean isSymmetric(Node node) {
		
		return areMirror(node, node);
		
		
		
	}
	
	//-------
	//Predecessor and successor
	static Node predecessor;
	static Node successor;
	static int state;
	public static void predecessorAndSuccessor(Node node , int data) {
		if(state == 0) {
			if(node.data == data) {
				state = 1;
			}else {
				predecessor = node;
			}
		}else if(state ==1){
			successor = node;
			state =2;
		}
		for(Node child : node.children) {
			predecessorAndSuccessor(child , data);
		}
		
		
	}
	
	//---
	// ceil nd floor
	
	static int ceil;
	static int floor;
	
	public static void ceilAndFloor(Node node , int data) {
	ceil = Integer.MAX_VALUE;  // smallest andong largest
	floor = Integer.MIN_VALUE; // largest amdong smaller
	
	if(node.data  > data) {
		if(node.data < ceil) {
			ceil = node.data;
		}
	}
	
	if(node.data < data) {
		if(node.data > floor) {
			floor = node.data;
		}
	}
	
	
	for(Node child : node.children) {
		ceilAndFloor(child, data);
	}
	
	}
	//-------------
	//kth largest element
	
	public static int kthlargest(Node node , int k) {
		floor = Integer.MIN_VALUE;
		int factor = Integer.MAX_VALUE;
		for(int i =0 ; i < k ; i++) {
			ceilAndFloor(node, factor);
			factor = floor;
			floor = Integer.MIN_VALUE;
			
		}
		return factor;	
		
	}
	
	
	//----
	
	
	
	public static void levelOrderLineWiseZigZag(Node node) {
		Stack<Node> ms = new Stack<GenericTree.Node>();
		ms.push(node);
		Stack<Node> cs = new Stack<GenericTree.Node>();
		int level=1;
		
		while(ms.size() > 0) {
			node = ms.pop();
			System.out.print(node.data + " ");
			
			if(level %2 ==1) {
				for(int i=0 ; i < node.children.size(); i++) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			}else {
				for(int i= node.children.size() -1 ; i>=0 ; i--) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			}
			
			if(ms.size() == 0) {
				ms = cs;
				cs = new Stack<GenericTree.Node>();
				level++;
				System.out.println();
			}
		}
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {10,20,50,-1,60,-1,-1,30,70 ,-1,80,110,120,-1,-1,90,-1,-1,40,100,-1,-1};
		Stack<Node> st = new Stack<>();
		Node root = null;
		for(int i=0; i < arr.length ;i++) {
			if(arr[i] == -1) {
				st.pop();
			}else {
				Node t =new GenericTree().new Node();
				t.data = arr[i];
				if(st.size() > 0) {
					st.peek().children.add(t);
					
				}else {
					root = t;
				}
				st.push(t);
			}
		}
		
		display(root);
		int size = size(root);
		System.out.println("size  :" + size);
		
		
		int max = maxTree(root);
		System.out.println("max of tree : " + max);
	
	
		int height = heightoFTree(root);
		System.out.println("height  : "+ height);
	
		traversal(root);
		
		System.out.println("---Level order traversal---");
		levelOrderTraversal(root);
		System.out.println();
		System.out.println("---Level order line wise traversal---");
		levelOrderLineWiseTraversal(root);
		
		
		System.out.println("-----level order zigzag traversal----");
		levelOrderLineWiseZigZag(root);
		
		
		
		System.out.println("Find elements--");
		boolean findElements = findElements(root, 40);
		System.out.println(findElements);
		
		System.out.println("Node to root path");
		ArrayList<Integer> nodeToRootPath = nodeToRootPath(root, 40);
		System.err.println(nodeToRootPath.toString());
		
		
		System.out.println("---Lowest common ancesors");
		System.out.println(lowestCommonAncestors(root, 40, 30));
		
		
		System.out.println("Distnace between nodes---");
		int distanceBWNodes = distanceBWNodes(root, 40, 10);
		System.out.println("Distnace : "+ distanceBWNodes);
		
		
	}
}
