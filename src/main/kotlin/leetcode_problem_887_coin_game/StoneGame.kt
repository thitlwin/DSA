package leetcode_problem_887_coin_game

import java.lang.Integer.max

class StoneGame {
    fun stoneGame(piles: IntArray): Boolean {
        var myScore = 0
        var opponentScore = 0
        var isMyTurn = true
        var left = 0
        var right = piles.size - 1
        while(left <= right ){
            if(isMyTurn){
                isMyTurn = false
                myScore += max(piles[left], piles[right])
            } else {
                isMyTurn = true
                opponentScore += max(piles[left], piles[right])
            }
            if (piles[left] > piles[right]){
                left++
            } else {
                right--
            }
        }
        return myScore > opponentScore
    }
}

fun main() {
    val obj = StoneGame()
//    println(obj.stoneGame(intArrayOf(3,7,2,3)))
    println(obj.stoneGame(intArrayOf(3,2,10,4)))
}