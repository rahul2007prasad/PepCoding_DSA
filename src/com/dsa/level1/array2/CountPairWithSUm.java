package com.dsa.level1.array2;

import java.util.Arrays;

public class CountPairWithSUm {
	public static void main(String[] args) {
		int arr[] = {1,2,3,5,5,8};
		int key=10;
		int n = arr.length;
		getPairount(arr, key);
		int pairCount = getPairCount(arr, n, key);
		System.out.println("count pair sum" + pairCount);
		
	}
	//TC O(n2)
	public static void getPairount(int arr[] , int key) {
		int count =0;
		
		for(int i=0; i < arr.length ; i++)
			for(int j = i + 1; j < arr.length ; j++)
				if((arr[i] + arr[j]) == key)
					count++;
		
		System.out.println("Count pairs is " + count);
	}
	
	// using binary search
	
	public static int lowerBound(int[] arr , int low , int high , int key) {
		
		while(low < high) {
			int mid = low + ((high - low) /2 );
			if(arr[mid] < key) {
				low = mid+1;
			}
			else
				high = mid;
		}
		return low;
	}
	
	//upper bound
	
	public static int upperBound(int[] arr , int low ,int high , int key ) {
		while(low  < high) {
			int mid = low + ((high - low) /2);
			if(arr[mid] <= key)
				low =  mid+1;
			else
				high = mid;
			
		}
		return low;
	}
	
	public static int getPairCount(int[]arr , int n , int key) {
		Arrays.sort(arr);
		int c=0;
		for(int i=0; i< n-1 ; i++) {
			int x = key - arr[i];
			int y = lowerBound(arr,  i +1,n, x);
			int z = upperBound(arr,i+1, n, x);
			c = c+z-y;
		}
		return c;
	}
}
