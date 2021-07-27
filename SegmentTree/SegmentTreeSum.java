package SegmentTree;

public class SegmentTreeSum implements SegmentTreeI {

	@Override
	public int operation(int a, int b) {
		
		return a+b;
	}

	@Override
	public int defaultval() {
		return 0;
	}
	

}
