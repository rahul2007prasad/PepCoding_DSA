package com.dsa.level1.array2;

public class SubArrayWithGivenSum {
	public static void main(String[] args) {
		int arr[] = {15,2,4,8,9,5,10,23};
		int sum =14;
		subArray(arr, sum);
		System.out.println("Sliding window concept");
		slidingWindowSubArraySum(arr, sum);
	}
	
	public static void subArray(int []arr, int sum) {
		for(int i =0 ; i< arr.length ; i++ ) {
			int currentSum = arr[i];
			if(currentSum == sum) {
				System.out.println("sum found at index : " + i);
				return;
			}
			else {
				for(int j=i+1; j< arr.length ; j++) {
					currentSum+= arr[j];
					
					if(currentSum == sum) {
						System.out.println("sum found btwn inde : " + i + " " + j);
						return;
					}
				}
			}
				
		}
		System.out.println("No sub array found");
		return;
	}
	
	//using sliding window concept
	
	public static int slidingWindowSubArraySum(int[] arr , int sum) {
		
		int currentSum = arr[0];
		int start =0; 
		for(int i=1; i < arr.length ; i++) {
			while(currentSum > sum && start < i-1) {
				currentSum = currentSum - arr[start];
				start++;
			}
			
			if(currentSum == sum) {
				int p=i-1;
				System.out.println("sum found btwn " + start  + " " + p);
				return 1;
			}
			if(i < arr.length)
				currentSum = currentSum + arr[i];
		}
		System.out.println("No sub array found");
		return 0;
		
	}
}
