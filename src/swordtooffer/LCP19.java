package swordtooffer;
/**
 * LCP 19. 秋叶收藏集
 * 
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 
 * 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。
 * 每部分树叶数量可以不相等，但均需大于等于 1。
 * 每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。
 * 请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 */
public class LCP19 {
    public int minimumOperations(String leaves) {
        var cc = leaves.toCharArray();
        int len = cc.length;
        int d0 = cc[0] == 'y' ? 1 : 0;
        int d1 = Integer.MAX_VALUE;
        int d2 = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            if (i > 1) {
                d2 = Math.min(d1, d2) + (cc[i] == 'y' ? 1 : 0);
            }
            d1 = Math.min(d0, d1) + (cc[i] == 'r' ? 1 : 0);
            d0 = d0 + (cc[i] == 'y' ? 1 : 0);
        }
        return d2;
    }
}