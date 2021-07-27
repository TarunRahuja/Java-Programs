package practice;
import java.util.*;
public class MaximumSubtree {
	static class HeapMover implements Comparable<HeapMover>{
		int size;
		public HeapMover(int size) {
			this.size = size;
		}
		@Override
		public String toString() {
			return size + "";
		}
		@Override
		public int compareTo(HeapMover o) {
			return o.size - this.size;
		}
	}
	public static void main(String[] args) {
		int a = 5;
		int[] b = new int[] {1,3,3,5};
		int[] c = new int[] {3,2,4,1};
		int[] d = new int[] {1,3};
		
		ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
		for(int i=0; i<=a; i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0; i<a-1; i++) {
			adj.get(b[i]).add(c[i]);
			adj.get(c[i]).add(b[i]);
		}
		
		HashMap<Integer,HeapMover> map = new HashMap<>();
		getSize(adj, 1, map, new HashSet<>());
		System.out.println(map);
		PriorityQueue<HeapMover> pq = new PriorityQueue<>();
		
		for(int k : map.keySet()) {
			pq.offer(map.get(k));
		}
		int[] ans = new int[d.length];
		for(int i=0; i<d.length; i++) {
			int query = d[i];
			int src = b[query-1];
			int dest = c[query-1];
			if(map.get(src).size >= map.get(dest).size) {
				map.get(src).size -= map.get(dest).size;
			}
			else {
				map.get(dest).size -= map.get(src).size;
			}
			System.out.println(map);
			System.out.println(pq);
			ans[i] = pq.peek().size;
		}
		for(int res : ans) {
			System.out.println(res);
		}
	}
	public static int getSize(ArrayList<ArrayList<Integer>>adj, int curr, HashMap<Integer,HeapMover> map, HashSet<Integer> visited) {
		if(visited.contains(curr)) {
			return 0;
		}
		visited.add(curr);
		int size = 0;
		for(int nbr : adj.get(curr)) {
			size += getSize(adj, nbr, map, visited);
		}
		size += 1;
		map.put(curr,new HeapMover(size));
		return size;
	}
}