package com.dsa.level1.recursion;

import java.util.Scanner;

public class PrintIncreasingRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		printIncresing(n);

	}
	
	public static void printIncresing(int n) {
		if(n == 0) {
			return ;
		}
		printIncresing(n -1 );
		System.out.println(n);
	}
}
