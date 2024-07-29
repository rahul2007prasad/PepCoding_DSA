package com.dsa.level1.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {
	public static class HashMap<K,V>{
		private class HMNode{
			K key;
			V value;
			
			HMNode(K key , V value){
				this.key = key;
				this.value = value;
			}
		}
		
		private int size;
		
		private LinkedList<HMNode> [] buckets; // N = buckets.length
		
		public HashMap() {
			initbuckets(4);
			size = 0;
		}
		
		private void initbuckets(int N) {
			buckets = new LinkedList[N];
			for(int bi = 0 ; bi < buckets.length ; bi++) {
				buckets[bi] = new LinkedList<>();
			}
		}
		
		
		public void put(K key , V value) throws Exception{
			int bi = hashfn(key);
			int di = getIndexWithInBucket(key,bi);
			
			if(di != -1) {
				HMNode node = buckets[bi].get(di);
				node.value = value;
			}else {
				HMNode node = new HMNode(key , value);
				buckets[bi].add(node);
				size++;
			}
			double lambda = size * 1.0 / buckets.length;
			if(lambda > 2.0) {
				rehash();
			}
		}
		
		private void rehash() throws Exception {
			LinkedList<HMNode> [] oba = buckets;
			initbuckets(oba.length * 2);
			size =0;
			
			for(int i = 0; i< oba.length ; i++) {
				for(HMNode node : oba[i]) {
					put(node.key , node.value);
				}
			}
		}
		
		private int hashfn(K key) {
			int hc = key.hashCode();
			return Math.abs(hc) % buckets.length;
		}
		
		private int getIndexWithInBucket(K key , int bi) {
			int di = 0;
			for(HMNode node : buckets[bi]) {
				if(node.key.equals(key)) {
					return di;
				}
				di++;
			}
			return -1;
		}
		
		public V get(K key) throws Exception{
			int bi = hashfn(key);
			int di = getIndexWithInBucket(key,bi);
	
			if(di != -1) {
				HMNode node = buckets[bi].get(di);
				return node.value;
				
			}else {
				return null;
			}
			
		}
		
		public boolean containsKey(K key) {
			int bi = hashfn(key);
			int di = getIndexWithInBucket(key,bi);
	
			if(di != -1) {
				return true;
			}else {
				return false;
			}
			
			
		}
		
		public V remove(K key) throws Exception{
			int bi = hashfn(key);
			int di = getIndexWithInBucket(key,bi);
	

			if(di != -1) {
				HMNode node = buckets[bi].remove(di);
				size--;
				return node.value;
				
			}else {
				return null;
			}
			
		}
		
		public ArrayList<K> keySet() throws Exception{
			ArrayList<K> keys = new ArrayList<>();
			for(int i = 0; i < buckets.length ; i++) {
				for(HMNode node : buckets[i]) {
					keys.add(node.key);
				}
			}
			return keys;
		}
		
		public int size() {
			return size;
		}
		
		public void display() {
			System.out.println("Display begins");
			for(int bi = 0; bi < buckets.length ; bi++) {
				System.out.println("Bucket " + bi + " ");
				for(HMNode node : buckets[bi]) {
					System.out.println(node.key + " @ " + node.value +"");
				}
			}
		}
		
		public static void main(String[] args) throws Exception {
			
			HashMap<Integer , String> hm = new HashMap<>();
			hm.put(1, "hello");
			hm.display();
			System.out.println("First Index "+hm.get(1));
			System.out.println("Contains " + hm.containsKey(1));
			hm.remove(1);
			hm.put(2, "r");
			hm.put(3, "a");
			hm.put(4, "h");
			hm.put(5, "u");
			hm.put(6, "l");
			
			hm.display();
			
		}
	}
}
