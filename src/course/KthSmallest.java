package course;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        //binary search
        int len = matrix.length;
        int l = matrix[0][0];
        int r = matrix[len-1][len-1];
        while(l<r){
            int mid = (l+r)/2;
            if(helper(matrix, len, mid, k)){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }
    private boolean helper(int[][] matrix, int n, int target, int k){
        int count = 0;
        int i = n-1;
        int j = 0;
        while(j<n&&i>=0){
            if(matrix[i][j]<=target){
                count += i+1;
                j++;
            }else{
                i--;
            }
        }
        return count>=k;
    }
}