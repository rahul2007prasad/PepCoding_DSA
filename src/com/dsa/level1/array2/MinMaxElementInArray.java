package com.dsa.level1.array2;

import java.util.Arrays;

public class MinMaxElementInArray {
	public static void main(String[] args) {
		
		int arr[] = {2,4,6,3,8,9,3,4};
		minMax(arr);
		
		
		int min = min(arr);
		int max = max(arr);
		System.out.println("---");
		//TC : O(n)
		System.out.println("min : "+ min +" max : " + max);
	}
	
	public static void minMax(int arr[]) {
		//TC : O(nlogn)
		//SC : O(1)
		int n = arr.length;
		Arrays.sort(arr);
		System.out.println("Min : " + arr[0] + " max : "+ arr[n-1]);
	}
	public static int min(int arr[]) {
		int res =arr[0];
		for(int i=1; i < arr.length ; i++) {
			res = Math.min(res, arr[i]);
			
		}
		return res;
	}
	
	public static int max(int arr[]) {
		int res=arr[0];
		for(int i=1 ; i < arr.length; i++)
			res= Math.max(res, arr[i]);
		
		return res;
	}
}
