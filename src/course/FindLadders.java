package course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLadders {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> stoi = new HashMap<>();
        String[] itos = new String[wordList.size()+1];
        if(!wordList.contains(endWord)){
            return new ArrayList<List<String>>();
        }
        //initialization
        int t = 0;
        for (String string : wordList) {
            if(stoi.containsKey(string)){
                continue;
            }
            stoi.put(string, t);
            itos[t++] = string;
        }
        stoi.put(beginWord, t);
        itos[t++]= beginWord;

        int[] cost = new int[wordList.size()];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        ArrayList<List<String>> res= new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        var tt = new ArrayList<String>();
        tt.add(beginWord);
        queue.offer(tt);
        while(!queue.isEmpty()){
            var item = queue.poll();
            var point = item.get(item.size()-1);
            if(point==endWord){
                res.add(item);
            }
        }


    }

    private boolean helper(String[] itos, int i, int j){
        if(i==j){
            return false;
        }
        var s1 = itos[i].toCharArray();
        var s2 = itos[j].toCharArray();
        int diff = 0;
        for (int k = 0; k < s2.length; k++) {
            if(s1[k]!=s2[k]){
                diff++;
            }
        }
        return diff==1;
    }
}