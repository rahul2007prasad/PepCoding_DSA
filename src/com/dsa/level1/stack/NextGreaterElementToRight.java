package com.dsa.level1.stack;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToRight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i =0 ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] solve = solve(arr);
		
		System.out.println("next greater element");
		for(int nxt : solve) {
			System.out.print(nxt + " ");
		}
		
		System.out.println();
		int[] solveAlernative = solveAlernative(arr);
	
		for(int nxt : solveAlernative) {
			System.out.print(nxt + " ");
		}
	}
	
	
	public static int[] solve(int[] arr) {
		int[] nge = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr[arr.length -1]);
		nge[arr.length - 1] = -1;
		for(int i = arr.length -2 ; i >= 0 ; i--) {
			//-a+
			
			while(st.size() > 0 && arr[i] >= st.peek()) {
				st.pop();
			}
			if(st.size() == 0) {
				nge[i] = -1;
			}else {
				nge[i] = st.peek();
			}
			
			st.push(arr[i]);
		}
		
		return nge;
		
		
		
	}
	
	//alernative approach
	public static int[] solveAlernative(int[] arr) {
		int[] nge = new int[arr.length ];
		Stack<Integer> st = new Stack<>();
		
		st.push(0);
		
		for(int i= 1 ; i < arr.length ; i++) {
			while(st.size() >0 && arr[i] > arr[st.peek()]) {
				int pos = st.peek();
				nge[pos] = arr[i];
				st.pop();
			}
			st.push(i);
		}
		while(st.size() > 0) {
			int pos = st.peek();
			nge[pos] = -1;
			st.pop();
		}
		return nge;
	}
	
		
}
