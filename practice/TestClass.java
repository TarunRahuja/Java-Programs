package practice;
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int rot = 0;
        while(q-->=0){
            String type = sc.nextLine();
            String []temp = type.split(" ");
            int idx = -1;
            if(temp[0].equals("Increment")){
                idx = (Integer.parseInt(temp[1])-1-rot);
                if(idx<0){
                    idx+=n;
                }
                idx%=n;
                arr[idx]++;
            }
            else if(temp[0].equals("Update")){
                idx = (Integer.parseInt(temp[1])-1-rot);
                if(idx<0){
                    idx+=n;
                }
                idx%=n;
                arr[idx] = Integer.parseInt(temp[2]);
            }
            else if(temp[0].equals("Left")){
                rot = (rot-1)%n;
            }
            else if(temp[0].equals("Right")){
                rot = (rot+1)%n;
            }
            else if(temp[0].equals("?")){
                idx = (Integer.parseInt(temp[1])-1-rot);
                if(idx<0){
                    idx+=n;
                }
                idx%=n;
                System.out.println(arr[idx]);
            }
        }
    }
}
