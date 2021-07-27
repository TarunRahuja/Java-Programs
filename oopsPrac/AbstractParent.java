package oopsPrac;
public abstract class AbstractParent {
	String name;
	public AbstractParent() {	
	} 
	public AbstractParent(String name) {
		this.name = name;
	}
	public abstract void getName();
}
