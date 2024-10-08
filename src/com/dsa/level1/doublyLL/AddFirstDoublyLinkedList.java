package com.dsa.level1.doublyLL;

import java.util.Scanner;

public class AddFirstDoublyLinkedList {

	public static class DoublyLinkedList {
		private class Node {
			int data;
			Node prev = null;
			Node next = null;

			Node(int data) {
				this.data = data;
			}
		}

		private Node head = null;
		private Node tail = null;
		private int size = 0;

		/* -----------*/
		// Add first in DLL
		private void addFirstNode(Node node) {
			if (this.size == 0) {
				this.head = this.tail = node;
			} else {
				node.next = this.head;
				this.head.prev = node;
				this.head = node;
			}
			this.size++;
		}

		//add first
		public void addFirst(int val) {
			Node node = new Node(val);
			addFirstNode(node);
		}
		/* -----------*/
		
		
		/* -----------*/
		//Exception
		public boolean ListIsEmptyException() {
			if(this.size ==0) {
				System.out.print("ListIsEmpty: ");
				return true;
			}
			return false;
		}
		/* -----------*/
		
		/* -----------*/
		//remove first
		private Node removeFirstNode() {
			Node node = this.head;
			if(this.size == 1)
				this.head = this.tail = null;
			else {
				Node forw = node.next;
				node.next = null;
				forw.prev = null;
				
				this.head = forw;
			}
			
			
			this.size--;
			return node;
		}
		public int removeFirst() {
			if(ListIsEmptyException())
				return -1;
			
			return removeFirstNode().data;
					
		}
		/* -----------*/
		
		//add last
		private void addLastNode(Node node) {
			if(this.size == 0) {
				this.head = this.tail = node;
			}else {
				this.tail.next = node;
				node.prev = this.tail;
				this.tail = node;
			}
			this.size++;
		}
		public void addLast(int val) {
			Node node = new Node(val);
			addLastNode(node);
		}
		
		
		
		// Remove last in DLL
		private Node removeLastNode() {
			Node node = this.tail;
			
			if(this.size == 1)
				this.head = this.tail = null;
			else {
				Node prev = node.prev;
				node.prev = null;
				prev.next = null;
				
				this.tail = prev;
						
			}
			
			
			this.size--;
			return node;
		}
		public int removeLast() {
			if(ListIsEmptyException())
				return -1;
			
			return removeLastNode().data;
		}
		/*--------------*/
		public int size() {
			return this.size;
		}
		public boolean isEmpty() {

			if(this.size ==0)
				return true;
			return false;
		}
		
		public int getFirst() {
			if(ListIsEmptyException())
				return -1;
			
			return this.head.data;
			
		}
		
		public int getLast() {
			if(ListIsEmptyException())
				return -1;
			
			return this.tail.data;
		}
		
		//getAtIndex in DLL
		
		private Node getNodeAt(int index) {
			Node curr = this.head;
			
			while(index-- > 0)
				curr = curr.next;
			
			return curr;
		}
		public int getAt(int index) {
			if(ListIsEmptyException())
				return -1;
			else if(IndexIsInvalidException(index, 0, this.size -1))
				return -1;
			return getNodeAt(index).data;
		}
		
		
		
		// add at index
		
				private void addNodeAt(int index , Node node) {
					if(index == 0)
						addFirstNode(node);
					else if(index == this.size)
						addLastNode(node);
					else {
						Node forw = getNodeAt(index);
						Node prev = forw.prev;
						
						prev.next = node;
						node.prev = prev;
						
						node.next = forw;
						forw.prev = node;
						
						this.size++;
						
					}
				}
				
				public void addAt(int index , int data) {
					if(ListIsEmptyException()) {
						System.out.println("Empty " + "-1");
					}else if(IndexIsInvalidException(index, 0, this.size)) {
						System.out.println("Invalid" + "-1");
					}else {
						Node node = new Node(data);
						addNodeAt(index , node);
					}
				}
				
				
				//remove at index in dll
				//time com  : O(n) // space O(1)
				private Node removeNodeAt(int index) {
					if(index ==0)
						return removeFirstNode();
					else if(index == this.size -1) {
						return removeLastNode();
					}else {
						Node node = getNodeAt(index);
						Node prev = node.prev;
						Node forw = node.next;
						
						prev.next = forw;
						forw.prev = prev;
						
						node.next = node.prev = null;
						this.size--;
						return node;
					}
				}
				public int removeAt(int index) {
					if(ListIsEmptyException()) {
						System.out.println("Empty");
						return -1;
					}
					else if(IndexIsInvalidException(index, 0, this.size -1)) {
						System.out.println("Invalid");
						return -1;
					}
					else {
						return removeNodeAt(index).data;
					}
					
				}
				
				//add node before node
				//time com : O(1)
				private void addBeforeNode(Node refNode , Node node) {
					Node prevNode = refNode.prev;
					if(prevNode == null) {
						node.next = refNode;
						refNode.prev = node;
						this.head = node;
					}else {
						prevNode.next = node;
						node.prev =prevNode;
						
						node.next = refNode;
						refNode.prev = node;
					}
					this.size++;
				}
				
				public void addBeforeNode(Node refNode , int data) {
					Node node = new Node(data);
					addBeforeNode(refNode, node);
				}
				public void addBefore(int idx , int data) {
					Node node = getNodeAt(idx);
					addBeforeNode(node , data);
				}
				
				
				//add after node in DLL
				//Time compleciity : O(1) space :O(1)
				private void addAfterNode(Node refNode , Node node) {
					Node forwNode = refNode.next;
					if(forwNode ==  null) {
						refNode.next = node;
						node.prev = refNode;
						
						this.tail = node;
					}else {
						refNode.next = node;
						node.prev = refNode;
						
						node.next = forwNode;
						forwNode.prev = node;
					
					}
					
					this.size++;
				}
				public void addAfter(Node refNode , int data) {
					Node node = new Node(data);
					addAfterNode(refNode, node);
				}
				
				public void addAfter(int idx , int data) {
					Node node = getNodeAt(idx);
					addAfter(node, data);
				}
				
				
				
				
				//remove node after node node in DLL
				private Node removeNodeAfterNode(Node refNode , Node node) {
					Node forwNode = refNode.next;
					if(forwNode.next == null) {
						refNode.next = null;
						forwNode.prev = null;
						
						this.tail = refNode;
						
					}else {
						refNode.next = forwNode.next;
						forwNode.next.prev = refNode;
						
						forwNode.next = forwNode.prev = null;
					}
					this.size--;
					return forwNode;
				}
				
				
				public int removeAfter(Node refNode) {
					if(refNode.next == null) {
						System.out.println("Invalid index");
						return -1;
					}
					
					return removeNodeAfterNode(refNode, refNode).data;
					
				}
				public int removeAfter(int idx) {
					Node node = getNodeAt(idx);
					return removeAfter(node);
				}
				
		
				
				//remove before node
		private Node removeBeforeNode(Node refNode) {
			Node prevNode = refNode.prev;
			if(prevNode.prev == null) {
				refNode.prev = null;
				prevNode.next = null;
				this.head = refNode;
			}else {
				prevNode.prev.next = refNode;
				refNode.prev = prevNode.prev;
				
				prevNode.prev = prevNode.next = null;
				
			}
			
			this.size--;
			return prevNode;
		}
		
		public int removeBefore(Node refNode ) {
			if(refNode.prev == null) {
				System.out.println("Invalid loc");
				return -1;
			}
			return removeBeforeNode(refNode).data;
		}
		public int removeBefore(int idx) {
			Node node = getNodeAt(idx);
			return removeBefore(node);
		}
				
				
		private boolean IndexIsInvalidException(int index , int leftRange , int rightRange) {
			if(index < leftRange || index > rightRange) {
				System.out.println("IndexIsInvalid: ");
				return true;
			}
			return false;
		}
		
		
		//
		
		public int removeNode(Node refNode) {
			Node prev = refNode.prev;
			Node forw = refNode.next;
			
			if(this.size == 1) {
				this.head = this.tail = null;
			}else if(prev == null)
			{
				this.head = forw;
			
			}else if(forw == null) {
				this.tail = prev;
			}else {
				prev.next = forw;
				forw.prev = prev;
			}
				
				refNode.prev = refNode.next = this.head.prev = this.tail = null;
				this.size--;
				return refNode.data;
		}
		
		public int removeNode(int idx) {
			Node node = getNodeAt(idx);
			return removeBefore(node);
		}
		
		
		// display forw and backward
		public void displayForw() {
			StringBuilder sb = new StringBuilder("[");
			
			Node curr = this.head;
			
			while(curr != null) {
				sb.append(curr.data);
				if(curr.next != null)
					sb.append(", ");
				curr = curr.next;
			}
			
			sb.append("]");
			System.out.println(sb.toString());
		}
		
		public void displayBack() {
StringBuilder sb = new StringBuilder("[");
			
			Node curr = this.tail;
			
			while(curr != null) {
				sb.append(curr.data);
				if(curr.prev != null)
					sb.append(", ");
				curr = curr.prev;
			}
			
			sb.append("]");
			System.out.println(sb.toString());
		
		}
		

		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node curr = this.head;
			sb.append("{");

			while (curr != null) {
				sb.append(curr.data);
				if (curr.next != null) {
					sb.append(",");
				}
				curr = curr.next;
			}
			sb.append("}");
			return sb.toString();
		}

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			DoublyLinkedList dll = new DoublyLinkedList();

			String str = sc.nextLine();

			while (!str.equals("stop")) {
				String[] s = str.split(" ");
				if (s[0].equals("addFirst"))
					dll.addFirst(Integer.parseInt(s[1]));

				else if (s[0].equals("removeFirst"))
					System.out.println(dll.removeFirst());
				
				
				else if (s[0].equals("removeLast"))
					System.out.println(dll.removeLast());
				
				else if (s[0].equals("getFirst"))
					System.out.println(dll.getFirst());
				
				
				else if (s[0].equals("getLast"))
					System.out.println(dll.getLast());
				

				else if (s[0].equals("isEmpty"))
					System.out.println(dll.isEmpty());
				
				
				else if (s[0].equals("getAt"))
					System.out.println(dll.getAt(2));
				
				
				
				str = sc.nextLine();
			}
			System.out.println(dll);
		}

		// Run application
		/*
		 * 1. Add First step
		  
		  addFirst 2 
		  addFirst 3 
		  stop
		  
		  
		  
		  2. removeFirst
		  
		  addFirst 2
addFirst 3
removeFirst
3
addFirst 4
removeFirst
4
removeFirst
2
removeFirst
ListIsEmpty: -1

		  
		 */
	}
}
