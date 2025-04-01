package DP.leet_2140_questions_with_brainpower

import kotlin.math.max

class SolvingQuestionWithBrainPower_TopDown {

    fun mostPoints(questions: Array<IntArray>): Long {
        return dfs(index = 0, memo = LongArray(questions.size), questions = questions)
    }

    private fun dfs(index: Int, memo: LongArray, questions: Array<IntArray>): Long {
        if (index >= questions.size){
            return 0
        }
        if (memo[index] > 0) {
            return memo[index]
        }
        val (points, brainPower) = questions[index]
        memo[index] = max(points + dfs(index + brainPower + 1, memo, questions),
            dfs(index + 1, memo, questions))
        return memo[index]
    }
}

fun main() {
    val obj = SolvingQuestionWithBrainPower_TopDown()
    println(obj.mostPoints(arrayOf(intArrayOf(3,2), intArrayOf(4,3), intArrayOf(4,4), intArrayOf(2,5))))
}