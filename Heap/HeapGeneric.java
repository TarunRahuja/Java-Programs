package Heap;

import java.util.ArrayList;

public class HeapGeneric<T extends Comparable<T>> {
	private ArrayList<T> data = new ArrayList<>();

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void add(T item) {
		data.add(item);
		upheapify(size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if (data.get(ci).compareTo(data.get(pi)) > 0) {
			swap(ci, pi);
			upheapify(pi);
		}

	}

	private void swap(int ci, int pi) {
		T cival = data.get(ci);
		T pival = data.get(pi);
		data.set(ci, pival);
		data.set(pi, cival);
	}

	public void display() {
		System.out.println(data);
	}

	public T remove() {
		swap(0, size() - 1);
		T delval = data.remove(size() - 1);
		downheapify(0);
		return delval;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < data.size() && data.get(lci).compareTo(data.get(mini)) > 0) {
			mini = lci;
		}
		if (rci < data.size() && data.get(rci).compareTo(data.get(mini)) > 0) {
			mini = rci;
		}
		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	public T get() {
		return data.get(0);
	}
}
