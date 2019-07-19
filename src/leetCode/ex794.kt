package leetCode

fun validTicTacToe(board: Array<String>): Boolean {
    var nX = 0
    var nO = 0
    for (row in board){
        for (item in row){
            when(item){
                'O'->nO++
                'X'->nX++
                else-> return false
            }
        }
    }
    return when(checkWin(board)){
        0,2-> nX==nO+1
        1-> nX==nO
        else-> false
    }
}

fun checkWin(board: Array<String>):Int{
    //1. check row
    var rowWin = 0
    for (i in 0 ..2){
        val row = board[i]
        if(row=="XXX"||row=="OOO"){
            rowWin++
        }
        if ((board[0][i]==board[1][i])&&board[1][i]==board[2][i]){
            rowWin++
        }
    }
    if (board[0][0]==board[1][1]&&board[1][1]==board[2][2]){
        rowWin++
    }
    if (board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
        rowWin++
    }
    return when(rowWin){
        1->1

        else->-1
    }
}