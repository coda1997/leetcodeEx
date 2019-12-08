fun subtractProductAndSum(n: Int): Int {
    var res1 = 1
    var res2 = 0
    var t = n
    var tt = 0
    while (t!=0){
        tt=t%10
        res1*=tt
        res2+=tt
        t/=10
    }
    return res1-res2
}

fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val t = HashMap<Int,MutableList<Int>>()
    for (i in groupSizes.indices){
        if (t.containsKey(groupSizes[i])){
            t[groupSizes[i]]?.add(i)
        }else{
            t[groupSizes[i]]= mutableListOf(i)
        }
    }
    val res = mutableListOf<List<Int>>()
    for(k in t.keys){
        var p = 0
        var pp = mutableListOf<Int>()
        for (e in t[k]!!){
            pp.add(e)
            p++
            if (p==k){
                res.add(pp)
                pp= mutableListOf()
                p=0
            }
        }
    }
    return res
}

fun smallestDivisor(nums: IntArray, threshold: Int): Int {
    val maxp = nums.sumBy { divide(it, threshold) }
    val minp = nums.sum()/threshold
    var p = 0
    for (i in minp .. maxp){
        if (i==0){
            continue
        }
        p = nums.sumBy { divide(it, i) }
        if (p<=threshold){
            return i
        }
    }
    return maxp
}

fun divide(a:Int,b:Int):Int{
    val t= a%b
    return if (t!=0){
        a/b+1
    }else{
        a/b
    }
}

fun main() {
    smallestDivisor(intArrayOf(1,2,5,9),6).apply { println(this) }
    smallestDivisor(intArrayOf(2,3,5,7,11),11).apply { println(this) }
    smallestDivisor(intArrayOf(19),5).apply { println(this) }
}