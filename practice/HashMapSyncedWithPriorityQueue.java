package practice;
import java.util.*;
public class HashMapSyncedWithPriorityQueue {
	static class HeapMover{
		int val;
		public HeapMover(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		HashMap<Integer,HeapMover> map = new HashMap<>();
		map.put(1,new HeapMover(5));
		map.put(3,new HeapMover(3));
		
		PriorityQueue<HeapMover> pq = new PriorityQueue<>(new Comparator<HeapMover>() {
			@Override
			public int compare(HeapMover t, HeapMover o) {
				return o.val - t.val;
			}
		});
		
		for(int k : map.keySet()) {
			pq.offer(map.get(k));
		}
		
		System.out.println(pq.peek().val);
		HeapMover temp = map.get(1);
		temp.val = 2;
		System.out.println(pq.peek().val);
	}
}