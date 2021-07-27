package OOPS;

public class GenericTreeClient {

	public static void main(String[] args) {
		//10 3 20 2 30 0 40 0 80 0 50 2 60 0 70 0 
		//10 3 20 3 50 2 100 0 110 0 60 0 70 2 120 2 160 0 170 0 130 0 30 0 40 2 80 0 90 2 140 2 180 0 190 0 150 0 
		GenericTree gt = new GenericTree();
		//gt.display();
		//System.out.println(gt.maximum());
		//System.out.println(gt.search(80));
		//gt.height();
		//gt.display();
		//gt.mirror();
		//gt.Linearize();
		//gt.display();
		gt.LevelOrderZZ();
	}

}
