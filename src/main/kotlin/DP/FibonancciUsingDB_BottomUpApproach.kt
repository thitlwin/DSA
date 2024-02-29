package DP

class FibonancciUsingDB_BottomUpApproach {
    fun fibonancci(n: Int): Int {
        if (n == 0 || n==1) return n
        val dp = IntArray(n+1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n){
            dp[i] = dp[i-1] + dp[i-2]
        }
        return dp[n]
    }
}

fun main() {
    val obj = FibonancciUsingDB_BottomUpApproach()
    println(obj.fibonancci(9))
}