package com.dsa.level1.array2;

public class NumberOfOccurance {
	public static void main(String[] args) {
		int arr [] = {1,2,2,3,3,4,5,6,7,7,7,8};
		int key=7;
		
		System.out.println("num of occurance : "+ numOfOccurance(arr, key));
	
		int low = 0;
		int high = arr.length -1;
		
		int numOfOccuranceBinarySEarch = numOfFirstOccuranceBinarySEarch(arr, low, high, key);
		
		System.out.println("Binary first occurance  : " + numOfOccuranceBinarySEarch);
		
		
		int numOfLastOccuranceBinarySEarch = numOfLastOccuranceBinarySEarch(arr, low, high, key);
		System.out.println("Last occurance binary search :"+ numOfLastOccuranceBinarySEarch);
		System.out.println("Total occurance :" + (numOfLastOccuranceBinarySEarch -  numOfOccuranceBinarySEarch +1));
	}
	
	//Linear search
	//TC O(n)
	public static int numOfOccurance(int[] arr , int key) {
		int res=0;
		
		for(int i=0 ; i < arr.length ; i++) {
			if(arr[i] == key)
				res++;
			
		}
		return res;
	}
	
	
	// TC O(n)
	//binary search
	public static int numOfFirstOccuranceBinarySEarch(int arr[] , int low , int high ,int key) {
		
		if(low <= high) {
			int mid = low + ((high - low) /2);
			
			if(mid ==0 || key > arr[mid -1] && arr[mid] == key) {
				return mid;}
			else if(key > arr[mid]) {
				return numOfFirstOccuranceBinarySEarch(arr,(mid +1) , high , key);}
			else {
				return numOfFirstOccuranceBinarySEarch(arr , low , mid -1 , key);}
		
		}
		return -1;
	}
	
	public static int numOfLastOccuranceBinarySEarch(int arr[] , int low , int high ,int key) {
		int n = arr.length -1;
		if(high >= low) {
			int mid = low + ((high - low ) /2);
			
			if(mid == n || key < arr[mid+1] && arr[mid] ==key )
				return mid;
			else if(key < arr[mid])
				return numOfLastOccuranceBinarySEarch(arr, low, mid-1, key);
			else
				return numOfLastOccuranceBinarySEarch(arr, mid+1, high, key);
		}
		return -1;
	}
}
