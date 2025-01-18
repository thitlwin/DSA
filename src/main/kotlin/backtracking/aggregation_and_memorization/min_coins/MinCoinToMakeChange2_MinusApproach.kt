package backtracking.aggregation_and_memorization.min_coins

import kotlin.math.min

//import kotlin.math.min

class MinCoinToMakeChange2_MinusApproach {
    fun coinChange(coins: List<Int>, amount: Int): Int {
        val hm = IntArray(amount + 1) { -1 }
        return dfs(coins, amount, hm)
    }

    private fun dfs(coins: List<Int>, amount: Int, hm: IntArray): Int {
        if (amount == 0) {
            return 0
        }
        if (hm[amount] != -1) {
            return hm[amount]
        }
        var initialResult = Int.MAX_VALUE
        for (coin in coins) {
            val balance = amount - coin
            if (balance >= 0) {
                val result = dfs(coins, balance, hm)
                if (result == Int.MAX_VALUE) {
                    continue
                }
                initialResult = min(initialResult, result + 1)
            }
        }
        hm[amount] = initialResult
        return hm[amount]
    }
}


fun main() {
    val obj = MinCoinToMakeChange2_MinusApproach()
    println(obj.coinChange(listOf(5, 10, 50, 100, 200, 500, 1000), 1000))//1
    println(obj.coinChange(listOf(5, 10, 50, 100, 200, 500), 750))//3
    println(obj.coinChange(listOf(12, 2, 5), 11))//4
    println(obj.coinChange(listOf(1, 2, 5), 11))//3
    println(obj.coinChange(listOf(186, 419, 83, 408), 6249))//20
}