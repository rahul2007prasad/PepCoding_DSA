package com.dsa.level1.array2;

public class SentinelSearch {
	public static void main(String[] args) {
		int arr[] = {3,4,2,7,9,8};
		int key = 0;
		sentinelSearch(arr, key);
		
	}
	public static void sentinelSearch(int arr[], int key) {
		//TC : 0(N)
		//SC 0(1)
		int n = arr.length;
		int last = arr[n-1];
		arr[n-1] = key;
		
		int i=0;
		while(arr[i] != key)
			++i;
		
		arr[n-1] = last;
		if( (i < n-1) || arr[n-1] == key )
			System.out.println("Key is present at  index : "+ i);
		else
			System.out.println("key is not present");
	}
}
