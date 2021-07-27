package BinarySearchTree;

public class BinarySearchTreeClient {

	public static void main(String[] args) {
		int [] inorder = {10,20,30,40,50,60};
		BinarySearchTree bt = new BinarySearchTree(inorder);
		//bt.find();
		//bt.display();
		//bt.printrange(42, 65);
//		bt.replace();
//		bt.display();
		bt.add(19);
		bt.add(23);
		bt.display();
		bt.RemoveReturn(20);
		System.out.println();
		bt.display();

	}

}
