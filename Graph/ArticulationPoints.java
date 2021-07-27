package Graph;
import java.util.*;
public class ArticulationPoints {
	static int time = 1;
	static HashSet<Integer>list = new HashSet<Integer>();
	public static void main(String[] args) {
		int [][]adj = {{0,1,1,1,0},{1,0,1,0,0},{1,1,0,0,0},{1,0,0,0,1},{0,0,0,1,0}};
		int []parent = new int[5];
		int []disc = new int[5];
		int []low = new int[5];
		boolean []visited = new boolean[5];
		for(int i=0; i<5; i++) {
			parent[i] = -1;
		}
		for(int i=0; i<5; i++) {
			if(!visited[i]) {
				dfs(adj,0,parent,disc,low,visited);
			}
		}
		System.out.println(list);
	}
	public static void dfs(int [][]adj,int curr,int []parent,int []disc,int []low,boolean []visited){
		visited[curr] = true;
		disc[curr] = time;
		low[curr] = time++;
		int count = 0;
		for(int i=0; i<adj.length; i++){
			if(i==parent[curr]){
				continue;
			}
			if(adj[curr][i]!=0){
				 if(!visited[i]){
					 parent[i] = curr;
					 count++;
					 dfs(adj,i,parent,disc,low,visited);
					 low[curr] = Math.min(low[i],low[curr]);
					 if(parent[curr]==-1&&count>1){
						 list.add(curr);
					 }
					 else if(parent[curr]!=-1&&low[i]>=disc[curr]) {
						 list.add(curr);
					 }
				 }
				 else{
					 low[curr] = Math.min(low[curr],disc[i]);
				 }
			 }
		 }
	}
}
