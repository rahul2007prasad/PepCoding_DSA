package com.dsa.level1.recursion;

import java.util.Scanner;

public class PowerRecursionLograthmic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		//x to pow n = (x to pow n/2 )* (x to pow n/2)
		
		int pow = pow(x , n);
		System.out.println(x + " pow  " + n + " : "+ pow);
	}
	
	public static int pow(int x , int n) {
		if(n == 0) {
			return 1;
		}
		int xpnb2 = pow(x , n / 2);
		int xn = xpnb2 * xpnb2;
		if(n % 2 == 1) {
			xn = xn * x;
		}
		return xn;
		
	}
}
