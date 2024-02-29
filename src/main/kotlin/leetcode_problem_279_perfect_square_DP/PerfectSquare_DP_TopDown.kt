package leetcode_problem_279_perfect_square_DP

import kotlin.math.sqrt

class PerfectSquare_DP_TopDown {
    fun numSquares(n: Int): Int {
        val memo = IntArray(n+1){-1}
        return helper(n, memo)
    }

    private fun helper(n: Int, memo: IntArray): Int{
        if (n==0) return 0
        if(memo[n] != -1) return memo[n]
        var min = Int.MAX_VALUE
        val sqrtVal = sqrt(n.toDouble()).toInt()
        for (i in 1..sqrtVal){
            val cur = 1 + helper(n - i * i, memo)
            min = Math.min(min, cur)
        }
        memo[n] = min
        return memo[n]
    }
}

fun main() {
    val obj = PerfectSquare_DP_TopDown()
    println(obj.numSquares(5))
    println(obj.numSquares(12))
}