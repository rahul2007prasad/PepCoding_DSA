package com.dsa.level1.array2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesArray {
	public static void main(String[] args) {
		long a[] = {1,6,5,2,3,3,2};
		List<Integer> duplicates = duplicates(a);
		
		System.out.println("Duplicates :");
		for(int e  : duplicates)
			System.out.print(e + " ");
		System.out.println();
	}
	
	
	// TC O(N)
	public static List<Integer> duplicates(long arr[]) {
		Map<Long, Integer> frequenecyMap = new HashMap<Long, Integer>();
		List<Integer> result = new ArrayList<Integer>();
		
		for(long num : arr) {
			frequenecyMap.put(num, frequenecyMap.getOrDefault(num ,0) +1);
		}
		
		for(Map.Entry<Long, Integer> entry :
			frequenecyMap.entrySet()
				) {
			if(entry.getValue() > 1)
				result.add(Math.toIntExact(entry.getKey()));
			
		}
		
		if(result.isEmpty())
			result.add(-1);
		
		Collections.sort(result);
		
		return result;
	}
}
