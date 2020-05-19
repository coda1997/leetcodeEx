package course;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length; // usually equals 9;
        var t = new boolean[len];
        for(int i =0;i<len;i++){
            t[i] =false;
        }
        //check rows, cols, and 3*3 sub-squra respectively.
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    if(t[board[i][j]-'1']){
                        return false;
                    }else{
                        t[board[i][j]-'1'] = true;
                    }
                }
            }
            for(int index =0;index<len;index++){
                t[index] =false;
            }
        }
        // check cols
        for(int j = 0;j<len;j++){
            for(int i = 0;i<len;i++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    if(t[board[i][j]-'1']){
                        return false;
                    }else{
                        t[board[i][j]-'1'] = true;
                    }
                }
            }
            for(int index =0;index<len;index++){
                t[index] =false;
            }
        }
        //check sub
        for(int i = 0;i<len;i+=3){
            for(int j = 0;j<len;j+=3){
                //(i, j) is a vertax of a sub-squra
                int m;
                int n;
                for(int c= 0;c<len;c++){
                    m = c/3+i;
                    n = c%3+j;
                    if(board[m][n]=='.'){
                        continue;
                    }else{
                        if(t[board[m][n]-'1']){
                            return false;
                        }else{
                            t[board[m][n]-'1'] = true;
                        }
                    }                    
                }
                for(int index =0;index<len;index++){
                    t[index] =false;
                }
            }
            
        }
        return true;
    }
}