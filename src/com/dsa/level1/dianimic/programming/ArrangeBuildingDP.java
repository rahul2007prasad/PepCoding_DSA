package com.dsa.level1.dianimic.programming;

import java.util.Scanner;

public class ArrangeBuildingDP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int ob = 1; // old building
		int os = 1; //old space
		for(int i = 2 ; i <= n ;i++) {
			int nb = os;
			int ns = os + ob ;
			
			os = ns;
			ob = nb;
		}
		int total = os + ob;
		total *= total;
		System.out.println(total);
	}
}
