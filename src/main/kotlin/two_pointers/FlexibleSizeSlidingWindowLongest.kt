package two_pointers

import kotlin.math.max

class FlexibleSizeSlidingWindowLongest {
    fun subarraySumLongest(nums: List<Int>, target:Int): Int {
        var windowSum = 0
        var left = 0
        var right = 0
        var result = 0
        for (right in nums.indices) {
            windowSum += nums[right]
            while (windowSum > target) {
                windowSum -= nums[left++]
            }
            result = max(result, right - left + 1)
        }
        return result
    }
}

fun main() {
    val obj = FlexibleSizeSlidingWindowLongest()
    println(obj.subarraySumLongest(listOf(1, 6, 3, 1, 2, 4, 5), 10))
}