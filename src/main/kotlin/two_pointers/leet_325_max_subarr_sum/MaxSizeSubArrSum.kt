package two_pointers.leet_325_max_subarr_sum

import kotlin.math.max
//TC=O(n), SC=O(1)
class MaxSizeSubArrSum {
    fun maxSubArrayLen(nums: IntArray, k: Int): Int {
        var left = 0
        var sum = 0
        var result = 0
        for (right in nums.indices) {//O(n)
            sum += nums[right]
            while (sum > k){
                sum -= nums[left]
                left++
            }
            result = max(result, right - left + 1)
        }
        return result
    }
}

fun main() {
    val obj = MaxSizeSubArrSum()
    println(obj.maxSubArrayLen(intArrayOf(3, 4, -3, 2, 1), 3))
    println(obj.maxSubArrayLen(intArrayOf(1, 6, 3, 1, 2, 4, 5), 10))

}