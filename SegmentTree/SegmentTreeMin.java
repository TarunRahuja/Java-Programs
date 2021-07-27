package SegmentTree;

public class SegmentTreeMin implements SegmentTreeI {

	@Override
	public int operation(int a, int b) {
		
		return Math.min(a, b);
	}

	@Override
	public int defaultval() {
		
		return Integer.MAX_VALUE;
	}

}
