package com.dsa.level1.array2;

public class FindPeakElement {
	// Find a peak element which is not smaller than its neighbours
	
	public static void main(String[] args) {
		 int arr[] = { 1, 3, 20, 4, 1, 0 };
		System.out.println("Peak element index: " + findPeak(arr));
	
		System.out.println("Peak element using binaty searh : " + peakelementBinarySearch(arr));
	}
	
	public static int findPeak(int arr[]) {
		int n = arr.length;
		
		if(n ==1 )
			return arr[0];
		
		if(arr[0] >= arr[1])
			return arr[0];
		if(arr[n-1] >= arr[n-2])
			return arr[n-1];
		int res=0;
		for(int i=1; i < n-1  ; i++) {
			if(arr[i] >= arr[i-1] && arr[i] >= arr[i+1])
				//res = arr[i];
				return arr[i];
		}
		return 0;
		
		
		
	}
	
	public static int peakelementBinarySearch(int arr[]) {
		int n = arr.length;
		
		if(n== 1)
			return arr[0];
		
		if(arr[0] > arr[1])
			return arr[0];
		
		if(arr[n-1] > arr[n-2])
			return arr[n-1];
		
		int low = 1;
		int high = n-2;
		while(low <= high) {
			int mid = low + ((high -low) /2);
			
			if(arr[mid -1] < arr[mid] && arr[mid] > arr[mid+1])
				return arr[mid];
			
			if(arr[mid] > arr[mid -1])
				low = mid +1;
			else
				high = mid -1;
		}
		return 0;
			
				
	}
}
