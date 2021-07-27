package collectionsPractice;
import java.util.*;
public class ListPractice {
	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		LinkedList list = new LinkedList<>(l1);
		Stack<Integer> st = new Stack<>();
		st.add(10);
		st.add(20);
		System.out.println(st.isEmpty());
		System.out.println(list);
		l2.add(4);
		l2.add(3);
		l1.addAll(l2);
		Collections.sort(l1);
		//l1.removeAll(l2);
		l1.retainAll(l2);
		Iterator it = l1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//System.out.println(l1);
	}

}
