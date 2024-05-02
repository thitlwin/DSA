package leetcode_problem_1137_tribonancci

class TriBonancci {
    fun tribonacci(n: Int): Int {
        if (n == 0 || n == 1) return n
        if (n == 2) return 1
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 1
        dp[2] = 1
        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        }
        return dp[n]
    }
}

fun main() {
    val obj = TriBonancci()
    println(obj.tribonacci(4))
}