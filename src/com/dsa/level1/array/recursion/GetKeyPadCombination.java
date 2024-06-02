package com.dsa.level1.array.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKeyPadCombination {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str  = sc.next();
		
		ArrayList<String> words = getKPC(str);
		System.out.println(words);
		
	}
	
	static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	
	
	public static ArrayList<String> getKPC(String str){
		if(str.length() == 0) {
			ArrayList<String> bres = new ArrayList<String>();
			bres.add("");
			return bres;
		}
		
		char ch = str.charAt(0) ; //6
		String ros = str.substring(1); //78
		
		ArrayList<String> rres = getKPC(ros); // 6 words of 78
		ArrayList<String> mres = new ArrayList<String>();
		
		//'6' != 6 i.e char6 is not eqal to num6
				//so minus '0' from char to make number
		String codeforch = codes[ch - '0']; 
		for(int i = 0 ; i < codeforch.length() ; i++) {
			char chcode = codeforch.charAt(i);
			for(String rstr : rres) {
				mres.add(chcode + rstr);
			}
		}
		
				
		return mres;
	}
}
