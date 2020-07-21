package course;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if(n==0){
            return false;
        }
        int mid = 0;
        int s = 0, e = m;
        while (s < e) {
            mid = (s + e) / 2;
            if (matrix[mid][0] < target) {
                s = mid + 1;
            } else if (matrix[mid][0] > target) {
                e = mid;
            } else {
                return true;
            }
        }
        if (s < matrix.length && matrix[s][0] == target) {
            return true;
        }
        m = s;
        s = 0;
        e = n;
        while (s < e) {
            mid = (s + e) / 2;
            if (matrix[0][mid] > target) {
                e = mid;
            } else if (matrix[0][mid] < target) {
                s = mid + 1;
            } else {
                return true;
            }
        }
        if (s < matrix[0].length && matrix[0][s] == target) {
            return true;
        }
        n = s;
        int rowStart = 0;
        while (m > 0) {
            s = rowStart;
            e = n;
            while (s < e) {
                mid = (s + e) / 2;
                if (matrix[m - 1][mid] < target) {
                    s = mid + 1;
                } else if (matrix[m - 1][mid] > target) {
                    e = mid;
                } else {
                    return true;
                }
            }
            if (s < matrix[m - 1].length && matrix[m - 1][s] == target) {
                return true;
            }
            if (rowStart >= n) {
                return false;
            }
            rowStart = Math.max(mid - 1, 0);
            m--;
        }
        return false;
    }
}