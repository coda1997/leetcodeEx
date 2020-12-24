package leetCode;

public class Ex135 {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        candys[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            } else {
                candys[i] = 1;
            }
        }

        int res = 0;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candys[i] = candys[i + 1] + 1 > candys[i] ? (candys[i + 1] + 1) : candys[i];
            }
            res += candys[i + 1];
        }
        res += candys[0];
        return res;
    }

    public int candy2(int[] ratings) {
        int res = 0;
        if(ratings.length<1){
            return res;
        }
        int inc = 1, dec = 0, pre = 1;
        res+=1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i]==ratings[i-1]?1:pre+1;
                res += pre;
                inc = pre;
            }else {
                dec++;
                if (inc == dec) {
                    dec++;
                }
                pre=1;
                res+=dec;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex135();
        System.out.println(o.candy2(new int[]{1, 3, 2, 2, 1}));
    }

}
