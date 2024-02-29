package two_pointers

import kotlin.math.min

class SlidingWindowShortest {
    fun subarraySumShortest(nums: List<Int>, target: Int): Int {
        var left = 0
        var length = nums.size
        var windowSum = 0
        for (right in nums.indices) {
            windowSum += nums[right]
            while (windowSum >= target) {
                windowSum -= nums[left]
                length = min(length, right - left + 1)
                left++
            }
        }
        return length
    }
}

fun main() {
    val obj = SlidingWindowShortest()
    val res = obj.subarraySumShortest(listOf(1, 4, 1, 7, 3, 0, 2, 5), 7)
    println(res)
}