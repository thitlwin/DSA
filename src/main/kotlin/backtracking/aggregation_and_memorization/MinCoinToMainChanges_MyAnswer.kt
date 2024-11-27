package backtracking.aggregation_and_memorization

import kotlin.math.min

class MinCoinToMainChanges_MyAnswer {
    fun coinChange(coins: List<Int>, amount: Int): Int {
        val memo = IntArray(amount + 1) { -1 }
        val result = dfs(remainingBalance = amount, target = amount, coins, memo)
        return if (result == Int.MAX_VALUE) 0 else result
    }

    private fun dfs(remainingBalance: Int, target: Int, coins: List<Int>, memo: IntArray): Int {
        if (remainingBalance == 0) return 0
        if (remainingBalance < 0) return Int.MAX_VALUE
        if (memo[remainingBalance] != -1) return memo[remainingBalance]
        var ans = Int.MAX_VALUE
        for (edge in coins) {
            val result = dfs(remainingBalance - edge, target, coins, memo)
            if (result == Int.MAX_VALUE)
                continue
            ans = min(ans, result + 1)
        }
        memo[remainingBalance] = ans
        return ans
    }
}

fun main() {
    val obj = MinCoinToMainChanges_MyAnswer()
//        println(obj.coinChange(listOf(5,10,50,100,200,500, 1000), 1000))//1
//    println(obj.coinChange(listOf(5,10,50,100,200,500), 750))//3
    println(obj.coinChange(listOf(12,2,5), 11))//3
    println(obj.coinChange(listOf(1,2,5), 11))//3
//    println(obj.coinChange(listOf(186 ,419, 83, 408), 6249))//20
}