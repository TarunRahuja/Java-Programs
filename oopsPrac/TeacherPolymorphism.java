package oopsPrac;
public class TeacherPolymorphism extends Person {
	protected String subject;
	public void override() {
		System.out.println("Sub Class(Teacher) method called!");
	}
	public TeacherPolymorphism(String name,int age, String subject) {
		super(name,age);
		this.subject = subject;
	}
	public static void main(String[] args) {
		TeacherPolymorphism teach = new TeacherPolymorphism("Munna",30,"Maths");
		teach.override();
		Person t = new TeacherPolymorphism("Munna",30,"Maths");
		t.override();
		Person p = new Person("Tarun",20);
		p.override();
	}

}
