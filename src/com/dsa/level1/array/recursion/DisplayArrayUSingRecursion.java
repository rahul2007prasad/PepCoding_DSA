package com.dsa.level1.array.recursion;

import java.util.Scanner;

public class DisplayArrayUSingRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0 ; i < n;  i++) {
			
				arr[i] = sc.nextInt();
			
		}
		displayArr(arr, 0);
	}
	
	public static void displayArr(int[] arr , int idx) {
		if(idx == arr.length) {
			return;
		}
		System.out.println(arr[idx]);
		displayArr(arr, idx + 1);
		
	}
}
