package toys

fun isOdd(x:Int) = x%2 !=0
fun length(s:String) = s.length

fun <A,B,C> compose(f:(B)->C,g:(A)->B):(A)->C{
    return {x->f(g(x))}
}

val I = {x:Int->x}

fun add(x:Int,y:Int) = x+y

fun curryAdd(x:Int):(Int)->Int= {y-> add(x,y)}

class HTML{
    fun head(title:String="default"){
        println("HTML HEAD $title")
    }
    fun body(){
        println("HTML BODY")
    }
}
fun html(init:HTML.()->Unit):HTML{
    val html=HTML()
    html.init()
    return html
}
class TreeNode <T>constructor(var value:T){
    var left:TreeNode<T ?>?=null
    var right:TreeNode<T ?>?=null
}

inline fun <reified T > TreeNode<T>.findParentOfType():T?{
    var p = left
    while (p!=null && p !is T){
        p = p.left
    }
    return p as T ?
}

fun main(args: Array<String>) {
//    val oddLength = compose(::isOdd,::length)
//    val strings = listOf("a","ab","abc")
//    println(strings.filter(oddLength))
//    val printI = compose(::println, I)
//    var ints = intArrayOf(1, 2, 3)
//    ints.forEach(printI)
//    ints.map(curryAdd(2)).apply(::println)
    html {
        head("haha")
    }
}

