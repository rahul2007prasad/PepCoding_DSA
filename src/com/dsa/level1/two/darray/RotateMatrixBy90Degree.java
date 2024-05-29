package com.dsa.level1.two.darray;

import java.util.Scanner;

public class RotateMatrixBy90Degree {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int [][] arr = new int[n][m];
		for(int i = 0 ; i < n;  i++) {
			for(int j = 0; j < m ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < arr.length;  i++) {
			for(int j = 0; j < arr[i].length ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//transpose
		for(int i = 0; i < arr.length ; i++) {
			for(int j =i; j < arr[0].length ;j++) {
			int temp = arr[i][j];
			arr[i][j] = arr[j][i];
			arr[j][i] = temp;
			}
		}
		
		for(int i= 0 ; i < arr.length  ;i++) {
			int li = 0;
			int ri = arr[i].length -1 ;
			while(li < ri) {
				
				int temp = arr[i][li];
				arr[i][li] = arr[i][ri];
				arr[i][ri] = temp;
				i++;
				ri--;
			}
			
		}
		display(arr);
		
	}
	
	public static void display(int[][] arr) {
		for(int i = 0 ; i < arr.length;  i++) {
			for(int j = 0; j < arr[i].length ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
