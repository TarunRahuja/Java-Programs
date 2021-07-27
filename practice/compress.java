package practice;

import java.util.*;
public class compress {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int i = 0;
        int j = 0;
        int count = 1;
        int n = str.length();
        ArrayList<Character> comp = new ArrayList<>();
        while(i<n)
        {
            count = 1;
            char ch = str.charAt(i);
            comp.add(ch);
            j = i+1;
            while(j<n && str.charAt(j)==str.charAt(i))
            {
                count++;
                j++;
            }
            if(count!=1)
            {
            	String s = count+" ";
                comp.add((s.charAt(0)));
            }
            i = j;
        }
        for(int k = 0; k<comp.size();k++)
        {
            char c = comp.get(k);
            System.out.print(c);
        }

    }


}

