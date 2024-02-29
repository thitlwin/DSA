package leetcode_problem_3_longest_substring

import kotlin.math.max
class BestAnswer1 {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = hashMapOf<Char,Int>()
        var left = 0
        var longest = 0
        for (right in s.indices){
            val ch = s[right]
            if (map.contains(ch)){
                longest = max(longest, right - left)
                left = max(left, map[ch]!!+1)
            }
            map[ch] = right
        }
        return maxOf(longest, s.length - left)
    }
}

fun main() {
    val obj = BestAnswer1()
    println(obj.lengthOfLongestSubstring("abcbacbaccc"))
}