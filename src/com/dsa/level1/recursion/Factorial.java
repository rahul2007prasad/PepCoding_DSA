package com.dsa.level1.recursion;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int fact = fact(n);
		System.out.println("factorial  " + fact);
	}
	
	public static int fact(int n) {
			
		if(n == 1) {
			return 1;
		}
		int fnm1 = fact(n - 1);
		int fn = n * fnm1;
		return fn;
	}
}
