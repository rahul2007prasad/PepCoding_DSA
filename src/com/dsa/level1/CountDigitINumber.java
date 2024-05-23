package com.dsa.level1;

import java.util.Scanner;

public class CountDigitINumber {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			int digit =0 ;
			
			while(n !=0) {
				n = n /10;
				digit++;
			}
			System.out.println("Num of digit " + digit);
		}
}
