package com.dsa.level1.hashmap;

import java.util.ArrayList;

public class PriorityQueueUsingHeapHashMap {
	
	public static class PriorityQueue{
		ArrayList<Integer> data;
		
		public PriorityQueue() {
			data = new ArrayList<>();
		}
		
		
		

		public void add(int val) {
			data.add(val);
			upheapify(data.size() - 1);
			
			
		}
		
		public void upheapify(int i) {
			if(i == 0) {
				
			}
			
			int pi = (i - 1) / 2;
			if(data.get(i) < data.get(pi)) {
			swap(i , pi);	
			upheapify(pi);	
			}
		}
		
		public void swap(int i , int j) {
			int ith = data.get(i);
			int jth = data.get(j);
			data.set(i, jth);
			data.set(j, ith);
		}
		
		public int remove() {
			if(this.size() == 0) {
				System.out.println("Undr flow");
				return -1;
			}
			swap(0 ,data.size() -1 );
			int val = data.size() -1;
			downheapify(0);
			return val;
		}
		
		public void downheapify(int pi) {
			int mini = pi;
			int li = 2 * pi + 1;
			if(li < data.size()  && data.get(li) < data.get(mini)){
				mini = li;
				
			}
			int ri = 2 * pi + 2;
			if(ri < data.size() && data.get(ri) < data.get(mini)) {
				mini = ri;
			}
			
			if(mini != pi ) {
				swap(pi , mini);
				downheapify(mini);
			}
			
		}
		public int peek() {
			if(this.size() == 0) {
				System.out.println("Under flow");
				return -1;
			}
			return data.get(0);
		}
		
		public int size() {
			return data.size() -1 ;
		}
	}
	
}
