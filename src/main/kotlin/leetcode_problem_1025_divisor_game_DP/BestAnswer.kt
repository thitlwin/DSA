package leetcode_problem_1025_divisor_game_DP

class BestAnswer {
    fun divisorGame(n: Int): Boolean {
        return n%2 == 0
    }

}

fun main() {
    val obj = BestAnswer()
    println(obj.divisorGame(2))//true
    println(obj.divisorGame(3))//false
    println(obj.divisorGame(4))//true
    println(obj.divisorGame(5))//false
}