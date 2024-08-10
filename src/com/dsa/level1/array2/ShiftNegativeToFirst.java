package com.dsa.level1.array2;

import java.util.Arrays;

public class ShiftNegativeToFirst {
	public static void main(String[] args) {
		
		int arr[] = {-1,2,-3,4,-5,6,-7};
		move(arr);
		
		for(int e : arr)
			System.out.print(" " + e);
	}
	
	//TC O(nlogn)  
	public static void move(int [] arr) {
		Arrays.sort(arr);
	}
}
