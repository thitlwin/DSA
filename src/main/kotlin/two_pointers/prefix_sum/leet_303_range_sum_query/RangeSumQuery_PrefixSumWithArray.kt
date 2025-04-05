package two_pointers.prefix_sum.leet_303_range_sum_query

class RangeSumQuery_PrefixSumWithArray(nums: IntArray) {
    val prefixSum: IntArray = IntArray(nums.size + 1)// Sc=O(n)
    init {
        for (i in nums.indices) {//O(n)
            prefixSum[i + 1] = prefixSum[i] + nums[i]
        }
    }
    fun sumRange(left: Int, right: Int): Int {//O(1)
        return prefixSum[right + 1] - prefixSum[left]
    }
}

fun main() {
    val obj = RangeSumQuery_PrefixSumWithArray(intArrayOf(-2,0,3,-5,2,-1))
    println(obj.sumRange(0,2))//1
    println(obj.sumRange(2,5)) //-1
    println(obj.sumRange(0,5)) //-3

}