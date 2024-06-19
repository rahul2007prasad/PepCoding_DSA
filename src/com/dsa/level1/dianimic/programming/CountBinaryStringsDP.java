package com.dsa.level1.dianimic.programming;

import java.util.Scanner;

public class CountBinaryStringsDP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		/*
		//Approach 1
		int[] dp0  = new int[n + 1]; // arrays of zeros
		int[] dp1 = new int[n + 1]; //arrays of ones
		
		dp0[1] = 1;
		dp1[1] = 1;
		
		for(int i = 2  ; i <= n ; i++) {
			dp1[i] = dp1[i -1 ]+ dp0[i -1];
			dp0[i] = dp1[i - 1];
			
			
		}
		System.out.println(dp1[n] + dp0[n]);
		
		*/
		
		int oczeros = 1;
		int ocones = 1;
		
		for(int i =2 ; i <= n ; i++) {
			int nczeros = ocones;
			int ncones = oczeros + ocones;
			
			ocones = ncones;
			
			oczeros = nczeros;
		}
		System.out.println(oczeros + ocones);
		
		
	}
}
