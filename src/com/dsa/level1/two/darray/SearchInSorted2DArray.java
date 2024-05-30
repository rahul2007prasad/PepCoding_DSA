package com.dsa.level1.two.darray;

import java.util.Scanner;

public class SearchInSorted2DArray {
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
		
		int x = sc.nextInt();
		int i =0;
		int j = arr[0].length -1;
		
		while(i < arr.length && j >= 0) {
			if(x == arr[i][j]) {
				System.out.println(i);
				System.out.println(j);
				return;
			}else if(x < arr[i][j]) {
				j--;
			}else {
				i++;
			}
		}
		
		System.out.println("Not found");
		
	}
}
