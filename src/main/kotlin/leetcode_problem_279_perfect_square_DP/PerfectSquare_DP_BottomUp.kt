package leetcode_problem_279_perfect_square_DP

import kotlin.math.min
import kotlin.math.sqrt

class PerfectSquare_DP_BottomUp {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n +1)
        dp[0] = 0
        for (i in 1..n){
            dp[i] = i
            var j = 1
            while (j * j <= i){
                val curr = 1 + dp[i - j*j]
                dp[i] = min(dp[i], curr)
                j++
            }
        }
        return dp[n]
    }
}

fun main() {
    val obj = PerfectSquare_DP_BottomUp()
    println(obj.numSquares(5))
    println(obj.numSquares(12))
}