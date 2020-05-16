package course;

public class RowKItem {
    public int kthGrammar(int N, int K) {
        return helper(K)==-1?0:1;
    }
    
    private int helper(int k){
        if(k==1){
            return -1;
        }
        if(k==2){
            return 1;
        }
        int temp = 1;
        while(temp*2<k){
            temp *=2;
        }
        return -helper(k-temp);
    }

    public static void main(String[] args) {
        System.out.println( new RowKItem().kthGrammar(3, 3));
    }
}