package Graph;
import java.util.*;
public class TopologicalSorting {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adj.get(src).add(dest);
		}
		boolean []visited = new boolean[n+1];
		Stack<Integer>st = new Stack<Integer>();
		for(int i=1; i<=n; i++) {
			if(visited[i])continue;
			topologicalSort(adj, i, visited, st);
		}
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
	}
	public static void topologicalSort(ArrayList<ArrayList<Integer>>adj,int curr,boolean[] visited, Stack<Integer>st) {
		if(visited[curr])return;
		visited[curr] = true;
		for(int val:adj.get(curr)){
			topologicalSort(adj, val, visited, st);
		}
		st.push(curr);
	}
}
//Input
//8
//8
//1 3
//2 3
//2 4
//3 5
//5 8
//5 6
//4 6
//6 7