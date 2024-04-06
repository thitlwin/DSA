package leetcode_problem_442_duplicate_arr

import kotlin.math.abs

class BestAnswerFromLeetCode {
    fun findDuplicates(nums: IntArray): List<Int> {
        val result = ArrayList<Int>()
        nums.forEach {
            val index = abs(it) - 1
            if (nums[index] < 0)
                result.add(abs(it))
            nums[index] *= -1
        }
        return result
    }
}

fun main() {
    val obj = BestAnswerFromLeetCode()
    val res = obj.findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))
    println(res.joinToString())
}