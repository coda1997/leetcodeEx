package leetCode;

public class Ex79 {
    private boolean[][] visited;
    private char[][] board;
    private char[] word;
    private int[][] offset = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        this.board= board;
        this.word = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==this.word[0]&&helper(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, int k){
        if(board[i][j]!=word[k]){
            return false;
        }
        if(k == word.length-1){
            return true;
        }
        visited[i][j] = true;
        for (int k2 = 0; k2 < 4; k2++) {
            var ii = i+offset[k2][0];
            var jj = j+offset[k2][1];
            if(ii>=0&&ii<board.length&&jj>=0&&jj<board[ii].length){
                if(!visited[ii][jj]&&helper(ii, jj, k+1)){
                    visited[i][j] = false;
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        
    }
}
