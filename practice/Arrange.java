package practice;
import java.util.*;
public class Arrange{
	public static void main(String[] args) {
		System.out.println(arrange("BWWWWBBWWBWBWWBBBBBWBWWBBBWWWWBBBW",28));
	}
	public static int arrange(String A, int B){
        ArrayList<Integer>black = new ArrayList<>();
        ArrayList<Integer>white = new ArrayList<>();
        for(int i=0; i<B; i++){
            black.add(0);
            white.add(0);
        }
        return arrangeUtil(A,black,white,0,0);
    }
    public static int arrangeUtil(String A,ArrayList<Integer>black,ArrayList<Integer>white,int vidx, int last){
        int ans = 0;
        if(vidx==A.length()){
            ans = 0;
            // System.out.println(black);
            // System.out.println(white);
            for(int j=0; j<black.size(); j++){
                if(black.get(j).equals(0)&&white.get(j).equals(0)){
                    ans = 999999;
                    break;
                }
                ans+=(black.get(j)*white.get(j));
            }
            //System.out.println(ans);
            return ans;
        }
        int min = 999999;
        for(int i=last; i<black.size(); i++){
            if(A.charAt(vidx)=='W'){
                white.set(i,white.get(i)+1);
                ans = arrangeUtil(A,black,white,vidx+1,i);
                white.set(i,white.get(i)-1);
            }
            else{
                black.set(i,black.get(i)+1);
                ans = arrangeUtil(A,black,white,vidx+1,i);
                black.set(i,black.get(i)-1);
            }
            min = Math.min(min,ans);
        }
        return min;
    }
}
