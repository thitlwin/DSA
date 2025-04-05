package two_pointers.prefix_sum.leet_560_sub_arr_sum

class SubArrSumEqualsK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var curSum = 0
        val hm: HashMap<Int, Int> = hashMapOf()
        hm[0] = 1
        var count = 0
        nums.forEach {
            curSum += it
            val complement = curSum - k
            if(hm.containsKey(complement)) {
                count += hm[complement]!!
            }
            if(hm.containsKey(curSum)) {
                hm[curSum] = hm[curSum]!! + 1
            } else {
                hm[curSum] = 1
            }
        }
        return count
    }
}

fun main() {
    val obj = SubArrSumEqualsK()
//    println(obj.subarraySum(intArrayOf(1,1,1), 2)) //2
//    println(obj.subarraySum(intArrayOf(1,2,3), 3))//2
    println(obj.subarraySum(intArrayOf(1,-1,0), 0))//3

}