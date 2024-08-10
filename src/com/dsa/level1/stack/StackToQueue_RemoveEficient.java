package com.dsa.level1.stack;

import java.util.Stack;

public class StackToQueue_RemoveEficient {
	public static class StackToQueueAdapter{
		
		
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
			
		}
		
		int remove() {
			
		}
		
		int peek() {
			
		}
	}
}
