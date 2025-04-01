package DP.leet_2140_questions_with_brainpower

import kotlin.math.max

//fun mostPoints(questions: Array<IntArray>): Long {
//    val n = questions.size
//    val dp = LongArray(n + 1)  // dp[i] stores the max points from index i to end
//
//    for (i in n - 1 downTo 0) {
//        val (points, brainPower) = questions[i]
//        val nextIndex = i + brainPower + 1
//        dp[i] = max(points + if (nextIndex < n) dp[nextIndex] else 0, dp[i + 1])
//    }
//
//    return dp[0]
//}
class SolvingQuestionWithBrainPower_BottomUp {
    fun mostPoints(questions: Array<IntArray>): Long {
        val n = questions.size
        val dp = LongArray(n + 1)
        for (i in n-1 downTo 0){
            val (points, brainPower) = questions[i]
            val nextIndex = i + brainPower + 1
            dp[i] = max(points + if(nextIndex < n) dp[nextIndex] else 0, dp[i+1])
        }
        return dp[0]
    }
}
fun main() {
    val obj = SolvingQuestionWithBrainPower_BottomUp()
    println(obj.mostPoints(arrayOf(intArrayOf(3,2), intArrayOf(4,3), intArrayOf(4,4), intArrayOf(2,5))))
}