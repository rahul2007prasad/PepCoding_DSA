package com.dsa.level1.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergedKSortedList {
	public static class Pair implements Comparable<Pair>{
		int li; //list index
		int di; //data index
		int val;
		
		Pair(int li , int di , int val){
			this.li = li; 
			this.di = di;
			this.val = val;
		}

		@Override
		public int compareTo(Pair o) {
			
			return this.val - o.val;
		}
	}
	
	public static ArrayList<Integer> mergeSortedLists(ArrayList<ArrayList<Integer>> lists){
		
		ArrayList<Integer> rv = new ArrayList<Integer>();
		
		PriorityQueue<Pair> pq = new PriorityQueue<MergedKSortedList.Pair>();
		for(int i =0 ; i < lists.size() ; i++) {
			Pair p = new Pair(i , 0 , lists.get(i).get(0));
			pq.add(p);
		}
		
		while(pq.size() > 0) {
			Pair p = pq.remove();
			rv.add(p.val);
			p.di++;
			
			if(p.di < lists.get(p.li).size()) {
				p.val = lists.get(p.li).get(p.di);
				pq.add(p);
			}
		}
		return rv;
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(10);
		al1.add(20);
		al1.add(30);
		al1.add(40);
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(5);
		al2.add(9);
		al2.add(12);
		al2.add(18);
		al2.add(32);
		
		
		ArrayList<Integer> al3 = new ArrayList<Integer>();
		al3.add(11);
		al3.add(15);
		al3.add(17);
		
		
		ArrayList<ArrayList<Integer>> asList = new ArrayList<ArrayList<Integer>>();
		asList.add(al1);
		asList.add(al2);
		asList.add(al3);
		
		
		ArrayList<Integer> mergeSortedLists = mergeSortedLists(asList);
		
		System.out.println(mergeSortedLists);
	}
	
	
}
