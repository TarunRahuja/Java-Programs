package HashMapOps;
import java.io.*;
import java.util.*;
public class HashMapImplementation{

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
       }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
        int bi = hashFunction(key);
        int idx = getIndexWithinBucket(key,bi);
        if(idx == -1){
            HMNode node = new HMNode(key,value);
            buckets[bi].add(node);
            size++;
        }
        else{
            HMNode node = buckets[bi].get(idx);
            node.value = value;
        }
        double lambda = (size * 1.0) / buckets.length;
        if(lambda > 2.0){
            reHash();
        }
    }
    private void reHash() throws Exception{
        int N = buckets.length;
        LinkedList<HMNode>[] oldBuckets = buckets;
        buckets = new LinkedList[2*N];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
        size = 0;
        for(int i=0; i<N; i++){
            for(HMNode hmn : oldBuckets[i]){
                int bi = hashFunction(hmn.key);
                put(hmn.key,hmn.value);
            }
        }
    }
    private int getIndexWithinBucket(K key, int bi){
        int idx = 0;
        for(HMNode hmn : buckets[bi]) {
            if(hmn.key.equals(key)){
                return idx;
            }
            idx++;
        }
        return -1;
    }
    private int hashFunction(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }
    public V get(K key) throws Exception {
        int bi = hashFunction(key);
        int idx = getIndexWithinBucket(key,bi);
        if(idx == -1){
            return null;
        }
        else{
            return buckets[bi].get(idx).value;
        }
    }

    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int idx = getIndexWithinBucket(key,bi);
        return idx != -1;
    }

    public V remove(K key) throws Exception {
        int bi = hashFunction(key);
        int idx = getIndexWithinBucket(key,bi);
        if(idx == -1){
            return null;
        }
        else{
            V value = buckets[bi].get(idx).value;
            buckets[bi].remove(idx);
            size--;
            return value;
        }
    }

    public ArrayList<K> keyset() throws Exception {
        ArrayList<K> ans = new ArrayList<K>();
        for(int i=0; i<buckets.length; i++){
            for(HMNode hmn : buckets[i]){
                ans.add(hmn.key);
            }
        }
        return ans;
    }

    public int size() {
        return size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}