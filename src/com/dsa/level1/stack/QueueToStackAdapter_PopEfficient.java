package com.dsa.level1.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapter_PopEfficient {

	//POP and TOP Efficient
	Queue<Integer> mainQ;
	Queue<Integer> helperQ;
	
	public QueueToStackAdapter_PopEfficient() {
		mainQ = new ArrayDeque<Integer>();
		helperQ = new ArrayDeque<Integer>();
	}
	
	
	int size() {
		return mainQ.size();
	}
	
	void push(int val) {
		while(mainQ.size() > 0) {
			helperQ.add(mainQ.remove());
		}
		mainQ.add(val);
		while(helperQ.size() > 0) {
			mainQ.add(helperQ.remove());
		}
	}
	
	int pop() {
		if(size() == 0) {
			System.out.println("Stack under flow");
			return -1;
		}else {
			return mainQ.remove();
		}
	}
	
	int top() {
		if(size() == 0) {
			System.out.println("Stack under flow");
			return -1;
		}else {
			return mainQ.peek();
		}
	}
}
