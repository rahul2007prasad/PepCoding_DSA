package com.dsa.level1.stack;

import java.util.Stack;

public class StackToQueue_AddEfficient {
public static class StackToQueueAdapter{
		//Add efficent
		
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
			mainS.push(val);
		}
		
		int remove() {
			
			if(size() == 0) {
				System.out.println("Queu under flow");
				return -1;
			}else {
				while(mainS.size() > 1) {
					helperS.push(mainS.pop());
				}
				
				int val = mainS.pop();
				
				
				while(helperS.size() > 0) {
					mainS.push(helperS.pop());
				}
				
				return val;
			}
		}
		
		int peek() {

			if(size() == 0) {
				System.out.println("Queu under flow");
				return -1;
			}else {
				while(mainS.size() > 1) {
					helperS.push(mainS.pop());
				}
				
				int val = mainS.pop();
				helperS.push(val);
				
				while(helperS.size() > 0) {
					mainS.push(helperS.pop());
				}
				
				return val;
			}
		}
	}
}
