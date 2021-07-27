package Graph;
import java.util.*;

import Graph.DijkstraImproved.Pair;
public class PrimsImproved {
	static class Pair{
		int v;
		int wt;
		public Pair(int v, int wt) {
			this.v = v;
			this.wt = wt;
		}
	}
	public static void main(String[] args) {
		HashMap<Integer,HashMap<Integer,Integer>>map = new HashMap<>();
		for(int i = 0; i <= 8; i++) {
			map.put(i,new HashMap<>());
		}
		addEdge(map,0, 1, 4); 
	    addEdge(map,0, 7, 8); 
	    addEdge(map,1, 2, 8); 
	    addEdge(map,1, 7, 11); 
	    addEdge(map,2, 3, 7); 
	    addEdge(map,2, 8, 2); 
	    addEdge(map,2, 5, 4); 
	    addEdge(map,3, 4, 9); 
	    addEdge(map,3, 5, 14); 
	    addEdge(map,4, 5, 10); 
	    addEdge(map,5, 6, 2); 
	    addEdge(map,6, 7, 1); 
	    addEdge(map,6, 8, 6); 
	    addEdge(map,7, 8, 7); 
		PriorityQueue<Pair>pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair t, Pair o) {
				return t.wt - o.wt;
			}
		});
		int []path = new int[9];
		Arrays.fill(path, 999999);
		path[0] = 0;
		boolean[] status = new boolean[9];
		int []parent = new int[9];
		for(int i=0; i<path.length; i++) {
			pq.offer(new Pair(i,path[i]));
		}
		prims(map, path, status, parent, pq);
		int wt = 0;
		for(int i=1; i<9; i++) {
			wt += path[i];
			System.out.println(parent[i] + " --> "+ i + " Edge Weight - " + path[i]);
		}
		System.out.println("Weight of MST -> " + wt);
	}
	public static void prims(HashMap<Integer,HashMap<Integer,Integer>>map, int []path, boolean[]status, int []parent, PriorityQueue<Pair>pq) {
		while(!pq.isEmpty()) {
			Pair rp = pq.poll();
			if(status[rp.v]) {
				continue;
			}
			status[rp.v] = true;
			for(int nbr : map.get(rp.v).keySet()) {
				if(!status[nbr] && path[nbr] > map.get(rp.v).get(nbr)) {
					path[nbr] = map.get(rp.v).get(nbr);
					parent[nbr] = rp.v;
					pq.offer(new Pair(nbr,path[nbr]));
				}
			}
		}
	}
	public static void addEdge(HashMap<Integer,HashMap<Integer,Integer>>map,int src, int dest, int wt) {
		map.get(src).put(dest,wt);
		map.get(dest).put(src,wt);
	}
}
