package com.dsa.level1.recursion;

import java.util.Scanner;

public class PowerRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		
		int pow = pow(x , n);
		System.out.println(x + " pow  " + n + " : "+ pow);
	}
	
	public static int pow(int x , int n) {
		if(n == 0) {
			return 1;
		}
		int xnm1 = pow(x , n - 1);
		int xn = x * xnm1;
		return xn;
		
	}
}
