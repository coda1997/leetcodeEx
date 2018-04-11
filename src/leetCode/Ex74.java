package leetCode;

public class Ex74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0) return false;
//        if (matrix[0].length==1) return matrix[0][0]==target;
        int l = 0,r = matrix.length-1;
        while (l<=r){
            int t = (l+r)/2;
            if (matrix[t][0]>target){
                r=t-1;
            }else if (matrix[t][0]<target){
                l = t+1;
            }else return true;
        }
        l--;
        if (l<0) return false;
        r=matrix[l].length-1;
        int ll = 0;
        while (ll<=r){
            int t = (ll+r)/2;
            if (matrix[l][t]>target){
                r=t-1;
            }else if (matrix[l][t]<target){
                ll=t+1;
            }else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Ex74 ex74 = new Ex74();
        System.out.println(ex74.searchMatrix(new int[][]{{1}, {3}}, 3));
    }
}
