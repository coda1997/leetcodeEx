package leetCode;

public class Ex72 {

    public int minDistance(String word1, String word2) {
        char[] w1= word1.toCharArray(),w2=word2.toCharArray();
        int[][] t = new int[word1.length()+1][word2.length()+1];
        for (int i = 0;i<word1.length()+1;i++) t[i][0] = i;
        for (int i = 0;i<word2.length()+1;i++) t[0][i] = i;
        for (int r = 1;r<word1.length()+1;r++){
            for (int c = 1;c<word2.length()+1;c++){
                if (w1[r-1]==w2[c-1]){
                    t[r][c]=t[r-1][c-1];
                }else {
                    t[r][c] = Math.min(t[r-1][c-1],Math.min(t[r][c-1],t[r-1][c]))+1;
                }
            }
        }
        return t[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Ex72().minDistance("a","a"));
    }
}
