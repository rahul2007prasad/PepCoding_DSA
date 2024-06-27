package com.dsa.level1.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

import com.dsa.level1.graph.PrintAllPaths.Edge;
import com.dsa.level1.hashmap.MergedKSortedList.Pair;

public class SmallestLongestCeilFloorKthLargetPath {
	

	static class Edge{
		int src;
		int nbr;
		int wt;
		
		Edge(int src , int nbr , int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	static class Pair implements Comparable<Pair>{
		int wsf ;
		String psf;
		Pair(int wsf , String psf){
			this.wsf = wsf ;
			this.psf = psf;
		}
		
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int vtecs = Integer.parseInt(br.readLine());
		ArrayList<Edge> [] graph = new ArrayList[vtecs];
		
		for(int i = 0 ; i < vtecs ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int edges = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < edges ; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			
			graph[v1].add(new Edge(v1 , v2 , wt));
			
			graph[v2].add(new Edge(v2, v1 , wt));
		}
		
		int src = Integer.parseInt(br.readLine());
		int dest = Integer.parseInt(br.readLine());
		
		
		int criteria = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[vtecs];
		multiSolver(graph , src , dest , visited,criteria,k,src +"",0);
	
		
		System.out.println("Smallest path " + spath + "@" + spathwt);
		System.out.println("Largest path " + lpath + "@" + lpathwt);
		System.out.println("Just largest path than " +criteria +cpath + "@" + cpathwt);
		System.out.println("Just Smaller path than" + criteria  + fpath + "@" + fpathwt);
		System.out.println(k + " th largest path " + pq.peek().psf + "@" + pq.peek().wsf);
	
	}
	static String spath;
	static Integer spathwt = Integer.MAX_VALUE;
	static String lpath;
	static Integer lpathwt = Integer.MIN_VALUE;
	static String cpath;
	static Integer cpathwt = Integer.MAX_VALUE;
	static String fpath;
	static Integer fpathwt = Integer.MIN_VALUE;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	
	public static void multiSolver(ArrayList<Edge> [] graph , int src , int dest ,boolean visited[] , int criteria , int k ,String psf , int wsf) {
		if(src == dest) {
			if(wsf < spathwt) {
				spathwt = wsf;
				spath = psf;
			}
			if(wsf > lpathwt) {
				lpathwt = wsf;
				lpath = psf;
			}
			
			if(wsf > criteria && wsf < cpathwt) {
				cpathwt = wsf;
				cpath = psf;
			}
			
			if(wsf < criteria && wsf > fpathwt) {
				fpathwt = wsf;
				fpath = psf; 
			}
			
			if(pq.size() < k) {
				pq.add(new Pair(wsf , psf));
			}else {
				if(wsf > pq.peek().wsf) {
					pq.remove();
					pq.add(new Pair(wsf , psf));
				}
			}
			
		}
		return;
	}
}
