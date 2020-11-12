package leetCode;

public class Ex922 {
    public int[] sortArrayByParityII(int[] A) {
        int ep = 0;
        int op = 1;
        int len = A.length;
        while(ep<len&&op<len){
            if((A[ep]&1)==0){
                ep += 2;
            }else{
                int temp = A[ep];
                A[ep] = A[op];
                A[op] = temp;
                op += 2;
            }
        }
        return A;
    }

    
}
