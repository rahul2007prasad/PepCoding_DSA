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
