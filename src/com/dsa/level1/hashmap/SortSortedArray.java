package com.dsa.level1.hashmap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortSortedArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i=0 ; i < arr.length ;i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i <= k ; i++) {
			pq.add(arr[i]);
			
		}
		for(int i = k + 1 ; i < arr.length ; i++) {
			System.out.println(pq.remove());
			pq.add(arr[i]);
		}
		
		while(pq.size() > 0) {
			System.out.println(pq.remove());
		}
	}
}
