package com.dsa.level1.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int [] arr = new int[n];
		for(int i =0 ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
		}
		
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		
		for(int val : arr) {
			map.put(val, true);
		}
		
		for(int val : arr) {
			if(map.containsKey(val -1)) {
				map.put(val, false);
			}
		}
		
		
		int msp = 0;
		int m1 = 0;
		for(int val : arr) {
			if(map.get(val) == true) {
				int t1 = 1;
				int tsp = val;
				
				while(map.containsKey(tsp + t1)) {
					t1++;
				}
				if(t1 > m1) {
					msp = tsp;
					m1 = t1;
				}
			}
		}
		
		for(int ti = 0; ti < m1 ; ti++ ) {
			System.out.println(msp + ti);
		}
		
	}
}
