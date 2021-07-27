package Heap;

import Generics.Car;
import java.util.*;

public class HeapGenericClient {

	public static void main(String[] args) {
		HeapGeneric<Car> hg = new HeapGeneric<>();
		Car[] arr = new Car[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Car(i + 1, 1000 * (i + 1), "Black");
			hg.add(arr[i]);
		}
		// hg.display();
		while (!hg.isEmpty()) {
			System.out.println(hg.remove());
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.get(0).add(1);
		list.get(0).add(8);
		list.get(0).add(10);
		list.get(0).add(12);
		list.get(1).add(5);
		list.get(1).add(15);
		list.get(1).add(20);
		list.get(2).add(7);
		list.get(2).add(13);
		list.get(2).add(25);
		list.get(3).add(2);
		list.get(3).add(9);
        System.out.println(mergeklist(list));
        int []klar = {12,10,5,6,20,4,3,40};
        klargest(klar, 3);
	}

	private static class Pair implements Comparable<Pair> {
		int data;
		int lno;
		int indx;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeklist(ArrayList<ArrayList<Integer>> lists) {
		ArrayList ans = new ArrayList<>();
		HeapGeneric<Pair> hg = new HeapGeneric<>();
		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.lno = i;
			np.indx = 0;
			hg.add(np);
		}
		while (!hg.isEmpty()) {
			Pair rp = hg.remove();
			ans.add(rp.data);
			rp.indx = rp.indx + 1;
			if (rp.indx < lists.get(rp.lno).size()) {
				rp.data = lists.get(rp.lno).get(rp.indx);
				hg.add(rp);
			}
		}
		return ans;
	}
	public static void klargest(int []arr,int k)
	{
		Heap heap = new Heap();
		for(int i = 0; i<k; i++)
		{
			heap.add(arr[i]);
		}
		for(int i = k; i<arr.length; i++)
		{
			if(arr[i]>heap.get())
			{
				heap.remove();
				heap.add(arr[i]);
			}
		}
		while(!heap.isEmpty())
		{
			System.out.println(heap.remove());
		}
	}

}
