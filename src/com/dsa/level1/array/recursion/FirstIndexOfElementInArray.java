package com.dsa.level1.array.recursion;

import java.util.Scanner;

public class FirstIndexOfElementInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();

		}
		
		int data = sc.nextInt();
		int findFirstOccurance = findFirstOccurance(arr, 0 , data);
		System.out.println("First occurance of element in  array : " + findFirstOccurance);
	}
	
	public static int findFirstOccurance(int[] arr , int idx , int data) {
		
		if(idx == arr.length) {
			return -1;
		}
		if(arr[idx] == data) {
			return idx;
		}else {
			int fiisa = findFirstOccurance(arr, idx + 1, data);
			return fiisa;
		}
		
		
		
	}
}
