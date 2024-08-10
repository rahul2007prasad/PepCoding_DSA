package com.dsa.level1.array2;

public class LinearSearch {
	public static void main(String[] args) {
		int [] arr = {1,4,5,2,6,8,9};
		int key =2;
		
		int search = search(arr, key);
		if(search == -1)
			System.out.println("Item not found");
		else
			System.out.println("Item found at index " + search);
		
		
	}
	public static int search(int arr[] , int key) {
		//Time complexicity : 0(N)
		for(int  i = 0; i < arr.length ; i++) {
			if(arr[i] == key) {
				return i;
			}
			
		}
		return -1;
		
	}
}
