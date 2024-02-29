package leetcode_problem_279_perfect_square_DP

import kotlin.math.min
import kotlin.math.sqrt

class PerfectSquare {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0
        val maxSquare = sqrt(n.toDouble()).toInt()
        for (i in 1..maxSquare) {
            val square = i * i
            for (j in square..n) {
                dp[j] = min(dp[j], dp[j - square] + 1)
            }
        }
        return dp[n]
    }
}

fun main() {
    val obj = PerfectSquare()
//    println(obj.numSquares(8))//2
    println(obj.numSquares(3))//3
    println(obj.numSquares(9))//1
    println(obj.numSquares(12))//3
//    println(obj.numSquares(1000))//2
//    println(obj.numSquares(10000))//1
}