package course;

import java.util.*;
/**
 * Leetcode 336 回文对
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串
 * 
 */
public class PalindromePairs {
    Map<String, Integer> indices;

    public List<List<Integer>> palindromePairs(String[] words) {
        indices = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            indices.put(new StringBuffer(words[i]).reverse().toString(), i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            var len1 = word.length();

            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }

                var word2 = words[j];
                var len2 = word2.length();

                if (len1 == len2) {
                    if (indices.getOrDefault(word2, -1) == i) {
                        res.add(List.of(i, j));
                    }
                } else if (len1 > len2) {
                    if (isPalindrome(word, len2, len1) && indices.getOrDefault(word.substring(0, len2), -1) == j) {

                        res.add(List.of(i, j));

                    }
                } else {
                    if (isPalindrome(word2, 0, len2 - len1)
                            && indices.getOrDefault(word2.substring(len2 - len1, len2), -1) == i) {

                        res.add(List.of(i, j));

                    }
                }

            }
        }

        return res;
    }

    private boolean isPalindrome(String s, int i, int j) {
        j--;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}