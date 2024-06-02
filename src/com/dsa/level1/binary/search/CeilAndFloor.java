package com.dsa.level1.binary.search;

import java.util.Scanner;

public class CeilAndFloor {
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
		int ceil =0 ;
		int floor = 0;
		
		while(low <= high) {
			int mid = low + (high - low ) / 2;
			
			if(data < arr[mid]) {
				high = mid -1;
				ceil = arr[mid];
			}else if(data > arr[mid]) {
				low = mid + 1;
				floor = arr[mid];
			}else {
				ceil = arr[mid];
				floor = arr[mid];
				break;
			}
			
		}
		System.out.print("ceil" + ceil + " ");
		System.out.println();
		System.out.print("Floor " + floor +" ");
		
		
	}
}
