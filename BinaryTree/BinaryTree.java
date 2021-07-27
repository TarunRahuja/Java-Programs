package BinaryTree;

import java.util.*;
public class BinaryTree {
	Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;	
	}
	 

	private Node root;
	public BinaryTree() {
		root = construct(null, false);
	}
	public BinaryTree(int []pre, int[]in)
	{
		root = construct(pre ,0, pre.length-1, in, 0,in.length-1);
		//root = construct1(post,0,post.length-1,in,0,in.length-1);
	}
	private Node construct(int[] pre, int plo, int phi, int[] in, int inl, int inh) {
		if(plo>phi||inl>inh)
			return null;
		Node nn = new Node();
	    nn.data	= pre[plo];
		int vidx = -1;
		for(int i = inl; i<=inh; i++)
		{
			if(in[i]==pre[plo])
			{
				vidx = i;
				break;
			}
		}
		int nel = vidx-inl;
		nn.left = construct(pre, plo+1, plo+nel, in, inl, vidx-1);
		nn.right = construct(pre, plo+nel+1, phi, in, vidx+1, inh);
		return nn;
	}
	private Node construct1(int[] post, int plo, int phi, int[] in, int inl, int inh) {
		if(plo>phi||inl>inh)
			return null;
		Node nn = new Node();
	    nn.data	= post[phi];
		int vidx = -1;
		for(int i = inl; i<=inh; i++)
		{
			if(in[i]==post[phi])
			{
				vidx = i;
				break;
			}
		}
		int nel = vidx-inl;
		nn.left = construct1(post, plo, plo+nel-1, in, inl, vidx-1);
		nn.right = construct1(post, plo+nel, phi-1, in, vidx+1, inh);
		return nn;
	}
	private Node construct(Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("enter data of root");
		} else {
			if (ilc) {
				System.out.println("Enter the value of left child of " + parent.data);
			} else {
				System.out.println("Enter the value of right child of" + parent.data);
			}
		}
		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;
		System.out.println("Does" + nn.data + "have left child?");
		boolean hlc = sc.nextBoolean();
		if (hlc) {
			nn.left = construct(nn, true);
		}
		System.out.println("Does" + nn.data + "have right child?");
		boolean hrc = sc.nextBoolean();
		if (hrc) {
			nn.right = construct(nn, false);
		}

		return nn;
	}

	public void display() {
		display(root);

	}

	private void display(Node node) {
		if (node == null)
			return;
		String ans = "";
		if (node.left == null) {
			ans = ans + ".";
		} else {
			ans = ans + node.left.data;
		}
		ans = ans + "-->" + node.data;
		if (node.right == null) {
			ans = ans + "-->.";
		} else {
			ans = ans + "-->" + node.right.data;
		}
		System.out.println(ans);
		display(node.left);
		display(node.right);
	}
	private int size(Node node) {
		int count = 0;
		if(node==null)
		{
			return 0;
		}
		count+=size(node.left);
		count+=size(node.right);
		return count+1;
	}
	public void size() {
		int ans = size(root);
		System.out.println(ans);
	}
	private int max(Node node)
	{
		if(node==null)
		{
			return Integer.MIN_VALUE;
		}
		int lm = max(node.left);
		int rm = max(node.right);
		if(node.data>=lm&&node.data>=rm)
		{
			return node.data;
		}
		else if(node.data<=lm &&lm>=rm)
		{
			return lm;
		}
		else if(node.data<=rm&&lm<=rm)
		{
			return rm;
		}
		//Math.max(node.data,Math.max(lm,rm));
		return 0;
	}
	public void max()
	{
		int ans = max(root);
		System.out.println(ans);
	}
	private boolean find(Node node,int item)
	{
		if(node==null)
			return false;
		if(node.data==item)
			return true;
		boolean lf = find(node.left,item);
		if(lf)
			return true;
		boolean rf = find(node.right,item);
		if(rf)
			return true;
		return false;
	}
	public void find(int item)
	{
		boolean ans = find(root,item);
		System.out.println(ans);
	}
	private int height(Node node)
	{
		if(node==null)
			return -1;
		int lh = height(node.left);
		int rh = height(node.right);
		return Math.max(lh, rh)+1;
	}
	public void height()
	{
		int ans = height(root);
		System.out.println(ans);
	}
	private int diameter(Node node)
	{
		if(node==null)
		{
			return 0;
		}
		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int sp = height(node.left)+height(node.right)+2;
		return Math.max(Math.max(ld, rd), sp);
	}
	public void diameter()
	{
		int ans = diameter(root);
		System.out.println(ans);
	}
	int diaans = 0;
	private int diameter2(Node node)
	{
		if(node==null)
			return -1;
		int lh = diameter2(node.left);
		int rh = diameter2(node.right);
		int diawithcurrentnode = lh+rh+2;
		if(diawithcurrentnode>diaans)
			diaans = diawithcurrentnode;
		return Math.max(lh, rh)+1;
	}
	public int diameter2() {
		diameter2(root);
		return diaans;
	}
	private class diapair{
		int d = 0;
		int h = -1;
	}
	private diapair diameter3(Node node)
	{
		if(node==null)
		{
			return new diapair();
		}
		diapair lp = diameter3(node.left);
		diapair rp = diameter3(node.right);
		diapair sp = new diapair();
		sp.d = Math.max(Math.max(lp.d, rp.d), lp.h+rp.h+2);
		sp.h = Math.max(lp.h, rp.h)+1;
		return sp;
	}
	public int diameter3() {
		return diameter3(root).d;
	}
	private boolean balance(Node node)
	{
		boolean sa = false;
		if(node==null)
		{
			return true;
		}
		boolean la = balance(node.left);
		boolean ra = balance(node.right);
	    int sbf = height(node.left)-height(node.right);
	    if(sbf==-1||sbf==0||sbf==1)
	    	sa = true;
	    return la&&ra&&sa;
	}
	public void balance()
	{
		boolean ans = balance(root);
		System.out.println(ans);
	}
	private class balancepair{
		int h = -1;
		boolean ans = true;
	}
	private balancepair balance2(Node node)
	{
		if(node==null)
		{
			return new balancepair();
		}
		balancepair lbp = balance2(node.left);
		balancepair rbp = balance2(node.right);
		balancepair sbp = new balancepair();
		sbp.h = Math.max(lbp.h, rbp.h)+1;
		int bf = lbp.h-rbp.h;
		if(bf==-1||bf==0||bf==1&&lbp.ans&&rbp.ans)
			sbp.ans = true;
		else
			sbp.ans = false;
		return sbp;
	}
	public void balance2() {
		boolean ans1 = balance2(root).ans;
		System.out.println(ans1);
	}
	private boolean flipequiv(Node n1,Node n2)
	{
		if(n1==null&&n2==null)
			return true;
		if(n1==null||n2==null)
			return false;
		if(n1.data!=n2.data)
			return false;
		boolean o1 = flipequiv(n1.left, n2.left);
		boolean o2 = flipequiv(n1.right, n2.right);
		boolean o3 = flipequiv(n1.left, n2.right);
		boolean o4 = flipequiv(n1.right, n2.left);
		return (o1&&o2)||(o3&&o4);
	}
	public void flipequiv(BinaryTree other)
	{
		boolean ans = flipequiv(this.root,other.root);
		System.out.println(ans);
	}
	private class pair{
		Node n;
		boolean ld;
		boolean sd;
		boolean rd;
	}
	public void preorder()
	{
		Stack<pair> stack = new Stack<>();
		pair p = new pair();
		p.n = root;
		stack.push(p);
		while(!stack.isEmpty()) {
		p = stack.peek();	
		if(p.sd==false)
		{
			System.out.print(p.n.data+" ");
			p.sd = true;
		}
		else if(p.ld==false)
		{
			pair lp = new pair();
			lp.n = p.n.left;
			p.ld = true;
			if(lp.n!=null)
			stack.push(lp);
		}
		else if(stack.peek().rd==false)
		{
			pair rp = new pair();
			rp.n = p.n.right;
			p.rd = true;
			if(rp.n!=null)
			stack.push(rp);
		}
		else
		{
			stack.pop();
		}
		
	}
}
	int max = Integer.MIN_VALUE;
	private int maxsumsubtree(Node node)
	{
		if(node==null)
			return 0;
		int suml = maxsumsubtree(node.left);
		int sumr = maxsumsubtree(node.right);
		int sumself = suml+sumr+node.data;
		if(sumself>max)
			max = sumself;
		return sumself;
	}
	public void maxsumsubtree() {
		maxsumsubtree(root);
		System.out.println(max);
	}
	private class subtreepair{
		int ents = 0;
		int maxtillnow = Integer.MIN_VALUE;
	}
	private subtreepair maxsum(Node node)
	{
		if(node==null)
			return new subtreepair();
		subtreepair lp = maxsum(node.left);
		subtreepair rp = maxsum(node.right);
		subtreepair cp = new subtreepair();
		cp.ents = lp.ents+rp.ents+node.data;
		cp.maxtillnow = Math.max(Math.max(lp.maxtillnow, rp.maxtillnow), cp.ents);
		return cp;
	}
	public void maxsum() {
		subtreepair ansp = maxsum(root);
		System.out.println(ansp.maxtillnow);
	}
	private class BstTriplet
	{
		boolean isbst = true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int size;
		Node largestval;
	}
	
	private BstTriplet isItBst(Node node)
	{
	  if(node==null)
	  {
		  return new BstTriplet();
	  }
	   BstTriplet lbt = isItBst(node.left);
	   BstTriplet rbt = isItBst(node.right);
	   BstTriplet sbt = new BstTriplet();
	   if(lbt.isbst&&rbt.isbst&&node.data<rbt.min&&node.data>lbt.max)
	   {
		   sbt.isbst = true;
           sbt.size = lbt.size+rbt.size+1;
           sbt.largestval = node;
	   }
	   else
		   {
		     sbt.isbst = false;
		     if(lbt.size>=rbt.size)
		     {
		    	 sbt.size = lbt.size;
		    	 sbt.largestval = lbt.largestval;
		     }
		     else
		     {
		    	 sbt.size = rbt.size;
		    	 sbt.largestval = rbt.largestval;
		     }
	         
		   }
	   sbt.max = Math.max(node.data, Math.max(lbt.max, rbt.max));
	   sbt.min = Math.min(node.data, Math.min(lbt.min, rbt.min));
	   return sbt;
	}
	public void isItBst()
	{
		BstTriplet ans = isItBst(root);
		System.out.println(ans.isbst);
		System.out.println(ans.size);
		System.out.println(ans.largestval.data);
	}
	private class vopair implements Comparable<vopair> {
		int val;
		int hlevel;
		int vlevel;
		public vopair(int val,int hlevel,int vlevel)
		{
			this.val = val;
			this.hlevel = hlevel;
			this.vlevel = vlevel;
		}
		@Override
		public String toString() {
			return val+"";
		}
		@Override
		public int compareTo(vopair o) {
			
			return this.hlevel-o.hlevel;
		}
	}
	public void verticaldisplay()
	{
		HashMap<Integer, ArrayList<vopair>> map = new HashMap<>();
		verticaldisplay(root,map,0,0);
		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
	    for(int key:map.keySet())
	    {
	    	ArrayList<vopair> keylist = map.get(key);
	    	Collections.sort(keylist);
	    }
	    for(int num:list)
	    {
	    	System.out.print(num+"-->");
	    	ArrayList<vopair> disp =  map.get(num);
	    	System.out.println(disp);
	    }
		
	}
	 private void verticaldisplay(Node node, HashMap<Integer, ArrayList<vopair>> map, int hlevel, int vlevel) {
		if(node==null)
			return;
		if(!map.containsKey(vlevel))
		{
			map.put(vlevel,new ArrayList<>());
		}
		vopair np = new vopair(node.data, hlevel, vlevel);
		map.get(vlevel).add(np);
		verticaldisplay(node.left, map, hlevel+1, vlevel-1);
		verticaldisplay(node.right, map, hlevel+1, vlevel+1);
	}
	public class pair1{
	        int data;
	        boolean isfound = true;
	    }
	 private pair1 lca(Node node,int d1, int d2) {
	     if(node==null)
	     {
	         return new pair1();
	     }
	     if(node.data==d1||node.data==d2)
	     {
	         pair1 np = new pair1();
	         np.data = node.data;
	         np.isfound = true;
	         return np;
	     }
	     pair1 lp = lca(node.left,d1,d2);
	     pair1 rp = lca(node.right,d1,d2);
	     pair1 sp = new pair1();
	     if(lp.isfound&&rp.isfound)
	     {
	        sp.data = node.data;
	        sp.isfound = true;
	        return sp;
	     }
	     else if(lp.isfound==true&&rp.isfound==false)
	     {
	         return lp;
	     }
	     else if(lp.isfound==false&&rp.isfound==true)
	     {
	        return rp;
	     }
		return null;
	    }
	    public pair1 lca(int d1,int d2)
	    {
	        pair1 ans = lca(root,50,60);
	        return ans;
	    }
	
	

}