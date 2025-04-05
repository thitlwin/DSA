package two_pointers.prefix_sum.leet_303_range_sum_query

class RangeSumQuery_PrefixSumApproach(nums: IntArray) {
    val hm: HashMap<Int, Int> = HashMap()

    init {
        var prefixSum = nums[0]
        hm[-1] = 0
        hm[0] = prefixSum
        for (i in 1 until  nums.size) {
            prefixSum += nums[i]
            hm[i] = prefixSum
        }
    }
    fun sumRange(left: Int, right: Int): Int {
        return hm[right]!! - hm[left-1]!!
    }
}

fun main() {
    val obj = RangeSumQuery_PrefixSumApproach(intArrayOf(-2,0,3,-5,2,-1))
    println(obj.sumRange(0,2))
}