package com.dsa.level1.two.darray;

import java.util.Scanner;

public class WaveTraversal {

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
		
		for(int j =0 ; j < arr[0].length ; j++) {
			if(j % 2 == 0) {
				for(int i =0 ; i< arr.length ; i++) {
					System.out.println(arr[i][j]);
				}
			}else {
				for(int i= arr.length -1; i >= 0 ; i--) {
					System.out.println(arr[i][j]);
				}
			}
		}
		
	}
}
