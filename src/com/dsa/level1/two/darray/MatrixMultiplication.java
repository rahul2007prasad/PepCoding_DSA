package com.dsa.level1.two.darray;

import java.util.Scanner;

public class MatrixMultiplication {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();

		
		
		int [][] one = new int[r1][c1];
		for(int i = 0 ; i < r1;  i++) {
			for(int j = 0; j < c1 ; j++) {
				one[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < one.length;  i++) {
			for(int j = 0; j < one[i].length ; j++) {
				System.out.print(one[i][j] + " ");
			}
			System.out.println();
		}
		

		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		
		int [][] two = new int[r2][c2];
		for(int i = 0 ; i < r2;  i++) {
			for(int j = 0; j < c2 ; j++) {
				two[i][j] = sc.nextInt();
			}
		}
		
		System.out.println();
		
		for(int i = 0 ; i < two.length;  i++) {
			for(int j = 0; j < two[i].length ; j++) {
				System.out.print(two[i][j] + " ");
			}
			System.out.println();
		}
		
		int[][] prd = new int[r1][c2];
		
		if(c1 != r2) {
			System.out.println("Invalid input");
			return;
		}
		
		for(int i =0 ; i < prd.length ; i++) {
			for(int j =0 ; j< prd[0].length ; j++) {
				for(int k =0; k < c1 ; k++) {
					prd[i][j] += one[i][k] * two[k][j];
				}
			}
		}
		
		System.out.println("Product of matrix");
		for(int i = 0 ; i < prd.length;  i++) {
			for(int j = 0; j < prd[i].length ; j++) {
				System.out.print(prd[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
}
