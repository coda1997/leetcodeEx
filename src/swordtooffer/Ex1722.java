package swordtooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex1722 {
    private HashMap<String, Queue<String>> map;
    private List<String> res;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }
        map = new HashMap<>();
        for (String item : wordList) {
            if (!map.containsKey(item)) {
                map.put(item, new LinkedList<>());
            }
            var cc = item.toCharArray();
            for (String item2 : wordList) {
                if (item.equals(item2)) {
                    continue;
                }
                if (check(cc, item2.toCharArray())) {
                    map.get(item).offer(item2);
                }
            }
        }
        var temp = new LinkedList<String>();
        var cc = beginWord.toCharArray();
        for (String string : wordList) {
            if (check(cc, string.toCharArray())) {
                temp.offer(string);
            }
        }
        map.put(beginWord, temp);
        // DFS
        dfs(beginWord, endWord);

        return res;

    }

    private boolean dfs(String cur, String endWrod) {
        if (cur.equals(endWrod)) {
            res.add(cur);
            return true;
        }
        var t = map.get(cur);
        while (!t.isEmpty()) {
            var item = t.poll();
            map.get(item).remove(cur);
            if (dfs(item, endWrod)) {
                res.add(0, cur);
                return true;
            }
        }
        return false;
    }

    private boolean check(char[] i, char[] j) {
        int t = 0;
        for (int k = 0; k < j.length; k++) {
            if (t > 1) {
                return false;
            }
            if (i[k] != j[k]) {
                ++t;
            }
        }
        return t == 1;
    }

}
