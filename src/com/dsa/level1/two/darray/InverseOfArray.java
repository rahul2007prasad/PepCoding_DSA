package com.dsa.level1.two.darray;

import java.util.Scanner;

public class InverseOfArray {
	public  static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] arr = new int[n];
		for(int i = 0 ; i < n;  i++) {
			
				arr[i] = sc.nextInt();
			
		}
		
		
		
		//
		
		
		//inverse of array
		int [] inv = new int[arr.length];
		for(int i = 0 ; i< arr.length ; i++) {
			int v = arr[i];
			
			inv[v ] = i;
		}
	}
}
