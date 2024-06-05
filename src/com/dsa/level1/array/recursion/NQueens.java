package com.dsa.level1.array.recursion;

import java.util.Scanner;

public class NQueens {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int n = sc.nextInt();
		int[][] arr = new int [n][n];
//		for(int  i = 0 ; i < arr.length ; i ++) {
//			for(int j = 0 ; j < arr[0].length  ; j++) {
//				arr[i][j]  = sc.nextInt();
//			}
//		}
		
		printNQueens(arr, "", 0);
	}
	
	
	public static void printNQueens(int[][] chess , String qsf , int row) {
		if(row == chess.length) {
			System.out.println(qsf);
			return;
		}
		for(int col = 0; col < chess.length ; col++) {
			if(isItSafePlaceForTheQueen(chess , row , col) == true) {
				chess[row][col] = 1;
				printNQueens(chess, qsf + row +"-" + col + ", " ,row + 1);
				
				chess[row][col] = 0 ; 
			}
		}
	}
	public static boolean isItSafePlaceForTheQueen(int[][] chess , int row , int col) {
		for(int i = row -1 , j =col ; i>= 0 ; i-- )  { //vertical
			if(chess[i][j] == 1) {
				return false;
			}
		}
		
		for(int i = row - 1 , j = col -1 ; i >= 0 && j >= 0 ; i-- , j--) {
			if(chess[i][j] == 1) {
				return false;
			}
			
		}
		
		for(int i = row - 1 , j = col  + 1 ; i >= 0 && j < chess.length ; i-- , j++) {
			if(chess[i][j] == 1) {
				return false;
			}
			
		}
		return true;
	}
}
