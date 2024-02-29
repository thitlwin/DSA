package leetcode_problem_5_longest_palindrome

class LPS_with_DP_BottomUp {
    fun longestPalindrome(s: String): String {
        val n = s.length
        val dp = Array(n) { BooleanArray(n) { true } }
        var startIdx = 0
        var maxLength = 1
        for (i in n - 2 downTo 0) { // from second last to first row
            for (j in i + 1 until n) { // from left to right
                dp[i][j] = false
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1]
                    if (dp[i][j] && maxLength < j - i + 1) {
                        maxLength = j - i + 1
                        startIdx = i
                    }
                }
            }
        }
        return s.substring(startIdx, startIdx+maxLength)
    }
}

fun main() {
    val obj = LPS_with_DP_BottomUp()
    println(obj.longestPalindrome("dabccbcc"))
}