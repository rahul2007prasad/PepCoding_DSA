package com.dsa.level1.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		HashMap<Character , Integer> hm = new HashMap<Character , Integer>();
		for(int i = 0 ; i < str.length() ; i++) {
			char ch = str.charAt(i);
			if(hm.containsKey(ch)) {
				int of = hm.get(ch);
				int nf = of + 1;
				hm.put(ch, nf);
			}else {
				hm.put(ch, 1);
			}
		}
		
		char mfc = str.charAt(0);
		for(Character key : hm.keySet() ) {
			if(hm.get(key) > hm.get(mfc)) {
				mfc = key;
			}
		}
		
		System.out.println(mfc);
		
		
	}
}
