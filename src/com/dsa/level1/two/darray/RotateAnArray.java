package com.dsa.level1.two.darray;

import java.util.Scanner;

public class RotateAnArray {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		int [] arr = new int[n];
		for(int i = 0 ; i < n;  i++) {
			
				arr[i] = sc.nextInt();
			
		}
		
		
		
	

	}
	
	
	
	public static void reverse(int [] arr , int i , int j) {
		//rotate an array by k
				
				int li = i;
				int ri = j;
				
				while(i < j) {
					int temp = arr[li];
					arr[ri] = temp;
					li++;
					ri--;
					
				}
	}
	
	//rotate by k
	public static void rotate(int[] a ,int k) {
		
		k = k % a.length;
		if(k < 0) {
			k = k + a.length;
		}
		reverse(a, 0, a.length -k -1);
		
		reverse(a, a.length - k , a.length -1);
			
		reverse(a ,0,a.length -1);
			
		}
}
