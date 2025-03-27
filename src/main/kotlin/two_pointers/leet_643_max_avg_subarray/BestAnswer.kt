package two_pointers.leet_643_max_avg_subarray

import kotlin.math.max

class BestAnswer {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var max = -Double.MAX_VALUE
        var sum = 0.0
        for (i in nums.indices) {
            sum += nums[i]
            if (i >= k)
                sum -= nums[i-k]
            if (i >= k - 1) {
                max = max(max, sum/k)
            }
        }
        return max
    }
}

fun main() {
    val obj = BestAnswer()
    println(obj.findMaxAverage(intArrayOf(1,12,-5,-6,50,3), 4))
}