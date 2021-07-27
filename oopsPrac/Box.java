package oopsPrac;

public class Box {
	private int length;
	private int breadth;
	private int height;
	public int[] getDimensions() {
		return new int[] {this.length,this.breadth,this.height};
	}
	public void setDimensions(int length, int breadth, int height) {
		this.breadth = breadth;
		this.length = length;
		this.height = height;
	}
	public static void main(String[] args) {
		Box b = new Box();
		b.setDimensions(5, 5, 5);
		for(int val : b.getDimensions()) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
