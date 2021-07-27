package BinaryTree;
public class BinaryTreeClient {

	public static void main(String[] args) {
		//10 true 5 true 4 false false true 6 false false true 30 false true 60 false false
		//10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
		//10 true 30 true 60 false false false true 20 true 40 false false true 50 false false
		//1 true 2 true 4 false false true -5 false false true -3 true -4 false false true 5 true 6 false false true 7 false false 
	
		//pair1 ans = bt.lca(50, 60);
		//System.out.println(ans.data);
//		int []pre = {10,20,70,30,40,50,60};
//		int []in = {20,70,10,40,50,30,60};
//		int []post = {70,20,50,40,60,30,10};
		int [] pre = {10,20,40,120,100,50,80,130,30,60,70,90};
		int [] in = {120,40,100,20,50,80,130,10,60,30,90,70};
		//BinaryTree bt = new BinaryTree(pre,in);
//		bt.verticaldisplay();
		//bt.display();
		//bt.size();
		//bt.max();
		//bt.find(60);
		//bt.height();
		//System.out.println(bt.diameter3());
		//bt.balance2();
		BinaryTree bt1 = new BinaryTree();
		System.out.println(bt1.lca(50,60).data);
		//bt1.flipequiv(bt1);
		//bt.preorder();
		//bt.maxsum();
//		BinaryTree bt = new BinaryTree(post, in);
//		bt.display();
		//bt.isItBst();
		
		
		
		

	}

}
