package course;
/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 
 * 注意：
 * 
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * 
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        var c1 = num1.toCharArray();
        var c2 = num2.toCharArray();
        int i = c1.length - 1;
        int j = c2.length - 1;
        int[] res = new int[Math.max(i, j) + 2];
        int k = res.length - 1;
        int up = 0;
        while (i >= 0 && j >= 0) {
            res[k] = (c1[i]-'0' + c2[j]-'0' + up) % 10;
            up = (c1[i]-'0' + c2[j]-'0' + up) / 10;
            i--;
            j--;
            k--;
        }
        while (i >= 0) {
            res[k] = (c1[i]-'0' + up) % 10;
            up = (c1[i]-'0' + up) / 10;
            i--;
            k--;
        }
        while (j >= 0) {
            res[k] = (c2[j]-'0' + up) % 10;
            up = (c2[j]-'0' + up) / 10;
            j--;
            k--;
        }
        if (up > 0) {
            res[k] = up;
            k--;
        }
        var resbuiler = new StringBuilder();
        k++;
        while (k < res.length) {
            resbuiler.append(res[k++]);
        }
        return resbuiler.toString();
    }
}