package com.dsa.level1.array.recursion;

import java.util.Scanner;

public class MaxOfArrayRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();

		}
		int maxArray = maxArray(arr, 0);
		System.out.println("Max of array : " + maxArray);
	}

	public static int maxArray(int arr[], int idx) {
		if(idx == arr.length - 1) {
			return arr[idx];
		}
		int misa = maxArray(arr, idx + 1);// max in smaller array
		if (misa > arr[idx]) {
			return misa;
		} else {
			return arr[idx];
		}

	}
}
