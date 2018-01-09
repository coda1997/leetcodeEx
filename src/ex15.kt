private fun threeSum(nums: IntArray): List<List<Int>> {
    val table = HashMap<Int,Int>()
    val list = mutableListOf<List<Int>>()
    var useless = 0
    for((index,num) in nums.withIndex()){
        for(i in index until nums.size){
            if(table.containsKey((-num-nums[i]))){
//                list.add(listOf(num,nums[i],-num-nums[i]))

                list.add(listOf(1,2,3))
            }else{
                table.put(num,index)
            }
        }

    }
    return null!!
}

fun main(args: Array<String>) {
    for(i in 1 until  4){
        println(i)
    }
}
