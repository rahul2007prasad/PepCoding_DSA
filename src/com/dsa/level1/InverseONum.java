package com.dsa.level1;

import java.util.Scanner;

public class InverseONum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int op =1; //original position
		int inv =0; 
		
		while(n !=0) {
			int od = n % 10; //original digit
			int id = op;  //inverted digit
			int ip = od; //inverted position
			
			
			//make changes to inverted using ip and id
			inv = inv + id * (int)Math.pow(10, ip -1);
			
			n = n / 10;
			op++;
			
		}
		System.out.println(inv);
	}
}
