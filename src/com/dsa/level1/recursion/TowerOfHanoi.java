package com.dsa.level1.recursion;

import java.util.Scanner;

public class TowerOfHanoi {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t1d = sc.nextInt();
		int t2d = sc.nextInt();
		int t3d = sc.nextInt();
		
		toh(n, t1d, t2d, t3d);
		
		
	}
	public static void toh(int n , int t1id , int t2id , int t3id) {
		if(n == 0) {
			return;
		}
		
		toh(n -1  , t1id , t3id , t2id); //will print the instrictions to kove n -1 disks from t1 to  t3 using t2
		System.out.println(n +"[ "  + t1id + " --> " + t2id +" ]");
		
		toh(n -1  , t3id , t2id , t1id);
		
		
	}
}
