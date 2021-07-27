package oopsPrac;
public class StudentInheritance extends Person{
	private int rollNo;
	public StudentInheritance(String name, int age, int rollNo) {
		//super(name,age); //must be first line of child class constructor. Calls parameterized constructor of parent class.
		System.out.println("Student Constructor Called.");
		this.rollNo = rollNo;
		this.age = age;
		this.name = name;
	}
	public static void main(String[] args) {
		StudentInheritance st = new StudentInheritance("Tarun", 20, 27);//First the parent class constructor is called before the given class's constructor.
		//Constructors are special and have same name as class name.
		//So if constructors were inherited in child class then child class would contain a parent class constructor which is against the constraint that constructor should have same name as class name
		//even the private members of a class are inherited by sub classes but cannot be accessed DIRECTLY by the subclass objects.
		print("Tarun","Dhruv");
		print(1,2,3,4,5);
	}
	public static void print(String ...names) {
		for(String name : names) {
			System.out.println(name);
		}
	}
	public static void print(int ...nums) {
		for(int val : nums) {
			System.out.println(val);
		}
	}

}
