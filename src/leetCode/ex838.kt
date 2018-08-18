package leetCode

import java.lang.StringBuilder

fun pushDominoes(dominoes: String): String {
    if (dominoes.length<2) return dominoes
    if (dominoes.length==2){
        if (dominoes[0]=='.'||dominoes[1]=='.'){
            if (dominoes[0]=='R')
                return "RR"
            if (dominoes[1]=='L')
                return "LL"
        }
        return dominoes
    }
    var ints = dominoes.map {
        when(it){
            '.'->0
            'L'->-1
            else->1
        }
    }.toMutableList()
    var c: Boolean
    do {
        c=false
        val temp = mutableListOf<Int>().apply { addAll(ints) }
        if (ints[0]==0&&ints[1]==-1){
            temp[0]=-1
            c=true
        }
        if (ints[ints.size-1]==0&&ints[ints.size-2]==1){
            temp[ints.size-1]=1
            c=true
        }
        (1 until ints.size-1).forEach {
            if (ints[it]==0){
                if (ints[it-1]+ints[it+1]!=0){
                    if (ints[it-1]==1){
                        c=true
                        temp[it]=1
                    }else if (ints[it+1]==-1){
                        c=true
                        temp[it]=-1
                    }
                }
            }
        }
        ints=temp
    }while (c)
    return StringBuilder().apply {
        ints.forEach {
            when(it){
                1->append('R')
                -1->append('L')
                else->append('.')
            }
        }
    }.toString()

}

fun main(args: Array<String>) {
    pushDominoes(".L.R...LR..L..").apply { println(this) }
}