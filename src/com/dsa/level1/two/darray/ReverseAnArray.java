package com.dsa.level1.two.darray;

import java.util.Scanner;

public class ReverseAnArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		int [] arr = new int[n];
		for(int i = 0 ; i < n;  i++) {
			
				arr[i] = sc.nextInt();
			
		}
		
		int i =0;
		int j =arr.length -1;
		
		while(i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			
			i++;
			j--;
		}
		
		display(arr);
		
		
	}
	
	public static void display(int arr[]) {
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
}
