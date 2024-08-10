package com.dsa.level1.array2;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 7, 9, 10 };

		int key = 0;
		
		int binarySearch = binarySearch(arr, key);
		
		if(binarySearch == -1)
			System.out.println("key not found" );
		else
			System.out.println("key is  found at index "+ binarySearch);

		
		System.out.println("---------");
		int bSearchRec = bSearchRec(arr, key);
		
		if(bSearchRec == -1)
			System.out.println("Element not found");
		
		else
			System.out.println("Item found at  index :" + bSearchRec);
	}

	//Iterative approach
	public static int binarySearch(int arr[], int key) {
		// TC O(log N)
		//SC O(1)
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {

			int mid = low + ((high - low) / 2);

			if (arr[mid] == key)
				return mid;

			// if key is less than mid,
			if(arr[mid] < key)
				low = mid +1;
				
			
			else
				high = mid -1;
			

		}
		return -1;
		
	}
	
	public static int bSearchRec(int arr[] , int key) {
		int n = arr.length ;
		int low = 0;
		int high = n-1;
		int binarySerchRecurisve = binarySerchRecurisve(arr, low, high, key);
		return binarySerchRecurisve;
	}
	public static int binarySerchRecurisve(int arr[] , int low , int high , int key) {
		
		if(low  <= high) {
			int mid = low  + ((high - low) /2);
			
			if(arr[mid] == key)
				return mid;
			
			if(arr[mid] > key)
				return binarySerchRecurisve(arr, low, mid -1, key);
			
			return binarySerchRecurisve(arr, mid +1, high, key);
		}
		return -1;
	}
}
