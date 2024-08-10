package com.dsa.level1.array2;

import java.util.Stack;

public class ReverseArray {
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		reverse(a);
		System.out.println("");
		reverseUsingLoopInPlace(a);
		System.out.println("");
		System.out.println("stck----");
		reverseUsingStack(a);
		
	}
	
	
	//TC : O(n)
	//SC : O(n)
	public static void reverse(int a[]) {
		int arr[] = new int[a.length];
		
		for(int i=0; i < a.length ; i++)
			arr[i] = a[a.length -i -1];
		System.out.println("Reveerse array");
		
		for(int i=0 ;i < arr.length ;i++)
			System.out.print(arr[i]);
	}
	
	//TC O(n)
	//SC O(1)
	public static void reverseUsingLoopInPlace(int []a) {
		int start=0;
		int end = a.length-1;
		int temp=0;
		
		while(start < end) {
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
		
		System.out.println("------loop---");
		for(int i=0 ;i <a.length ;i++) {
			System.out.print(a[i]);
		}
	}
	
	public static void reverseUsingStack(int[] ar) {
		Stack<Integer> stack = new Stack<Integer>();
		
//		for(int i=0 ;i < ar.length ; i++) {
//			stack.push(ar[i]);
//		}
		for(int e : ar)
			stack.push(e);
//		for(int i=0 ;i < stack.size() ; i++)
//			System.out.print(stack.size() + " " +stack.pop());
//		
		for(int i =0 ; i < ar.length ; i++) {
			ar[i] = stack.pop();
		}
		
		
		System.out.println("reverse using stack");
		for(int i=0 ;i < ar.length ;i++) {
			System.out.print(ar[i]);
		}
	}
}
