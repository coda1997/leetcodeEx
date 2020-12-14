package leetCode;

import java.util.*;

public class Ex49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23,29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer, List<String>> map = new HashMap<>();
        int mod = 1000000007;
        for (String item : strs) {
            var cc = item.toCharArray();
            int hash = 1;
            for (char i: cc){
                hash = (hash * (primes[i - 'a'] % mod)) % mod;
            }
            var l = map.getOrDefault(hash,new ArrayList<>());
            l.add(item);
            map.put(hash, l);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        new Ex49().groupAnagrams(new String[]{"tin","ram","zip","cry","pus","jon","zip","pyx"});
    }
}
