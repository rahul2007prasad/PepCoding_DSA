package com.dsa.level1;

import java.util.Scanner;

public class NPRFact {
	
	public static int f(int x) {
		int xsquare = x * x;
		return xsquare;
	}
	public static int fact(int x) {
		int rv=0;
		for(int i =1; i <=x ; i++) {
			rv = rv * i;
		}
		return rv;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int nfact = 1;
		
		for(int i =1  ;  i <= n ; i++) {
			nfact = nfact * i;
		}
		
		int nmrfact =1;
		for(int i = 1 ; i  <= n-r ; i ++) {
			nmrfact = nmrfact * i;
		}
		
		int npr = nfact / nmrfact;
		System.out.println(n + "P" + r + " = " + npr);
	}
}
