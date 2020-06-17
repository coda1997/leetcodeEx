package course;


public class SolveSurround {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='O'){
                    if(isSur(board, i, j)){
                        fillO(board, i, j);
                    }
                }
            }
        }
    }
    private void fillO(char[][] board, int i, int j){
        boolean[][] isvisted = new boolean[board.length][board[0].length];
        fillO(board, i, j, isvisted);
    }
    private void fillO(char[][] board, int i, int j, boolean[][] isvisited){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='X'||isvisited[i][j]){
            return;
        }
        isvisited[i][j]=true;
        board[i][j]='X';
        fillO(board, i+1, j,isvisited);
        fillO(board, i-1, j,isvisited);
        fillO(board, i, j+1,isvisited);
        fillO(board, i, j-1,isvisited);
    }
    private boolean isSur(char[][] board, int i, int j){
        boolean[][] isvisted = new boolean[board.length][board[0].length];
        return helper(board, i, j, isvisted);
    }
    private boolean helper(char[][] board,int i, int j, boolean[][] isvisited){
        if(i<0||i>=board.length||j<0||j>=board[0].length||isvisited[i][j]||board[i][j]=='X'){
            return true;
        }
        //board[i][j] awayls equals 'O'
        //only when the O on the board is not surrounded
        if(i==0||i==board.length-1||j==0||j==board[0].length-1){
            return false;
            
        }
        isvisited[i][j] = true;
        return helper(board, i+1, j, isvisited)
            &&helper(board, i-1, j, isvisited)
            &&helper(board, i, j+1, isvisited)
            &&helper(board, i, j-1, isvisited);
    }

    public static void main(String[] args) {
        new SolveSurround().solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
}