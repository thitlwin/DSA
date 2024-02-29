package DP

import kotlin.math.max

class FestivalGame {
    fun festivalGame(target: List<Int>): Long {
        val dp = Array(target.size){ LongArray(target.size) }
        return f(0, target.size - 1, dp, target)
    }

    private fun f(left: Int, right: Int, dp: Array<LongArray>, target: List<Int>): Long {
        if (left > right)
            return 0
        if (dp[left][right] != 0L)
            return dp[left][right]

        for (i in left..right){
            val leftInterval = f(left, i-1, dp, target)
            val rightInterval = f(i+1, right, dp, target)
            val leftMultiplier = if(left == 0) 1 else target[left-1]
            val rightMultiplier = if(right == target.size-1) 1 else target[right + 1]
            val value = leftMultiplier * target[i] * rightMultiplier
            dp[left][right] = max(dp[left][right], leftInterval + rightInterval + value)
        }
        return dp[left][right]
    }
}

fun main() {
    val obj = FestivalGame()
//    println(obj.festivalGame(listOf(3,1,5,8)))// 167
    println(obj.festivalGame(listOf(1,5)))//10
//    println(obj.festivalGame(listOf(1,5,4)))// 30

}