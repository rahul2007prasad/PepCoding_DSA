package com.dsa.level1;

import java.util.Scanner;

public class IsPrime {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t ; i++) {
			int n = sc.nextInt();
			int count=0;
			for(int div =1 ; div <= n ; div++) {
				if(n % div ==0) {
					count++;
				}
			}
			if(count ==2) {
				System.out.println("Number is prime");
			}else {
				System.out.println("num is not prime");
			}
			
		}
	}
	
	public static void isPrimeBetter() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t ; i++) {
			int n = sc.nextInt();
			int count=0;
			for(int div =2 ; div*div <= n ; div++) {
				if(n % div ==0) {
					count++;
					break; //optimal
				}
			}
			if(count ==0) {
				System.out.println("Number is prime");
			}else {
				System.out.println("num is not prime");
			}
			
		}
	
	}
	
}
