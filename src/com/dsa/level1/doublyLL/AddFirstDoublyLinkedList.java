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
		
		private boolean IndexIsInvalidException(int index , int leftRange , int rightRange) {
			if(index < leftRange || index > rightRange) {
				System.out.println("IndexIsInvalid: ");
				return true;
			}
			return false;
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