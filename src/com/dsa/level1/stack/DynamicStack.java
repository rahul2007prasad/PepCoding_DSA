package com.dsa.level1.stack;

public class DynamicStack {
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
				int[] ndata = new int[2 * data.length];
				for(int i =0 ; i < data.length ; i++) {
					ndata[i] = data[i];
				}
				data = ndata;
				tos++;
				data[tos] = val;
				
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
