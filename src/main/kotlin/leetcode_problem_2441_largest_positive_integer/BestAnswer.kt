package leetcode_problem_2441_largest_positive_integer

import java.util.*
import kotlin.math.abs

class BestAnswer {
    fun findMaxK(nums: IntArray): Int {
        nums.sort()
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            when {
                nums[left] + nums[right] > 0 -> right--
                nums[left] + nums[right] < 0 -> left++
                else -> return nums[right]
             }
        }
        return -1
    }
}