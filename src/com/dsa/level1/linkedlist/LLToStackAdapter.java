package com.dsa.level1.linkedlist;

public class LLToStackAdapter {
	
	CustomLinkedList  li ;
	
	public LLToStackAdapter() {
		li = new CustomLinkedList();
	}
	
	public int size() {
		return li.size();
	}
	public void push(int data) {
		li.addFirst(data);
	}
	
	public void pop() {
		//li.removeFirst();
		if(li.size ==0) {
			System.out.println("Empty stack");
			//return -1;
		}else {
			li.removeFirst();
		}
	}
	public void top() {
		if(size() ==0) {
			System.out.println("Empty stack");
			//return -1;
		}else {
			 li.getFirst();
		}
		 int first = li.getFirst();
		 System.out.println(" " + first);
	}
	
	public void displayStack() {
		Node temp = li.head;
		
		while(temp !=null) {
			
			System.out.print(" "+ temp.data);
			temp= temp.next;
			
		}
			
	}
	
}
