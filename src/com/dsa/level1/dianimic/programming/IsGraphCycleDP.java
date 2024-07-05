package com.dsa.level1.dianimic.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class IsGraphCycleDP {
	static class Edge{
		int src;
		int nbr;
		
		
		Edge(int src , int nbr){
			this.src = src;
			this.nbr = nbr;
			
		}
	}
	
	static class Pair{
		int v;
		String psf;
		Pair(int v , String psf){
			this.v = v;
			this.psf = psf;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge> [] graph = new ArrayList[vtces];
		
		for(int i = 0 ; i < vtces ; i++) {
			graph[i] = new ArrayList<>();
			
		}
		
		int edges = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < edges ; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
					
			graph[v1].add(new Edge(v1 , v2));
			graph[v2].add(new Edge(v2,v1));
			
			
		}
		
		
		boolean[] visited = new boolean[vtces];
		for(int v =0 ; v < vtces ; v++) {
			if(visited[v] == false) {
				boolean cycle = isCyclic(graph, v, visited);
				if(cycle) {
					System.out.println(true);
					return;
				}
			}
		}
		System.out.println(true);
		
		
	}
	
	public static boolean isCyclic(ArrayList<Edge>[] graph , int src , boolean[] visited) {
		ArrayDeque<Pair>  queue = new ArrayDeque<>();
		queue.add(new Pair(src , src +""));
		
		while(queue.size() > 0) {
			Pair rem = queue.removeFirst();
			
			if(visited[rem.v] == true) {
				return true;
			}
			visited[rem.v] = true;
			
			for(Edge e : graph[rem.v]) {
				if(visited[e.nbr] == false) {
					queue.add(new Pair(e.nbr , rem.psf + e.nbr));
				}
			}
		}
		return false;
		
	}
}
