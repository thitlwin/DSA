package leetcode_problem_2962_subarray_count

import kotlin.math.max

class SubArrayCountWhereMaxIsAtLeastK {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var maxElement = 0
        nums.forEach {
            maxElement = max(maxElement, it)
        }
        var left = 0
        var result = 0
        while (left < nums.size) {
            var maxCount = 0
            for (right in left until nums.size) {
                if (nums[right] == maxElement) {
                    maxCount++
                }
                if (maxCount >= k) {
                    result++
                }
            }
            left++
        }
        return result.toLong()
    }
}
// Time Limit Exceed