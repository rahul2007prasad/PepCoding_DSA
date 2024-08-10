package com.dsa.level1.linkedlist;

public class LLToQueueAdapter {
	
	CustomLinkedList list;
	public LLToQueueAdapter() {
		list = new CustomLinkedList();
	}
	
	int size() {
		return list.size;
	}
	
	public void add(int val) {
		list.addLast(val);
	}
	
	public void remove() {
		if(size() == 0)
			System.out.println("Queue under flow");
		else
		 list.removeFirst();
	}
	public void peek() {
		if(size() == 0)
			System.out.println("Queue under flow");
		else
		 list.getFirst();
	}
	
	public void displayQueue() {
		Node temp = list.head;
		while(temp != null) {
			System.out.print(" " + temp.data);
			temp = temp.next;
		}
		
	}
}
