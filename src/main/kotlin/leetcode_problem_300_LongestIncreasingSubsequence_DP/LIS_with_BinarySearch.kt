package leetcode_problem_300_LongestIncreasingSubsequence_DP

class LIS_with_BinarySearch {
    fun longestSubLen(nums: List<Int>): Int {
        val n = nums.size
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = -Int.MAX_VALUE
        for (i in 0 until n) {
            for (j in 1..n) {
                if (dp[j - 1] < nums[i] && nums[i] < dp[j]) {
                    dp[j] = nums[i]
                }
            }
        }
        var ans = 0
        for (i in 0..n) {
            if (dp[i] < Int.MAX_VALUE)
                ans = i
        }
        return ans
    }
}

fun main() {
    val obj = LIS_with_BinarySearch()
    val res = obj.longestSubLen(listOf(50, 3, 10, 7, 40, 80)) // 4
//    val res = obj.longestSubLen(listOf(0, 0, 1, 6, 0))//3
//    val res = obj.longestSubLen(listOf())//0
//    val res = obj.longestSubLen(listOf(0,1,0,3,2,3))//4
    println(res)
}