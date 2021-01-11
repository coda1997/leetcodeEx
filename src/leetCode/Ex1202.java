package leetCode;

import java.util.*;

public class Ex1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        var cc = s.toCharArray();
        UnionFind unionFind = new UnionFind(cc.length);
        for (var pair :
                pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }
        var map = new HashMap<Integer, PriorityQueue<Character>>();
        for (int i = 0; i < cc.length; i++) {
            int key = unionFind.find(i);
            if (!map.containsKey(key)) {
                map.put(key, new PriorityQueue<>());
            }
            var ll = map.get(key);
            ll.offer(cc[i]);
        }
        for (int i = 0; i < cc.length; i++) {
            cc[i] = map.get(unionFind.find(i)).poll();
        }
        return new String(cc);
    }


    class UnionFind{
        private int[] parents;

        UnionFind(int n){
            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        int find(int i){
            if(parents[i]!=i){
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }
        void union(int i, int j){
            int pi=  find(i);
            int pj = find(j);
            if (pi==pj){
                return;
            }
            parents[pi] = pj;
        }
    }

    public static void main(String[] args) {
        var o = new Ex1202();
        var links = new ArrayList<List<Integer>>();
        links.add(Arrays.asList(0,3));
        links.add(Arrays.asList(0,2));
        links.add(Arrays.asList(1,2));
        System.out.println(o.smallestStringWithSwaps("dcab", links));
    }
}
