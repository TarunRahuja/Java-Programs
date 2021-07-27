package collectionsPractice;
import java.util.*;
public class MapPrac {
	static class Book implements Comparable<Book>{
		String title;
		int price;
		public Book(String title,int price) {
			this.title = title;
			this.price = price;
		}
		
		@Override
		public String toString() {
			return this.title+" "+this.price;
		}

		@Override
		public int compareTo(Book o) {
			if(this.price>o.price) {
				return +1;
			}
			else {
				return -1;
			}
		}
	}
	public static void main(String[] args) {
		
//		ArrayList<Integer> l1 = new ArrayList<Integer>();
//		l1.add(1);
//		l1.add(2);
//		l1.add(2);
//		l1.add(1);
//		LinkedHashSet set = new LinkedHashSet<>(l1);
//		System.out.println(set);
		ArrayList<Book> l1 = new ArrayList<Book>();
		l1.add(new Book("abc", 10));
		l1.add(new Book("def", 20));
		l1.add(new Book("ghi", 30));
		Collections.sort(l1);
		System.out.println(l1);
	}

}
