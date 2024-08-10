package com.dsa.level1.stack;

import java.util.Stack;

public class StackToQueue_RemoveEficient {
	public static class StackToQueueAdapter{
	//Remove Efficient
		
		Stack<Integer> mainS;
		Stack<Integer> helperS;
		
		public StackToQueueAdapter() {
			mainS = new Stack<Integer>();
			helperS = new Stack<Integer>();
		}
		
		int size() {
			return mainS.size();
		}
		
		void add(int val) {
			while(mainS.size() > 0) {
				helperS.push(mainS.pop());
			}
			mainS.push(val);
			
			while(helperS.size() > 0) {
				mainS.push(helperS.pop());
			}
		}
		
		int remove() {
			if(size() == 0) {
				System.out.println("Queue under flow");
				return -1;
			}else {
				return mainS.pop();
			}
		}
		
		int peek() {
			if(size() == 0) {
				System.out.println("Queue under flow");
				return -1;
			}else {
				return mainS.peek();
			}
		}
	}
}
