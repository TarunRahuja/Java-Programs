package oopsPrac;
public class Student1 implements PersonInterface{
	public static void main(String[] args) {
		Student1 s1 = new Student1();
		s1.name();
		s1.gender();
		//a class can be declared abstract without having any abstract methods. It would prevent the class from instantiating.
	}
	@Override
	public void name() {
		System.out.println("name method");
	}
	@Override
	public void age() {
		System.out.println("age method");		
	}
	@Override
	public void gender() {
		System.out.println("gender method");		
	}
}
