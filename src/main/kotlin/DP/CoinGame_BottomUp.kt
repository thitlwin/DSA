package DP

import kotlin.math.min

class CoinGame_BottomUp {
    fun coinGame(coins: List<Int>): Int {
        val n = coins.size
        val prefixSum = IntArray(n+1)
        prefixSum[0]=0
        for (i in 1..n)
            prefixSum[i]=prefixSum[i-1] + coins[i-1]

        val dp = Array(n+1){ IntArray(n+1) }
        for (size in 0 until n){
            var l = 1
            while (l + size <= n){
                val r = l + size
                val sum = prefixSum[r] - prefixSum[l-1]
                if (l == r)
                    dp[l][r] = sum
                else {
                    dp[l][r] = sum - min(dp[l+1][r], dp[l][r-1])
                }
                l++
            }
        }
        return dp[1][n]
    }
}

fun main() {
    val obj = CoinGame_BottomUp()
//    println(obj.coinGame(listOf(3, 2, 10, 4)))//13
    println(obj.coinGame(listOf(4, 4, 9, 4)))//13
//    println(obj.coinGame(listOf(5, 3, 4, 5))) // 9
//    println(obj.coinGame(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0))) // 55
}