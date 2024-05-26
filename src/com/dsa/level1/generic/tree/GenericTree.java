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
		
	}
}
