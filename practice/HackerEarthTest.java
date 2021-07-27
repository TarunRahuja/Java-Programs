package practice;
import java.util.*;
class HackerEarthTest {
    static class Pair{
        int count;
        HashSet<Character> set = new HashSet<>(); 
        public Pair(int count,HashSet<Character>set){
            this.count = count;
            this.set = set;
        }
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String str = sc.next();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            adj.add(new ArrayList<>());
            for(int i=0; i<n; i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0; i<n-1; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            //System.out.println(adj);
            System.out.println(dfs(1,adj,str, new HashSet<Integer>()).count);
        }
    }
    public static Pair dfs(int curr,ArrayList<ArrayList<Integer>>adj,String str,HashSet<Integer>visited){
        HashSet<Character> temp = new HashSet<>();
        if(adj.get(curr).size()==0){
            temp.add(str.charAt(curr-1));
            return new Pair(1,temp);
        }
        int count = 0;
        boolean flag = false;
        visited.add(curr);
        temp.add(str.charAt(curr-1));
        for(int val:adj.get(curr)){
            if(visited.contains(val))continue;
            Pair rp = dfs(val,adj,str,visited);
            temp.addAll(rp.set);
            if(rp.set.contains(str.charAt(curr-1))){
                flag = true;
            }
            count+=rp.count;
        }
        if(!flag){
            return new Pair(count+1,temp);
        }
        else{
            return new Pair(count,temp);
        }
    }
}
