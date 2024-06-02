package com.dsa.level1.array.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubSequenceRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str  = sc.next();
		
		ArrayList<String> gss = gss(str);
		System.out.println(gss);
		
	}
	
	//bc -> [--,-c,b-,bc]
	//abc -> [---,--c ,-bc-,-bc,a--,a-c,ab-,abc]
	
	public static ArrayList<String> gss(String str){
		if(str.length() ==0 ) {
			ArrayList<String> bres = new ArrayList<String>();
			bres.add("-");
			return bres;
		}
		
		char ch = str.charAt(0);//a
		
		String ros = str.substring(1); //bc
		ArrayList<String> rres = gss(ros); //[--,-c,b-,bc]
		
		ArrayList<String> mres = new ArrayList<String>();
		for(String rstr : rres) {
			mres.add("" + rstr);
			mres.add(ch + rstr);
		}
		return mres;
		
		
	}
}
