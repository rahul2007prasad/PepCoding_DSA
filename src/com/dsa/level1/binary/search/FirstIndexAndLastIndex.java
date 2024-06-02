package com.dsa.level1.binary.search;

import java.util.Scanner;

public class FirstIndexAndLastIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		int [] arr = new int[n];
		for(int i = 0 ; i < n;  i++) {
			
				arr[i] = sc.nextInt();
			
		}
		
		for(int i=0 ; i < arr.length ; i++) {
			
					System.out.print(arr[i] + "\t");
				
			
		}
		
		
		int data = sc.nextInt();
		int low = 0;
		int high = arr.length -1;
		
		int fi = -1;
		
		while(low  <= high) {
			int mid = low + (high - low )/2;
			
			if(data < arr[mid]) {
				high = mid - 1;
			}else if(data > arr[mid]) {
				low = mid +1 ;
			}else {
				fi = mid;
				high = mid -1;
			}
		}
		
		System.out.println("FIrst Index "+ fi);
		
		low = 0;
		high = arr.length -1;
		int li = -1;

		while(low  <= high) {
			int mid = low + (high - low )/2;
			
			if(data < arr[mid]) {
				high = mid - 1;
			}else if(data > arr[mid]) {
				low = mid +1 ;
			}else {
				li = mid;
				low = mid + 1;
			}
		}
		
		System.out.println("Last Index "+ li);
		
	}
}
