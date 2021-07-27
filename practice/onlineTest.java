package practice;

import java.util.*;
class onlineTest {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        while(q-->0){
            int type = sc.nextInt();
            if(type==1){
            	int idx = sc.nextInt();
            	int val = sc.nextInt();
            	arr[idx-1] = val;
            }
            else {
            	int l = sc.nextInt();
            	int r = sc.nextInt();
            	int a = sc.nextInt();
            	int b = sc.nextInt();
            	int ans = 0;
            	for(int i=l-1; i<=r-1; i++) {
            		if(arr[i]%a==0||arr[i]%b==0||arr[i]==a+b||arr[i]%(a+b)==0) {
            			ans+=0;
            		}
            		else {
            			int lowera = arr[i]%a;
            			int uppera = a-lowera;
            			int aContribution = Math.min(uppera, lowera);
            			int lowerb = arr[i]%b;
            			int upperb = b-lowerb;
            			int bContribution = Math.min(upperb, lowerb);
            			ans+=Math.min(aContribution, bContribution);
            		}
            	}
            	System.out.println(ans);
            }
        }
    }
}  
