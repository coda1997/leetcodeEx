package review;

public class MissingArray {
    public int solution(int[] A) {
        // write your code in Java SE 8
        //map all numbers-1 to its position
        int[] temp = new int[A.length+1];
        temp[0] = -1;
        int p =0;
        while (p<A.length){
            temp[A[p]-1] = A[p]-1;
            p++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != i) {
                return temp[i]+1;
            }
        }
        return -1;
    }


}
