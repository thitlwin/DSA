package DP

import kotlin.math.min

class CoinGame {
    fun coinGame(coins: List<Int>): Int {
        val n = coins.size
        val prefixSum = ArrayList<Int>()
        prefixSum.add(0)
        for (i in 1..n){
            prefixSum.add(prefixSum[i-1] + coins[i-1])
        }
        return maxScore(prefixSum, 1, n)
    }

    private fun maxScore(coins: List<Int>, left: Int, right: Int): Int {
        val sum = coins[right] - coins[left-1]

        if (left == right) return sum

        val leftPick = maxScore(coins, left + 1, right)
        val rightPick = maxScore(coins, left, right-1)
        return sum - min(leftPick, rightPick)
    }
}

fun main() {
    val obj = CoinGame()
//    println(obj.coinGame(listOf(3,2,10,4)))//13
//    println(obj.coinGame(listOf(4,4,9,4)))//13
    println(obj.coinGame(listOf(5 ,3 ,4 ,5))) // 9
//    println(obj.coinGame(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 9, 8 ,7 ,6 ,5, 4, 3, 2, 1, 0))) // 55
}