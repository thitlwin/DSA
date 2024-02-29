package leetcode_problem_300_LongestIncreasingSubsequence_DP

import kotlin.math.max

class LongestIncreasingSubsequence {
    fun longestSubLen(nums: List<Int>): Int {
        val dp = IntArray(nums.size) { 1 }
        var len = 0
        for (i in nums.indices) {
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], (dp[j] + 1))
                }
            }
            len = max(len, dp[i])
        }
        return len
    }
}

fun main() {
    val obj = LongestIncreasingSubsequence()
//    val res = obj.longestSubLen(listOf(50, 3, 10, 7, 40, 80)) // 4
//    val res = obj.longestSubLen(listOf(0, 0, 1, 6, 0))//3
    val res = obj.longestSubLen(listOf())//0
//    val res = obj.longestSubLen(listOf(0,1,0,3,2,3))//4
    println(res)
}