package practice;
import java.util.*;
public class Coronavirus {
	static class Pair{
		int v;
		int dist;
		public Pair(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		int x = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			adj.add(new ArrayList<>());
		}
		int[] hotspots = new int[h];
		for(int i=0; i<h; i++) {
			hotspots[i] = sc.nextInt();
		}
		for(int i=0; i<n-1; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}
		int count = 0;
		for(int i=1; i<=n; i++) {
			if(isValidEpicentre(adj, i, hotspots, x)) {
				count++;
			}
		}
		System.out.println(count);
	}
	public static boolean isValidEpicentre(ArrayList<ArrayList<Integer>>adj, int start, int[] hotspots, int x) {
		int n = adj.size()-1;
		boolean[] visited = new boolean[n+1];
		int[] path = new int[n+1];
		Arrays.fill(path, 999999);
		path[start] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair t, Pair o) {
				return t.dist - o.dist;
			}
		});
		pq.offer(new Pair(start,0));
		while(!pq.isEmpty()) {
			Pair rp = pq.poll();
			int v = rp.v;
			int dist = rp.dist;
			if(visited[v]) {
				continue;
			}
			visited[v] = true;
			for(int nbr : adj.get(v)) {
				if(path[nbr] > path[v] + 1) {
					path[nbr] = path[v] + 1;
					pq.offer(new Pair(nbr,path[nbr]));
				}
			}
		}
		for(int hotspot : hotspots) {
			if(path[hotspot] > x) {
				return false;
			}
		}
		return true;
	}
}