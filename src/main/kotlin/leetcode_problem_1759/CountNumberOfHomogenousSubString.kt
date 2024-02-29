package leetcode_problem_1759

import kotlin.math.pow

class CountNumberOfHomogenousSubString {
    var ans = 0
    var currentStreak = 0
    val mod = 10.0.pow(9.0) + 7
    fun countHomogenous(s: String): Int {
        for(i in s.indices) {
            if (i == 0 || s[i] == s[i-1])
                currentStreak++
            else
                currentStreak = 1
            ans = ((ans + currentStreak) % mod).toInt()
        }
        return ans
    }
}

fun main() {
    val obj = CountNumberOfHomogenousSubString()
    println(obj.countHomogenous("abbcccaa"))
}
