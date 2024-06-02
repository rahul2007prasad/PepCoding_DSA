package com.dsa.level1.array.recursion;

import java.util.Scanner;

public class AllIndicesInArrayRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();

		}
		
		int data = sc.nextInt();
		int allIndices[] = allIndices(arr, data , 0 ,0);
		for (int i = 0; i < allIndices.length; i++) {

			System.out.print(" " + allIndices[i]);

		}
		
	}
	
public static int[] allIndices(int[] arr , int data , int idx , int fsf) {
		
		if(idx == arr.length) {
			return new int[fsf];
		}
		if(arr[idx] == data) {
			int[] allIndices = allIndices(arr, data, idx + 1, fsf + 1);
			allIndices[fsf] = idx;
			return allIndices;
			
		}else {
			int[] allIndices = allIndices(arr, data, idx + 1, fsf);
			return allIndices;
		}
		
		
		
	}
}

