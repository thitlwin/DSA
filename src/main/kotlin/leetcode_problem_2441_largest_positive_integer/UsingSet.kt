package leetcode_problem_2441_largest_positive_integer

import kotlin.math.max

class UsingSet {
    fun findMaxK(nums: IntArray): Int {
        var maxK = -1
        val numSet = nums.toSet()
        for (num in numSet) {
            if (numSet.contains(-num)) {
                maxK = max(maxK, num)
            }
        }
        return maxK
    }

}