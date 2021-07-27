package oopsPrac;
public class OuterClass {
	int e;
	int f;
	static class Inner1{
		int a;
		int b;
		public Inner1() {}
		public Inner1(int a,int b) {
			this.a = a;
			this.b = b;
		}
	}
	class Inner2{
		int c;
		int d;
		public Inner2() {}
		public Inner2(int c, int d) {
			this.c = c;
			this.d = d;
		}
	}
	Inner1 i1;
	Inner2 i2;
	//before making instance members of inner class one must define their blueprint. This is not the same with other outer classes. They can be defined anywhere.
	public OuterClass() {
		i1 = new Inner1();
		i2 = new Inner2();
	}
	public OuterClass(int e,int f) {
		this.e = e;
		this.f = f;
		i1 = new Inner1(e,f);
		i2 = new Inner2(e,f);
	}
	public static void main(String[] args) {
		OuterClass outer = new OuterClass(3,5);
		System.out.println(outer.i1.a);
		Inner1 obj1 = new Inner1(2,3);
		OuterClass.Inner2 obj2 = outer.new Inner2(3,4);
	}
}