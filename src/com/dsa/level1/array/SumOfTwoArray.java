package com.dsa.level1.array;

import java.util.Scanner;

public class SumOfTwoArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int arr1[] = new int[n1];
		for(int i=0 ; i < arr1.length ;i++) {
			arr1[i]= sc.nextInt();
		}
		
		for(int val : arr1)
			System.out.print(val + " ");
		System.out.println();
		int n2 = sc.nextInt();
		int arr2[] = new int[n2];
		for(int i=0 ; i < arr2.length ;i++) {
			arr2[i]=sc.nextInt();
		}
		for(int val : arr2)
			System.out.print(val + " ");
		System.out.println();
		int carry =0;
		int sum[] = new int[n1 > n2 ? n1 : n2];
		int i = arr1.length - 1;
		int j = arr2.length -1;
		int k = sum.length -1;
		
		while(k >= 0) {
			int d = carry;
			if(i >= 0) {
				d += arr1[i];
			}
			if(j >= 0) {
				d += arr2[j];
			}
			carry = d / 10;
			d = d % 10;
			sum[k] = d;
			i--;
			j--;
			k--;
		}
		if(carry != 0) {
			System.out.print(carry + " ");
		}
		
		for(int val : sum) {
			System.out.print(val + " ");
		}
	}
}
