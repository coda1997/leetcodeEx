package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        var res = new int[puzzles.length];
        boolean[] ps = new boolean[26];
        boolean[][] ws = new boolean[words.length][26];
        distinct(words, ws);
        for (int i = 0; i < puzzles.length; i++) {
            String puzzle = puzzles[i];
            for (char c :
                    puzzle.toCharArray()) {
                ps[c - 'a'] = true;
            }
            for (int j = 0; j < words.length; j++) {
                if (check(ws[j], puzzle, ps)) {
                    res[i]++;
                }
            }
            Arrays.fill(ps, false);
        }
        var ress = new ArrayList<Integer>(puzzles.length);
        for (int i = 0; i < res.length; i++) {
            ress.add(res[i]);
        }
        return ress;
    }

    private void distinct(String[] words, boolean[][] ws){
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            for (char w :
                    word.toCharArray()) {
                int i = 0;
                if (!ws[j][w-'a']){
                    ws[j][w-'a']=true;
                    i++;
                }
                if (i==26){
                    break;
                }
            }
        }
    }

    private boolean check(boolean[] ws, String puzzle, boolean[] ps){
        int head = puzzle.charAt(0)-'a';
        boolean checkHead = false;
        for (int i = 0; i < ws.length; i++) {
            if (!ws[i]) {
                continue;
            }
            if (!ps[i]) {
                return false;
            } else {
                if (i == head) {
                    checkHead = true;
                }
            }
        }
        return checkHead;
    }

    public static void main(String[] args) {
        var o = new Ex1178();
        //bitmask
        //if use array, tle
//        System.out.println(o.findNumOfValidWords(new String[]{"aaaa", "asas"}, new String[]{"aboveyz"}));
        System.out.println(o.findNumOfValidWords(new String[]{"kkaz","kaaz","aazk","aaaz","abcdefghijklmnopqrstuvwxyz","kkka","kkkz","aaaa","kkkk","zzzz"}, new String[]{"kazxyuv"}));
    }
}
