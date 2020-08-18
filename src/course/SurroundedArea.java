package course;


public class SurroundedArea {
    int len, m;
    public void solve(char[][] board) {
        len = board.length;
        if(len==0){
            return;
        }    
        m = board[0].length;
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, m-1);    
        }
        for (int i = 0; i < m; i++) {
            dfs(board, 0, i);
            dfs(board, len-1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='+'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    
    }

    private void dfs(char[][] board, int i, int j){
        if(i<0||i>=len||j<0||j>=m||board[i][j]!='O'||board[i][j]=='+'){
            return;
        }
        board[i][j] = '+';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }

}