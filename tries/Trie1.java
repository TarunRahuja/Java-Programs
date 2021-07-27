package tries;
import java.util.*;
public class Trie1 {
	private class Node{
		int ch;
		HashMap<Character, Node> map = new HashMap<>();
		boolean eow;
		public Node(int ch) {
			this.ch = ch;
		}
	}
	private Node root;
	public Trie1() {
		this.root = new Node('*');
	}
	public void addWord(String word) {
		addWord(word,root);
	}
	private void addWord(String word,Node node) {
		if(word.length()==0) {
			node.eow = true;
			return;
		}
		if(node.map.containsKey(word.charAt(0))) {
			Node child = node.map.get(word.charAt(0));
			addWord(word.substring(1), child);
		}
		else {
			Node child = new Node(word.charAt(0));
			node.map.put(word.charAt(0),child);
			addWord(word.substring(1),child);
		}
	}
	public void display() {
		display(root,"");
	}
	private void display(Node root,String ans) {
		if(root.eow) {
			System.out.println(ans);
		}
		ArrayList<Character> children = new ArrayList<>(root.map.keySet());
		for(int i=0; i<children.size(); i++) {
			display(root.map.get(children.get(i)),ans+root.ch);
		}
	}
	private boolean search(Node node,String word) {
		if(word.length()==0) {
			return node.eow;
		}
		if(!node.map.containsKey(word.charAt(0))) {
			return false;
		}
		else {
			return search(node.map.get(word.charAt(0)),word.substring(1));
		}
	}
	public boolean search(String word) {
		return search(root,word);
	}
	private void remove(Node node,String word) {
		if(word.length()==0) {
			node.eow = false;
			return;
		}
		if(node.map.containsKey(word.charAt(0))) {
			remove(node.map.get(word.charAt(0)),word.substring(1));
			if(!node.map.get(word.charAt(0)).eow && node.map.get(word.charAt(0)).map.size()==0) {
				node.map.remove(word.charAt(0));
			}
		}
		else {
			return;
		}
	}
	public void remove(String word) {
		remove(root,word);
	}
	private boolean searchAll(Node node,String pat){
		if(pat.length()==0){
			display(node,pat);
			return true;
		}
		char ch = pat.charAt(0);
		String rop = pat.substring(1);
		if(node.map.containsKey(ch)){
			return searchAll(node.map.get(ch),rop);
		}
		else{
			return false;
		}
	}
	public boolean searchAll(String pat) {
		return searchAll(root, pat);
	}
}
