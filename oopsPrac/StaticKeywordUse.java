package oopsPrac;
public class StaticKeywordUse {
	private int x;
	static int y;
	static {
		//x = 4; Causes trouble because static initializer blocks cannot refer non static fields.
		y = 3;
	}
	{
		x = 2;
	}
	public void fun() {
		System.out.println("In instance fun");
	}
	public static void fun2() {
		//System.out.println(x); Gave error because static functions cannot refer instance specific data members;
		//fun();Gave error because static functions cannot refer instance specific member functions;
		System.out.println("In static fun");
	}
	public static void main(String[] args) {
		fun2();
		StaticKeywordUse obj = new StaticKeywordUse();
		obj.fun2();
		obj.fun();
		System.out.println("x = "+obj.x);
		System.out.println("y = "+obj.y);
	}
}