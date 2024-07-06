package com.dsa.level1.dianimic.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

import com.dsa.level1.dianimic.programming.IsGraphCycleDP.Edge;

public class SpreadInfectionGraphDP {
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
		int time;
		Pair(int v , int time){
			this.v = v;
			this.time = time;
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
		int t = Integer.parseInt(br.readLine());
		
		ArrayDeque<Pair> queue = new ArrayDeque<SpreadInfectionGraphDP.Pair>();
		queue.add(new Pair(src,1));
		
		int[] visited = new int[vtces];
		int count =0 ;
		
		while(queue.size() > 0) {
			Pair remp = queue.removeFirst();
			
			if(visited[remp.v] >0) {
				continue;
			}else {
				visited[remp.v] = remp.time;
				if(remp.time > t) {
					break;
				}
				count++;
				
				for(Edge e : graph[remp.v]) {
					if(visited[e.nbr] ==0) {
						queue.add(new Pair(e.nbr , remp.time +1));
					}
				}
			}
			System.out.println(count);
		}
		
		
	}
	
	
}
