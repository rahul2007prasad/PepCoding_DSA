package com.dsa.level1.dianimic.programming;

import java.util.Scanner;

public class ClimbingStairsDP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cp = countPaths(n);
		
		int countPathsMemoization = countPathsMemoization(n, new int[n + 1]);
		
		System.out.println(cp);
		System.out.println("Memoization " + countPathsMemoization);
		System.out.println("With tabulation" + countPathsTabulation(n));
	}
	
	
	// repetition in this solution
	public static int countPaths(int n) {
		if(n == 0) {
			return 1;
		}else if(n < 0) {
			return 0;
		}
		
		int nm1 = countPaths(n - 1);
		int nm2 = countPaths(n - 2);
		int nm3 = countPaths(n - 3);
		
		int cp = nm1 + nm2 + nm3;
		
		return cp;
		
		
	}
	
	// with memoization
	public static int countPathsMemoization(int n , int []qb) {
		
		if(n == 0) {
			return 1;
		}else if(n < 0) {
			return 0;
		}
		
		if(qb[n] > 0) {
			return qb[n];
		}
		
		int nm1 = countPathsMemoization(n - 1 , qb);
		int nm2 = countPathsMemoization(n - 2 , qb);
		int nm3 = countPathsMemoization(n - 3 , qb);
		
		int cp = nm1 + nm2 + nm3;
		qb[n] = cp;
		
		return cp;
	}
	
	// with tabulation
	
	public static int countPathsTabulation(int n) {
		int [] dp = new int[n + 1];
		dp[0] = 1;
		
		for(int i = 1 ; i <= n ;  i++) {
			if(i == 1) {
				dp[i] = dp[i -1];
			}else if(i == 2) {
				dp[i] = dp[i -1 ] + dp[i -2];
			}else {
				dp[i] = dp[i -1] + dp[i - 2] + dp[i -3];
				
			}
			
		}
		
		return dp[n];
	}
}
