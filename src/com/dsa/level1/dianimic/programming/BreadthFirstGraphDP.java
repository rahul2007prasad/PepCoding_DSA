package com.dsa.level1.dianimic.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

import com.dsa.level1.dianimic.programming.IsGraphConnected.Edge;

public class BreadthFirstGraphDP {
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
			this.v= v;
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

		
		int src = Integer.parseInt(br.readLine());
		
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(src,src +""));
		boolean[] visited = new boolean[vtces];
		
		while(queue.size() >0) {
			//r m* w a*
			
			Pair rem = queue.removeFirst();
			
			if(visited[rem.v] == true) {
				continue;
			}
			visited[rem.v] = true;
			
			System.out.println(rem.v + "@" + rem.psf);
			
			for(Edge e : graph[rem.v]) {
				if(visited[e.nbr] == false) {
					queue.add(new Pair(e.nbr , rem.psf + e.nbr));
				}
			}
			
		}
		
		
		
	}
	
}
