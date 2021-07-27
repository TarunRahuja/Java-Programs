package practice;
import java.util.*;
import java.lang.*;
import java.io.*;

class Password
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    HashSet<Character> set = new HashSet<>();
	    for(char c='a'; c<'z'; c++){
	        set.add(c);
	    }
	    for(char c='A'; c<'Z'; c++){
	        set.add(c);
	    }
	    for(char c='0'; c<='9'; c++){
	        set.add(c);
	    }
	    //System.out.println(set);
	    generateCombinations(new String(), 11, 0 , set);
	}
	
	public static void generateCombinations(String str, int n, int vidx, HashSet<Character> set) {
	    if(vidx == n){
	        System.out.println(str);
	        return;
	    }
	    for(Character c : set){
	        generateCombinations(str+c, n, vidx+1, set);
	    }
	}
}
