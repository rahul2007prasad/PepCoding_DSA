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

		public void addFirst(int val) {
			Node node = new Node(val);
			addFirstNode(node);
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
		  
		 */
	}
}
