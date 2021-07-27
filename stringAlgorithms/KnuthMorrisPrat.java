package stringAlgorithms;
import java.util.*;
public class KnuthMorrisPrat {
	public static void main(String[] args) {
		String str = "ababcabdab";
		String pat = "abd";
		int i = 0,j = 0;
		int []reset = new int[pat.length()];
		resetTable(reset, pat);
		while(i<str.length()) {
			while(j>=0&&j<pat.length()&&pat.charAt(j)!=str.charAt(i)) {
			     j = reset[j]; 
			}
			i++;
			j++;
			if(j==pat.length()) {
				int match = i-j;
				System.out.println("Match found at: "+match);
				return;
			}
		}
		System.out.println("Pattern not found");
	}
	public static void resetTable(int []table,String pat) {
		int i=0;
		int j=1;
		table[0] = -1;
		while(i<table.length) {
			while(j>=0&&j<pat.length()&&pat.charAt(j)!=pat.charAt(i)) {
				j = table[j];
			}
			i++;
			j++;
			if(i<table.length)
				table[i] = j;
		}
	}

}
