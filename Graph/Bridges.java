package Graph;
import java.util.*;
public class Bridges{
	static class Edge{
		int src;
		int dest;
		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
		@Override
		public String toString() {
			return this.src+"-->"+this.dest;
		}
	}
	static HashSet<Edge> bridges = new HashSet<Edge>();
	static int time = 1;
	public static void main(String[] args){
		int [][]adj = {{0,1,1,1,0},{1,0,1,0,0},{1,1,0,0,0},{1,0,0,0,1},{0,0,0,1,0}};
		int []parent = new int[5];
		int []disc = new int[5];
		int []low = new int[5];
		boolean []visited = new boolean[5];
		//parent[0] = -1;
		for(int i=0; i<adj.length; i++) {
			parent[i] = -1;
		}
		for(int i=0; i<adj.length; i++) {
			if(!visited[i]) {
				dfs(adj,i,parent,disc,low,visited);
			}
		}
		System.out.println(bridges);
		
	}
	public static void dfs(int [][]adj, int curr, int []parent, int []disc, int []low, boolean []visited){
		visited[curr] = true;
		disc[curr] = time;
		low[curr] = time++;
		for(int nbr=0; nbr<adj.length; nbr++) {
			if(parent[curr]==nbr) {
				continue;
			}
			if(adj[curr][nbr]!=0) {
				if(!visited[nbr]) {
					parent[nbr] = curr;
					dfs(adj,nbr,parent,disc,low,visited);
					low[curr] = Math.min(low[curr], low[nbr]);
					if(disc[curr]<low[nbr]) {
						bridges.add(new Edge(curr,nbr));
					}
				}
				else {
					low[curr] = Math.min(low[curr], disc[nbr]);
				}
			}
		}
	}

}
