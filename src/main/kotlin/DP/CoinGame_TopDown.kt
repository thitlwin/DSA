package DP

import kotlin.math.min

class CoinGame_TopDown {
    fun coinGame(coins: List<Int>): Int {
        val n = coins.size
        val dp = Array(n + 1) { IntArray(n + 1) }
        val prefixSum = IntArray(n + 1)
        prefixSum[0] = 0
        for (i in 1..n) {
            prefixSum[i] = prefixSum[i - 1] + coins[i - 1]
        }
        return maxScore(dp, prefixSum, 1, n)
    }

    private fun maxScore(dp: Array<IntArray>, prefixSum: IntArray, left: Int, right: Int): Int {
        if (dp[left][right] != 0) {
            return dp[left][right]
        }
        val sum = prefixSum[right] - prefixSum[left - 1]
        if (left == right)
            dp[left][right] = sum
        else {
            val leftPick = maxScore(dp, prefixSum, left+1, right)
            val rightPick = maxScore(dp, prefixSum, left, right-1)
            dp[left][right] = sum - min(leftPick, rightPick)
        }
        return dp[left][right]
    }
}

fun main() {
    val obj = CoinGame_TopDown()
    println(obj.coinGame(listOf(3, 2, 10, 4)))//13
    println(obj.coinGame(listOf(4, 4, 9, 4)))//13
    println(obj.coinGame(listOf(5, 3, 4, 5))) // 9
    println(obj.coinGame(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0))) // 55
}