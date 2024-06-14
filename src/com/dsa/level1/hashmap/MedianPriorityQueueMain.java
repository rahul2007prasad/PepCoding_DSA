package com.dsa.level1.hashmap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianPriorityQueueMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
	}
	
	public static class MedianPriorityQueue{
		PriorityQueue<Integer> left;
		PriorityQueue<Integer> right;
		
		
		public MedianPriorityQueue() {
			left = new PriorityQueue<Integer>(Collections.reverseOrder());
			right = new PriorityQueue<Integer>();
		}
	}
}
