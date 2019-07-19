package wzz

import leetCode.*


fun uniqueMorseRepresentations(words: Array<String>): Int {
    val restring = mutableSetOf<String>()
    val dict = listOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
    words.forEach { word->

        val stringBuilder = StringBuilder()
        word.toCharArray().forEach {
            val index = it.toInt()-97
            stringBuilder.append(dict[index])
        }

        restring.add(stringBuilder.toString())
    }
    return restring.size
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val res = mutableListOf<Int>()
    if (nums.isEmpty()){
        return res.toIntArray()
    }
    var max = findMax(nums, 0, k)
    res.add(max)
    if(nums.size==k){
        return res.toIntArray()
    }
    for(i in 0 until (nums.size-k)){
        val temp = nums[i+k]
        if(temp < max){
            if (max==nums[i]){
                max = findMax(nums, i+1,i+k+1)
            }
        }else{
            max = temp
        }
        res.add(max)
    }
    return res.toIntArray()
}
fun findMax(nums:IntArray, a:Int, b:Int):Int{
    var max = nums[a]
    for(i in a until b){
        max = Math.max(nums[i], max)
    }
    return max
}

fun main(args: Array<String>) {
    maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3).joinToString { "$it" }.apply { println(this) }
}