package DP

class LongestSubsequence {
    fun longestSubLen(nums: List<Int>): Int {
        val n = nums.size
        val INFINITY = Int.MAX_VALUE
        val dp = IntArray(n+1)
        dp.fill(INFINITY)
        dp[0] = -INFINITY
        for (i in 0 until n){
            for (j in 1..n){
                if (dp[j-1] < nums[i] && nums[i] < dp[j]){
                    dp[j] = nums[i]
                }
            }
        }

        var ans = 0
        for (i in 0..n) {
            if (dp[i] < INFINITY)
                ans = i
        }
        return ans
    }
}

fun main() {
    val obj = LongestSubsequence()
    val res = obj.longestSubLen(listOf(20,1,2,10,8,30,40))
    println(res)
}