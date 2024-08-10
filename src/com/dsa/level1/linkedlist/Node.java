package com.dsa.level1.linkedlist;

public class Node {

	int data;
	Node node;
	Node next;
	
	public Node(int data , Node node , Node next) {
		this.data = data;
		this.node = node;
		this.next = next;
	}
	
	public Node(int data) {
		this.data = data;
		this.node = null;
	}
	public Node() {
		
	}
}
