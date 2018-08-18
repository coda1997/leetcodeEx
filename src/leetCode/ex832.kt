package leetCode

fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
    for(a in A){
        val len = a.size/2
        for (i in 0 until len){
            swap(a,i,a.size-i-1)
        }
        for (i in 0 until a.size){
            if (a[i]==0){
                a[i]=1
            }else{
                a[i]=0
            }
        }
    }
    return A
}

fun swap(array:IntArray,l:Int,r:Int){
    val temp = array[r]
    array[r]=array[l]
    array[l]=temp
}

fun main(args: Array<String>) {
    val a = arrayOf(intArrayOf(1,1,0), intArrayOf(1,0,1), intArrayOf(0,0,0))
    flipAndInvertImage(a)
    a.forEach { it.forEach(::print);println() }
}