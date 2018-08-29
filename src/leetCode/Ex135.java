package leetCode;

public class Ex135 {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        candys[0]=1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1]){
                candys[i]=candys[i-1]+1;
            }else {
                candys[i]=1;
            }
        }

        int res=0;
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i]>ratings[i+1]){
                candys[i]=candys[i+1]+1>candys[i]?(candys[i+1]+1):candys[i];
            }
            res+=candys[i+1];
        }
        res+=candys[0];
        return res;
    }
}
