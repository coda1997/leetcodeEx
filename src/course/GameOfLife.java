package course;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = helper(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                var item = board[i][j];
                if (item > 9) {
                    item -= 9;
                    if (item < 2 || item > 3) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                } else {
                    if (item == 3) {
                        board[i][j] = 1;
                    }else{
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    private int helper(int[][] board, int i, int j) {
        int c = 0;
        if (i > 0) {
            c += board[i - 1][j]>8?1:0;
            if (j > 0) {
                c += board[i - 1][j - 1]>8?1:0;
            }
            if (j < board[i].length-1) {
                c += board[i - 1][j + 1]>8?1:0;
            }
        }
        if (i < board.length-1) {
            c += board[i + 1][j];
            if (j > 0) {
                c += board[i + 1][j - 1];
            }
            if (j < board[i].length-1) {
                c += board[i + 1][j + 1];
            }
        }
        if (j > 0) {
            c += board[i][j - 1]>8?1:0;
        }
        if (j < board[i].length-1) {
            c += board[i][j + 1];
        }
        if (board[i][j] == 1) {
            return c + 9;
        } else {
            return c;
        }
    }
    public static void main(String[] args) {
        var o = new GameOfLife();
        o.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}