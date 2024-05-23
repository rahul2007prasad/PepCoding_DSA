package com.dsa.level1;

import java.util.Scanner;

public class DigitFrequency {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		int res=0;
		
		while(n > 0) {
			int dig  = n % 10;
			n= n / 10;
			
			if(dig  == d) {
				res++;
			}
		}
		
			System.out.println(res);
	}
}
