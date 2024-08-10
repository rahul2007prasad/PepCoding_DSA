package com.dsa.level1.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStack_PushEfficient {

	//Push Efficient
	Queue<Integer> mainQ;
	Queue<Integer> helperQ;
	
	public QueueToStack_PushEfficient() {
		mainQ = new ArrayDeque<Integer>();
		helperQ = new ArrayDeque<Integer>();
	}
	
	
	int size() {
		return mainQ.size();
	}
	
	void push(int val) {
		mainQ.add(val);
	}
	
	int pop() {
		
	}
	
	int top() {
		
	}
}
