package tries;
import java.util.*;

public class Tries {
	private class Node{
		char ch;
		HashMap<Character,Node> table = new HashMap<>();
		boolean eow;
		public Node(char ch)
		{
			this.ch = ch;
		}
	}
	private Node root;
	public Tries()
	{
		root = new Node('*');
	}
	public void addword(String word)
	{
		addword(root,word);
	}
	private void addword(Node node, String word) {
		if(word.length()==0)
		{
			node.eow = true;
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		if(node.table.containsKey(ch))
		{
			Node child = node.table.get(ch);
			addword(child,row);
		}
		else
		{
			Node child = new Node(ch);
			node.table.put(ch, child);
			addword(child,row);
		}
	}
	public void display()
	{
		display(root,"");
	}
	private void display(Node node,String ans) {
		if(node.eow)
		{
			System.out.println(ans);
		}
		for(char ch:node.table.keySet())
		{
			display(node.table.get(ch),ans+ch);
		}
		
	}
	public boolean search(String word)
	{
		return search(root,word);
	}
	private boolean search(Node node, String word) {
		if(word.length()==0)
		{
			return node.eow;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		if(node.table.containsKey(ch))
		{
			Node child = node.table.get(ch);
			return search(child,row);
		}
		else
		{
			return false;
		}
		
	}
	public boolean startswith(String word)
	{
		return startswith(root,word);
	}
	private boolean startswith(Node node, String word) {
		
		if(word.length()==0)
		{
			return true;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		if(node.table.containsKey(ch))
		{
			Node child = node.table.get(ch);
			return startswith(child,row);
		}
		else
		{
			return false;
		}
	}
	public void remove(String word)
	{
		remove(root,word);
	}
	private void remove(Node node, String word) {
		if(word.length()==0)
		{
			node.eow = false;
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		if(node.table.containsKey(ch))
		{
			Node child = node.table.get(ch);
			remove(child,row);
			if(!child.eow&&child.table.size()==0)
				node.table.remove(ch); 
		}
		else
		{
			return;
		}
	}
	

}
