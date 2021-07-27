package Graph;
import java.util.*;
public class StronglyConnectedComponenets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
		ArrayList<ArrayList<Integer>>trans = new ArrayList<>();
		for(int i=0; i<=n; i++){
			adj.add(new ArrayList<>());
			trans.add(new ArrayList<>());
		}
		int m = sc.nextInt();
		for(int i=0; i<m; i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adj.get(src).add(dest);
			trans.get(dest).add(src);
		}
		boolean []visited = new boolean[n+1];
		boolean []visitedTrans = new boolean[n+1];
		Stack<Integer>st = new Stack<Integer>();
		for(int i=1; i<=n; i++) {
			if(visited[i])continue;
			dfs(adj,i,visited,st);
		}
		ArrayList<ArrayList<Integer>>list = new ArrayList<>();
		ArrayList<Integer>comp = new ArrayList<Integer>();
		while(!st.isEmpty()) {
			int curr = st.pop();
			if(visitedTrans[curr]) continue;
			comp = new ArrayList<Integer>();
			getConnectedComponents(trans,visitedTrans,curr,comp);
			list.add(comp);
		}
		System.out.println(list);
	}
	public static void getConnectedComponents(ArrayList<ArrayList<Integer>> trans, boolean[] visitedTrans, int curr,ArrayList<Integer>comp){
		if(visitedTrans[curr])return;
		visitedTrans[curr] = true;
		comp.add(curr);
		for(int val:trans.get(curr)) {
			getConnectedComponents(trans, visitedTrans, val, comp);
		}
	}
	public static void dfs(ArrayList<ArrayList<Integer>>adj,int curr, boolean []visited,Stack<Integer>st) {
		if(visited[curr])return;
		visited[curr] = true;
		for(int val:adj.get(curr)) {
			dfs(adj,val,visited,st);
		}
		st.push(curr);
	}	
}
//Input
//10
//12
//1 2
//2 3
//3 4
//4 1
//3 5
//5 6
//6 7
//7 5
//8 7
//8 9
//9 8
//9 10
