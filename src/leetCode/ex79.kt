package leetCode

fun exist(board: Array<CharArray>, word: String): Boolean {
    return existDFS(board,word, Array<BooleanArray>(board.size){BooleanArray(board[0].size){false}},-1,-1,0)
}

private fun existDFS(board: Array<CharArray>, word: String, used:Array<BooleanArray>,row:Int,col:Int,k:Int):Boolean{
    if (k==word.length){ return true }
    if (row==-1&&col==-1){
        for (i in 0 until board.size){
            for (j in 0 until board[i].size){
                if (word[k]==board[i][j]){
                    used[i][j]=true
                    if (existDFS(board, word, used, i, j, k + 1)) {
                        return true
                    }else{
                        used[i][j]=false
                    }
                }
            }
        }
        return false
    }
    if (isValid(row-1,col,board,used)&&board[row-1][col]==word[k]){
        used[row-1][col]=true
        if (existDFS(board,word,used,row-1,col,k+1)) return true
        used[row-1][col]=false
    }
    if (isValid(row+1,col,board,used)&&board[row+1][col]==word[k]){
        used[row+1][col]=true
        if (existDFS(board,word,used,row+1,col,k+1)) return true
        used[row+1][col]=false
    }
    if (isValid(row,col-1,board,used)&&board[row][col-1]==word[k]){
        used[row][col-1]=true
        if (existDFS(board,word,used,row,col-1,k+1)) return true
        used[row][col-1]=false
    }
    if (isValid(row,col+1,board,used)&&board[row][col+1]==word[k]){
        used[row][col+1]=true
        if (existDFS(board,word,used,row,col+1,k+1)) return true
        used[row][col+1]=false
    }
    return false
}
private fun isValid(row:Int,col: Int,board: Array<CharArray>,used: Array<BooleanArray>):Boolean{
    if (col==-1||row==-1) return false
    if (row==board.size||col==board[0].size) return false
    if (used[row][col]) return false
    return true
}
fun main(args: Array<String>) {
    exist(arrayOf("ABCD".toCharArray(),"CVBN".toCharArray()),"ABD").apply { println(this) }
}