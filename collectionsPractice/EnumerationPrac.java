package collectionsPractice;
import java.util.*;
public class EnumerationPrac {
	public static void main(String[] args) {
//		Vector v = new Vector();
//		v.addElement("One");
//		v.addElement("two");
//		v.addElement("three");
//		Enumeration e = v.elements();
//		while(e.hasMoreElements()) {
//			String s = (String)e.nextElement();
//			System.out.print(s+" ");
//		}
	LinkedList l = new LinkedList<>();
	l.add(1);
	l.add(2);
	l.add(3);
	ListIterator lit = l.listIterator();
	System.out.println(l);
	while(lit.hasNext()) {
		Integer i = (Integer)lit.next();
		if(i.equals(2)) {
			lit.set(3);
		}
		else if(i.equals(3)) {
			lit.add(4);
		}
		else {
			lit.remove();
		}
	}
	System.out.println(l);
	}

}
