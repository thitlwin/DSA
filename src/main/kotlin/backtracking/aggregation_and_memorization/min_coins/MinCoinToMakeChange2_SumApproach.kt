package backtracking.aggregation_and_memorization.min_coins

import kotlin.math.min

class MinCoinToMakeChange2_SumApproach {
    fun coinChange(coins: List<Int>, amount: Int): Int {
        val hm = IntArray(amount + 1) { -1 }
        val result = dfs(coins, amount,sum = 0, hm)
        return if (result == Int.MAX_VALUE) -1 else result
    }

    private fun dfs(coins: List<Int>, amount: Int, sum: Int, memo: IntArray): Int {
        if (sum == amount) {
            return 0
        }
        if (sum > amount) {
            return Int.MAX_VALUE
        }
        if (memo[sum] != -1) {
            return memo[sum]
        }
        var ans = Int.MAX_VALUE
        for (coin in coins) {
            val result = dfs(coins, amount, sum + coin, memo)
            if (result == Int.MAX_VALUE) {
                continue
            }
            ans = min(ans, result + 1)
        }
        memo[sum] = ans
        return ans
    }
}


fun main() {
    val obj = MinCoinToMakeChange2_SumApproach()
//    println(obj.coinChange(listOf(5,10,50,100,200,500, 1000), 1000))//1
//    println(obj.coinChange(listOf(5,10,50,100,200,500), 750))//3
//    println(obj.coinChange(listOf(12, 2, 5), 11))//4
//    println(obj.coinChange(listOf(1, 2, 5), 11))//3
    println(obj.coinChange(listOf(186 ,419, 83, 408), 6249))//20
}