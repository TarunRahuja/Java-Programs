package oopsPrac;
public class Person {
	protected String name;
	protected int age;
	public Person() {
		System.out.println("Person Constructor Called.");
	} // must be defined so that when this class is inherited there is no need to explicitly re define the same in child class.
	public Person(String name, int age) {
		System.out.println("Person Parameterized Constructor Called.");
		this.name = name;
		this.age = age;
	}
	public void override() {
		System.out.println("Super Class(Person) method called!");
	}
}
