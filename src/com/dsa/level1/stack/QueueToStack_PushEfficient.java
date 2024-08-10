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
		if(size() == 0) {
			System.out.println("stack under flow");
			return -1;
		}else {
			while(mainQ.size() > 1) {
				helperQ.add(mainQ.remove());
			}
			int val = mainQ.remove();
			
			
			while(helperQ.size() > 0) {
				mainQ.add(helperQ.remove());
			}
			return val;
		}
	}
	
	int top() {
		if(size() == 0) {
			System.out.println("stack under flow");
			return -1;
		}else {
			while(mainQ.size() > 1) {
				helperQ.add(mainQ.remove());
			}
			int val = mainQ.remove();
			helperQ.add(val);
			
			while(helperQ.size() > 0) {
				mainQ.add(helperQ.remove());
			}
			return val;
		}
	}
}
