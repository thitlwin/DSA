package leetcode_problem_5_longest_palindrome

class LPS_with_DP_Bottom_Up_Approach1 {
    fun longestPalindrome(s: String): String {
        val n = s.length
        val dp = Array(n){BooleanArray(n)}
        val res = intArrayOf(0,0)
        for (i in 0 until n){
            dp[i][i] = true
        }
        for (i in 0 until n-1){
            if (s[i] == s[i+1]){
                dp[i][i+1] = true
                res[0] = i
                res[1] = i + 1
            }
        }

        for (diff in 2 until n){
            for (start in 0 until n-diff){
                val end = start + diff
                if (s[start] == s[end] && dp[start+1][end-1]){
                    dp[start][end] = true
                    res[0] = start
                    res[1] = end
                }
            }
        }
        return s.substring(res[0],res[1]+1)
    }
}

fun main() {
    val obj = LPS_with_DP_Bottom_Up_Approach1()
    println(obj.longestPalindrome("dabccbdbdbcc"))
}