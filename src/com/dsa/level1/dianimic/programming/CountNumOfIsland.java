package com.dsa.level1.dianimic.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountNumOfIsland {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[m][n];
		
		for(int i= 0; i < arr.length ;i++) {
			String parts = br.readLine();
			for(int j= 0 ; j < arr[0].length ; j++) {
				arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
			}
		}
		
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int count =0;
		
		for(int i =0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length ; j++) {
				if(arr[i][j] ==0 && visited[i][j] == false) {
					drawTreeForComponenet(arr,i,j,visited);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static void drawTreeForComponenet(int[][] arr , int i , int j, boolean[][] visited) {
		if(i < 0 || j <0 || i >= arr.length || j>= arr[0].length || arr[i][j] == 1 || visited[i][j] == true) {
			return;
		}
		
		visited[i][j] = true;
		
		drawTreeForComponenet(arr, i - 1, j, visited);
		drawTreeForComponenet(arr, i, j + 1, visited);
		drawTreeForComponenet(arr, i, j - 1, visited);
		drawTreeForComponenet(arr, i + 1, j, visited);
	
		
		/*
		 00111111
		 00111111
		 11111110
		 11000110
		 11110110
		 11110110
		 11111110
		 11111110
		 */
	}
	
}
