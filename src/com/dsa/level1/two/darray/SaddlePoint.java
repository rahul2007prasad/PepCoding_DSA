package com.dsa.level1.two.darray;

import java.util.Scanner;

public class SaddlePoint {
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
		
		
		//sadle point....min in row and max in column
		
		for(int i =0; i < arr.length ; i++) {
			
			int svj = 0;
			for(int j= 1; j < arr[0].length ; j++) {
				if(arr[i][j] < arr[i][svj]) {
					svj = j;
				}
				
			}
			
			boolean flag = true;
			for(int k  = 0 ; k < arr.length ; k++) {
				if(arr[k][svj] > arr[i][svj]) {
					flag = false;
					break;
				}
			}
			
			if(flag == true) {
				System.out.println(arr[i][svj]);
				return;
			}
			
		}
		
		System.out.println("Invalid input");
	}
}
