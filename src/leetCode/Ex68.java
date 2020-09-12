package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 
 * 说明:单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词
 * 
 */
public class Ex68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int c = 0;
        int rlen = 0;
        int ti = 0;
        for (int i = 0; i < words.length; i++) {
            var item = words[i];
            if (maxWidth < c + rlen + item.length()) {
                res.add(flatToWidth(words, ti, i, maxWidth, rlen));
                ti = i;

                c = 1;
                rlen = item.length();
            } else {
                c++;
                rlen += item.length();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words[ti]);
        for (int i = ti + 1; i < words.length; i++) {
            stringBuilder.append(" ").append(words[i]);
        }
        int tt = maxWidth - stringBuilder.length();
        for (int i = 0; i < tt; i++) {
            stringBuilder.append(" ");
        }
        res.add(stringBuilder.toString());
        return res;
    }

    // i is inclued, but j is exclued
    private String flatToWidth(String[] words, int i, int j, int maxWidth, int len) {
        StringBuilder stringBuilder = new StringBuilder();

        if (j - i == 1) {
            stringBuilder.append(words[i]);
            for (int k = 0; k < maxWidth - len; k++) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }

        var count = j - i;
        int width = (maxWidth - len) / (count - 1);
        int width2 = width + 1;
        int cw = width2;
        int offset = (maxWidth - len) % (count - 1);
        stringBuilder.append(words[i]);
        for (int k = i + 1; k < j; k++) {
            if (k - i > offset) {
                cw = width;
            }
            for (int k2 = 0; k2 < cw; k2++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(words[k]);
        }
        return stringBuilder.toString();
    }
}
