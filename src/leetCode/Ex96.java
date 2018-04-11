package leetCode;

public class Ex96 {
    public int numTrees(int n) {
        if (n==0||n==1) return n;
        int[] t = new int[n+1];
        t[0]=1;t[1]=1;
        //start from  2nd
        for (int i = 2;i<=n;i++){
            for (int j = 0;j<i;j++){
                t[i] += t[i-1-j]*t[j];
            }
        }
        return t[n];
    }

    public static void main(String[] args) {
        System.out.println(new Ex96().numTrees(3));
    }
}
