package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ex721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        var imap = new HashMap<String, Integer>();
        var nmap = new HashMap<String, String>();
        int temp = 0;
        for (var account :
                accounts) {
            var iterator = account.iterator();
            var name = iterator.next();
            while (iterator.hasNext()) {
                var email = iterator.next();
                if (!imap.containsKey(email)) {
                    imap.put(email, temp++);
                    nmap.put(email, name);
                }
            }
        }
        int[] parents = new int[temp];
        for (int i = 0; i < temp; i++) {
            parents[i] = i;
        }
        for (var account :
                accounts) {
            var iterator = account.iterator();
            var name = iterator.next();
            var firstEmail = find(parents, imap.get(iterator.next()));
            while (iterator.hasNext()) {
                var email = iterator.next();
                int i = find(parents, imap.get(email));
                union(parents, i, firstEmail);
                imap.put(email, firstEmail);
            }
        }

        var iToMails = new HashMap<Integer, List<String>>();
        for (var mail :
                imap.keySet()) {
            var ii = find(parents, imap.get(mail));
            var t = iToMails.getOrDefault(ii, new ArrayList<>());
            t.add(mail);
            iToMails.put(ii, t);
        }
        var res = new ArrayList<List<String>>();
        for (var mails :
                iToMails.values()) {
            Collections.sort(mails);
            var name = nmap.get(mails.get(0));
            var t = new ArrayList<String>();
            t.add(name);
            t.addAll(mails);
            res.add(t);
        }

        return res;
    }

    private int find(int[] parents, int i) {
        if (parents[i] != i) {
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }

    private void union(int[] parents, int i, int j) {
        int rootI = find(parents, i);
        int rootJ = find(parents, j);
        if (rootI == rootJ) {
            return;
        }
        parents[rootI] = rootJ;
    }
}
