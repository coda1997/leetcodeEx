package course;

import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
public class RestoreAddress {
    public List<String> restoreIpAddresses(final String s) {
        var res = new ArrayList<String>();
        var times = 1;
        final var cc = s.toCharArray();
        if (cc.length < 4 || cc.length > 12) {
            return res;
        }
        for (int i = 1; i < 4; i++) {
            final var t = subAddress(cc, 0, i);
            if (t != null) {
                res.add(t);
            }
        }
        while (times < 4) {
            var templ = new ArrayList<String>();
            final var left = 4 - times;
            for (final String item : res) {
                final var i = item.length() - times + 1;
                if (cc.length - i < left || cc.length - i > left * 3) {
                    continue;
                }
                if (times < 3) {
                    for (int j = i + 1; j < i + 4 && j <= cc.length; j++) {
                        final var t = subAddress(cc, i, j);
                        if (t != null) {
                            templ.add(item + "." + t);
                        }
                    }
                } else {
                    final var t = subAddress(cc, i, cc.length);
                    if (t != null) {
                        templ.add(item + "." + t);
                    }
                }
            }
            res = templ;
            templ = null;
            times++;
        }
        return res;
    }

    private String subAddress(final char[] cc, int i, final int j) {
        int t = 0;
        if (cc[i] == '0' && j - i != 1) {
            return null;
        }
        while (i < j) {
            t = t * 10 + cc[i++] - '0';
        }
        if (t >= 0 && t <= 255) {
            return String.valueOf(t);
        } else {
            return null;
        }
    }
}