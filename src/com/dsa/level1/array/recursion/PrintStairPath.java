package com.dsa.level1.array.recursion;

import java.util.Scanner;

public class PrintStairPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printStairPath(n , "");
	}
	
	public static void printStairPath(int n , String path) {
		if(n < 0 ) {
			return;
		}
		
		if(n == 0) {
			System.out.print(path +" ");
			return;
		}
		printStairPath(n - 1, path + "1");

		printStairPath(n - 2, path + "2");
		printStairPath(n - 3, path + "3");
		}
}
