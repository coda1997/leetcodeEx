package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/**
 *给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 *每次转换只能改变一个字母。
 *转换后得到的单词必须是字典中的单词。
 *说明:
 *
 *如果不存在这样的转换序列，返回一个空列表。
 *所有单词具有相同的长度。
 *所有单词只由小写字母组成。
 *字典中不存在重复的单词。
 *你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 *
 */
public class Ex126 {
    private Map<String, Integer> map;
    private ArrayList<String> ids;
    private ArrayList<ArrayList<Integer>> edges;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 搜索算法和回溯都可以
        map = new HashMap<>();
        ids = new ArrayList<>();
        int id = 0;
        for (String item : wordList) {
            map.put(item, id);
            ids.add(item);
            id++;
        }
        var res = new ArrayList<List<String>>();
        if(!map.containsKey(endWord)){
            return res;
        }
        //add begin world
        map.put(beginWord, id++);
        ids.add(beginWord);

        //then we build the edges
        edges = new ArrayList<>(ids.size());
        for (int i = 0; i < ids.size(); i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.size(); i++) {
            for (int j = i+1; j < edges.size(); j++) {
                if(checkIsPass(ids.get(i), ids.get(j))){
                    edges.get(i).add(j);
                    edges.get(j).add(i);
                }
            }
        }
        // then bfs
        int endId = map.get(endWord);
        int[] cost = new int[ids.size()];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[map.get(beginWord)] = 0;
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        var temp = new ArrayList<Integer>();
        temp.add(map.get(beginWord));
        queue.offer(temp);
        while(!queue.isEmpty()){
            var now = queue.poll();
            int last = now.get(now.size()-1);
            if(last==endId){
                var t = new ArrayList<String>();
                for (Integer integer : now) {
                    t.add(ids.get(integer));
                }
                res.add(t);
            }else{
                for (int i = 0; i < edges.get(last).size(); i++) {
                    int toP = edges.get(last).get(i);
                    //路径的回退会在这里被解决
                    //回退会导致cost[toP] < cost[last]
                    //同样地，路径不是最短的，也会在此被抛弃
                    if(cost[last]+1<=cost[toP]){
                        cost[toP] = cost[last]+1;
                        var t = new ArrayList<>(now);
                        t.add(toP);
                        queue.offer(t);
                    }
                }
            }
        }
        return res;
    }

    private boolean checkIsPass(String s, String t) {
        int c = 0;
        int i = 0;
        int j = 0;
        final var ss = s.toCharArray();
        final var tt = t.toCharArray();
        final int len = s.length();
        while(i<len){
            if(ss[i]!=tt[j]){
                c++;
            }
            i++;
            j++;
        }
        return c==1;
    }
}