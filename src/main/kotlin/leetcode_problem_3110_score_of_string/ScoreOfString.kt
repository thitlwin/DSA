package leetcode_problem_3110_score_of_string

import kotlin.math.abs

class ScoreOfString {
    fun scoreOfString(s: String): Int {
        var result = 0
        var first = 0
        var second = 1
        while(second < s.length) {
            result += abs(s[first].code - s[second].code)
            first++
            second++
        }
        return result
    }
}

fun main() {
    val obj = ScoreOfString()
    val res = obj.scoreOfString("hello")
    println(res)
}