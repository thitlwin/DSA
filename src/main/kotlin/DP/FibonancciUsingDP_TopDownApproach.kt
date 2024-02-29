package DP

class FibonancciUsingDP_TopDownApproach {
    fun fibonancci(n: Int): Int {
        val memo = HashMap<Int, Int>()
        return fibonancciHelper(n, memo)
    }

    private fun fibonancciHelper(n: Int, memo: HashMap<Int, Int>): Int {
        if (n == 0 || n == 1)
            return n
        if (memo.containsKey(n))
            return memo[n]!!
        memo[n] = fibonancciHelper(n-1, memo) + fibonancciHelper(n-2, memo)
        return memo[n]!!
    }
}

fun main() {
    val obj = FibonancciUsingDP_TopDownApproach()
    println(obj.fibonancci(9))
}