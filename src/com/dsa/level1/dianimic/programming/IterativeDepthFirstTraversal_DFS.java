package com.dsa.level1.dianimic.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

import com.dsa.level1.dianimic.programming.Dijkstra_shortes_pathInWeight.Edge;
import com.dsa.level1.dianimic.programming.Dijkstra_shortes_pathInWeight.Pair;

public class IterativeDepthFirstTraversal_DFS {

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
	public static class Pair {
		int v;
		String psf;
		
		Pair(int v , String psf ){
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
			int wt = Integer.parseInt(parts[2]);
			
			graph[v1].add(new Edge(v1 , v2 ,wt));
			graph[v2].add(new Edge(v2,v1,wt));
			
			
		}
		
		int src = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[vtces];
		
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(src , src +""));
		
		while(st.size() > 0) {
			Pair rem = st.pop();
			
			if(visited[rem.v] == true) {
				continue;
			}
			visited[rem.v] = true;
			
			System.out.println(rem.v + "@" + rem.psf);
			
			for(Edge e : graph[rem.v]) {
				if(visited[e.nbr] == false) {
					st.push(new Pair(e.nbr , rem.psf + e.nbr));
				}
			}
			
		}
		
	}
	
}
