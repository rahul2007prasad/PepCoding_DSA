package com.dsa.level1.array2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class UnionAndIntersactionOfArray {
	public static void main(String[] args) {
		int arr1[] = {1,2,2,2,3};
		int arr2[] = {2,3,3,4,5,5};
		ArrayList<Integer> setOfArray = setOfArray(arr1, arr2);
		
		System.out.println("Union");
		for(int e : setOfArray)
			System.out.print(" " + e);
	}
	
	//TC : O(mlogm + nlogn)
	public static ArrayList<Integer>  setOfArray(int [] arr1 , int [] arr2) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int e : arr1)
			ts.add(e);
		
		for(int e: arr2)
			ts.add(e);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : ts)
			list.add(i);
		
		return list;
	}
	
	public static ArrayList<Integer> unionUsingMap(int []arr1 , int arr2[]){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0 ;  i< arr1.length ; i++) {
			if(map.containsKey(arr1[i]))
				map.put(arr1[i], map.get(arr2[i]) +1);
			
			else
				map.put(arr1[i], 1);
		}
		return null;
	}
	
}
