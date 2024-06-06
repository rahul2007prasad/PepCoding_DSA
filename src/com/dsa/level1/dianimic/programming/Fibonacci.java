package com.dsa.level1.dianimic.programming;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fibn = fibOldApproach(n);
		System.out.println(fibn);
		
		int fibDP = fibWithMemoizationDP(n, new int[n+1]);
		System.out.println("Fib with DP : "+fibDP);	
		
	}
	
	public static int fibOldApproach(int n) {
		if(n == 0 || n ==1) {
			return n;
		}
		
		
		int fibnm1 = fibOldApproach(n - 1);
		int fibnm2 = fibOldApproach(n - 2);
		int fibn = fibnm1 + fibnm2;
		return fibn;
		
	}
	
	
	public static int fibWithMemoizationDP(int n ,int [] qb) {
		if(n == 0 || n ==1) {
			return n;
		}
		
		if(qb[n] != 0) {
			return qb[n];
		}
		
		int fibnm1 = fibWithMemoizationDP(n - 1 , qb);
		int fibnm2 = fibWithMemoizationDP(n - 2 , qb);
		int fibn = fibnm1 + fibnm2;
		
		qb[n] = fibn;
		return fibn;
		
	}
}
