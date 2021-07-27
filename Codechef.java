import java.util.*;
class Codechef{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
        	int n = sc.nextInt();
        	int k = sc.nextInt();
        	int [][][] strg = new int [151][151][151];
        	for(int i=0; i<151; i++) {
        		for(int j=0; j<151; j++) {
        			for(int l=0; l<151; l++) {
        				strg[i][j][l] = -1;
        			}
        		   
        		}
        	}
        	System.out.println(helper(n,k,1));
        }
    }
//    public static int helper(int n, int k,int last,int [][][]strg,String ans) {
//    	if(n==0) {
//    		if(k==0)
//    		{
//    			//System.out.println(ans);
//    			return 1;
//    		}
//    			
//    		else {
//    			return 0;
//    		}
//    	}    		
//    	if(strg[n][k][last]!=-1)
//    		return strg[n][k][last];
//    	int ways = 0;
//    	for(int i=last; i<=k; i++) {
//    		ways+=helper(n-1, k-i,i,strg,ans+""+i+" ");
//    	}
//    	strg[n][k][last] = ways;
//    	return ways;
//    }
    public static int helper(int n, int k, int last){
        if(k==0){
            if(n==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(n<0){
            return 0;
        }
        int ways = 0;
        for(int i=last; i<=n-k; i++){
            ways += helper(n-i,k-1,i);
        }
        return ways;
    }
}