package oopsPrac;
public class AbstractChild extends AbstractParent {
	int age;
	public AbstractChild(String name, int age) {
		super(name);
		this.age = age;
	}
	public static void main(String[] args) {
		AbstractChild child = new AbstractChild("tarun", 20);
		child.getName();
	}

	@Override
	public void getName() {
		System.out.println(super.name);
	}
}
