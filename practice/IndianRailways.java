package practice;
import java.util.*;
import java.io.*;
class IndianRailways {
    static class Route{
        String trains;
        int len;
        int cost;
        public Route(String trains,int len, int cost){
            this.trains = trains;
            this.len = len;
            this.cost = cost;
        }
        @Override
        public String toString(){
            return this.trains+" "+this.cost;
        }
    }
    public static void main(String args[] ) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String []srcdest = br.readLine().split(" ");                                     
       ArrayList<String>input = new ArrayList<>();
       while(true){
           String line = br.readLine();
           if(line==null)break;
           input.add(line);
       }
       HashMap<String,Integer>map = new HashMap<>();
        int id = 0;
        int [][]adj = new int[100][100];
        int n = 0;
        HashMap<Integer,String>rev = new HashMap<>();
        for(String in:input){
            String []temp = in.split(" ");
            if(!map.containsKey(temp[0])){
                map.put(temp[0],id);
                rev.put(id,temp[0]);
                n = id;
                id++;
            }
            if(!map.containsKey(temp[1])){
                map.put(temp[1],id);
                rev.put(id,temp[1]);
                n = id;
                id++;
            }
            n=id;
            if(adj[map.get(temp[0])][map.get(temp[1])]==0)
              adj[map.get(temp[0])][map.get(temp[1])] = Integer.parseInt(temp[2]);
              else{
                  adj[map.get(temp[0])][map.get(temp[1])] = Math.min(Integer.parseInt(temp[2]),adj[map.get(temp[0])][map.get(temp[1])]);
              }
        }
        String src = srcdest[0];
        String dest = srcdest[1];
        ArrayList<Route>routes = new ArrayList<>();
        dfs(adj,n,src,dest,routes,0,0,new HashSet<Integer>(),map,rev,"");
        Collections.sort(routes,new Comparator<Route>(){
            @Override
            public int compare(Route t, Route o){
                if(t.cost!=o.cost){
                    return t.cost-o.cost;
                }
                if(t.len!=o.len){
                    return t.len-o.len;
                }
                return t.trains.compareTo(o.trains);
            }
        });
        for(Route r:routes){
            System.out.println(r);    
        }
    }
    public static void dfs(int [][]adj,int n,String curr,String dest,ArrayList<Route>routes, int len,int cost,HashSet<Integer>visited,HashMap<String,Integer>map,HashMap<Integer,String>rev,String route){
        if(curr.equals(dest)){
            routes.add(new Route(route+dest,len,cost));
            return;
        }
        if(visited.contains(map.get(curr)))return;
        visited.add(map.get(curr));
        for(int nbr=0; nbr<n; nbr++){
            if(adj[map.get(curr)][nbr]!=0){
                dfs(adj,n,rev.get(nbr),dest,routes,len+1,cost+adj[map.get(curr)][nbr],visited,map,rev,route+curr+" ");
            }
        }
    }
}

