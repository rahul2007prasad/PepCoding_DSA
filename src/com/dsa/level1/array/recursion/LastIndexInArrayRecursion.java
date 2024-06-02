package com.dsa.level1.array.recursion;

import java.util.Scanner;

public class LastIndexInArrayRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();

		}
		
		int data = sc.nextInt();
		int findLastOccurance = findLastOccurance(arr, 0 , data);
		System.out.println("Last occurance of element in  array : " + findLastOccurance);
	}
	
public static int findLastOccurance(int[] arr , int idx , int data) {
		
		if(idx == arr.length) {
			return -1;
		}
		
		int liisa = findLastOccurance(arr, idx + 1, data);
		if(liisa == -1) {
			if(arr[idx] == data) {
				return idx;
			}else {
				return -1;
			}
		}else {
			
			return liisa;
		}
		
		
		
	}
}
