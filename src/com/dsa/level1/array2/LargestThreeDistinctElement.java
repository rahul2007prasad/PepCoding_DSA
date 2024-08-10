package com.dsa.level1.array2;

public class LargestThreeDistinctElement {
	public static void main(String[] args) {
		int arr[]= {2,5,7,9,10,10,20,5};
		largestThree(arr);
		
	}
	
	//brute force
	//TC O(N)
	public static void largestThree(int [] arr) {
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		int thirdlargest = Integer.MAX_VALUE;
		
		if(arr.length < 3)
			System.out.println("Invalid input");
		
		for(int i =0 ; i < arr.length ; i++) {
			
			if(arr[i] > firstLargest) {
				thirdlargest = secondLargest;
				secondLargest = firstLargest;
				firstLargest = arr[i];
			}
			else if(arr[i] > secondLargest && arr[i] != firstLargest) {
					thirdlargest = secondLargest;
					secondLargest = arr[i];
			}
			else if(arr[i] > thirdlargest && arr[i] != secondLargest) {
					thirdlargest = arr[i];
			}
		}
	System.out.println("First : " + firstLargest + " Second : " + secondLargest + " Third : " + thirdlargest);	
	}
	
}
