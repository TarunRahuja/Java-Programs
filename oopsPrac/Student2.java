package oopsPrac;
public class Student2 extends Student1 implements PersonInterface {
	public static void main(String[] args) {
		PersonInterface p = new Student2();
		p.age();
		p.gender();
	}

	@Override
	public void age() {
		System.out.println("age method 2");		
	}
	@Override
	public void name() {
		System.out.println("name method 2");
	}
	@Override
	public void gender() {
		System.out.println("gender method 2");
	}
}
