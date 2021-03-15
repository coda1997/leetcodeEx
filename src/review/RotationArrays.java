package review;

public class RotationArrays {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        //reverse the array
        //find the Kth index k
        //reverse [0,k) and [k,len);
        K = K%A.length;
        swap(A, 0, A.length-1);
        swap(A, 0, K-1);
        swap(A, K, A.length-1);
        return A;
    }

    private void swap(int[] A, int i, int j) {
        while (i < j) {
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
            i++;
            j--;
        }
    }
}
