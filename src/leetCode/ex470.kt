package leetCode
fun rand7():Int{
    return 0
}

fun rand10(): Int {
    val t = (rand7()-1)*7+ rand7()-1
    return if (t<40){
        (t%10)+1
    }else{
        rand10()
    }
}