package com.dsa.level1.array;

import java.util.Scanner;

public class SmallestSubArrayContainsMaxMinElement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int subArrayWithMaxMinElement = subArrayWithMaxMinElement(arr);
		System.out.println("Lenght  : "+ subArrayWithMaxMinElement);
		
	}
	
	
	public static int subArrayWithMaxMinElement(int[] arr) {
		int minValue =arr[0];
		for(int i=0; i < arr.length ; i++) {
			if(arr[i] < minValue) {
				minValue = arr[i];
			}
		}
		
		int maxValue = arr[0];
		for(int i=0; i < arr.length  ; i++) {
			if(arr[i] > maxValue) {
				maxValue= arr[i];
			}
		}
		
		int minPos = -1;
		int maxPos = -1;
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length ; i ++) {
			if(arr[i] == minValue)
				minPos = i;
			
			if(arr[i] == maxValue)
				maxPos = i;
			
			if(maxPos != -1 && minPos != -1)
				ans = Math.min(ans, 
						Math.abs(minPos - maxPos) + 1
						);
		}
		
		return ans;
	}
}
