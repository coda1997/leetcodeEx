package LeetCode

// the shitty problem, it's sick
fun myAtoi(str: String): Int {
    var res = 0
    var ptimes = false
    var plusTimes = 0
    var flag = 1
    loop@ for (c in str) {
        when (c) {
            ' ' ->{
                if(!ptimes&&plusTimes==0){
                    continue@loop
                }else{
                    break@loop
                }
            }
            '+'->{
               if (plusTimes++==0){
                   continue@loop
               } else{
                   return 0
               }
            }
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> {
                if(res<Int.MAX_VALUE&&(res*10+c.toInt()-48<0)){
                    if (flag==1){
                        return Int.MAX_VALUE
                    }else{
                        return Int.MIN_VALUE
                    }
                }
                ptimes=true
                res *= 10
                res += c.toInt()-48
            }
            '-' -> {
                if (plusTimes++==0){
                    flag=-1
                }else{
                    return 0
                }
            }
            else -> return res*flag

        }
    }

    return res*flag
}

fun main(args: Array<String>) {
    println('1'.toInt()-48)
    println(myAtoi(" - 321"))
}