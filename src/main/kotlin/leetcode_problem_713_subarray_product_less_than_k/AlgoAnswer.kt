package leetcode_problem_713_subarray_product_less_than_k

class AlgoAnswer {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var count = 0
        var start = 0
        var product = 1
        for (end in nums.indices) {
            product *= nums[end]
            while (start <= end && product >= k) {
                product /= nums[start++]
            }
            count += end - start + 1
        }
        return count
    }
}

fun main() {
    val obj = AlgoAnswer()
//    println(obj.numSubarrayProductLessThanK(intArrayOf(10,5,2,6), 100))
//    println(obj.numSubarrayProductLessThanK(intArrayOf(1,1,1), 2))
    println(obj.numSubarrayProductLessThanK(intArrayOf(1,2,3), 0))
}