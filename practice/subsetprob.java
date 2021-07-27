package practice;
import java.util.ArrayList;
import java.util.Scanner;
public class subsetprob {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=scn.nextInt();
        }
        StringBuilder st = new StringBuilder();
        for(int i=0;i<n;i++) {
            st.append(arr[i]);
        }
        String str=st.toString();
        int tar=scn.nextInt();
        ArrayList<String> mr=new ArrayList<>();
        mr=getSS(str);
        int count=0;
        
        for(int i=1;i<mr.size();i++) {
            String s=mr.get(i);
            int num=Integer.parseInt(s);
            if(sum(num)==tar) {
                String print = num+"";
                for(int k = 0; k<print.length(); k++)
                {
                	System.out.print(print.charAt(k));
                	System.out.print(" ");
                }
            	//System.out.print(k+" ");
                count++;
            }
        }
        System.out.println();
        System.out.print(count);
        
    }
    public static ArrayList<String> getSS(String str) {
        if(str.length()==0) {
            ArrayList<String> br=new ArrayList<>();
            br.add("");
            return br;
        }
        char ch=str.charAt(0);
        ArrayList<String> rr=getSS(str.substring(1));
        ArrayList<String> mr=new ArrayList<>();
        
        
        for(String val:rr) {
            mr.add(val);
            mr.add(ch+val);
        }
        return mr;
    }
    public static int sum(int n) {
        int sum=0;
        while(n>0) {
            int rem=n%10;
            sum+=rem;
            n=n/10;
        }
        return sum;
    }
}
