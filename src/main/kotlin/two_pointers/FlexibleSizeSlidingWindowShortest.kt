package two_pointers

import kotlin.math.min

class FlexibleSizeSlidingWindowShortest {
    fun subarraySumShortest(nums: List<Int>, target:Int): Int {
        var left = 0
        var windowSum = 0
        var answer = nums.size
        for (right in nums.indices) {
            windowSum += nums[right]
            while (windowSum >= target) {
                windowSum -= nums[left]
                answer = min(answer, right - left + 1)
                left++
            }
        }
        return answer
    }
}

fun main() {
    val obj = FlexibleSizeSlidingWindowShortest()
    println(obj.subarraySumShortest(listOf(1, 4, 1, 7, 3, 0, 2, 5), 10))
}