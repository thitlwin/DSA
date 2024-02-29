package leetcode_problem_1025_divisor_game_DP

class DivisorGame {
    fun divisorGame(n: Int): Boolean {
       val dp = BooleanArray(n+1)
        for (i in 1..n){
            for (j in 1 until i){
                if (i%j == 0 && !dp[i-j]){
                    dp[i] = true
                    break
                }
            }
        }
        return dp[n]
    }
}

fun main() {
    val obj = DivisorGame()
//    println(obj.divisorGame(2))//true
//    println(obj.divisorGame(3))//false
//    println(obj.divisorGame(5))//false
    println(obj.divisorGame(4))//false

}