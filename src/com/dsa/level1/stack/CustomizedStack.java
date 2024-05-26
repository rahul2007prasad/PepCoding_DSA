package com.dsa.level1.stack;

public class CustomizedStack {
	public static class CustomStack{
		int [] data;
		int tos;
		
		public CustomStack(int cap) {
			data = new int[cap];
			tos = -1;
		}
		
		
		int size() {
			return tos + 1;
			
		}
		
		void display() {
			for(int i = tos ; i>= 0; i--) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
		
		void push(int val) {
			if(tos == data.length -1) {
				System.out.println("Stack overflow");
			}else {
				tos++;
				data[tos] = val;
			}
		}
		
		int pop() {
			if(tos == 1) {
				System.out.println("stack underflow");
				return -1;
			}else {
		        int val = data[tos];
				tos --;
				return val;
			}
		}
		
		int top() {
			if(tos == 1) {
				System.out.println("stack underflow");
				return -1;
			}else {
				return data[tos];
			}
		}
		
		
		
	}
	
	
}
