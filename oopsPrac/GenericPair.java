package oopsPrac;
public class GenericPair<T,S> {
	T first;
	S second;
	public GenericPair(T first, S second) {
		this.first = first;
		this.second = second;
	}
	public static void main(String[] args) {
		GenericPair<Integer, String>gp = new GenericPair<Integer, String>(20,"Tarun");
		System.out.println(gp.add(2, 3));
	}
	public static<T> T add(T a, T b) {
		return a;
	}
	//the <T> aside static has to be there whenever the static keyword is used to prevent "non static reference error".
}
