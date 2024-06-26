package com.dsa.level1.array.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<String> paths = getMazePaths(1, 1, n, m);

		System.out.println(paths);
	}

	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		if (sr == dr && sc == dc) {
			ArrayList<String> bres = new ArrayList<String>();
			bres.add("");
			return bres;
		}
		ArrayList<String> hpaths = new ArrayList<String>();
		ArrayList<String> vpaths = new ArrayList<String>();
		if (sc < dc) {
			hpaths = getMazePaths(sr, sc + 1, dr, dc);
		}

		if (sr < dr) {
			vpaths = getMazePaths(sr + 1, sc, dr, dc);
		}
		ArrayList<String> paths = new ArrayList<String>();

		for (String hpath : hpaths) {
			paths.add("h" + hpath);
		}

		for (String vpath : vpaths) {
			paths.add("v" + vpath);
		}

		return paths;

	}
}
