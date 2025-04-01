package two_pointers.leet_3_longest_substring

import kotlin.math.max

//def longest_substring_without_repeating_characters(s: str) -> int:
//n = len(s)
//longest = 0
//for start in range(n):
//for end in range(n):
//sub = s[start : end + 1]
//if len(set(sub)) == len(sub):
//longest = max(longest, end + 1 - start)
//return longest

class BruteForce {
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        var longest = 0
        for (left in s.indices){
            for (right in s.indices){
                val sub = s.substring(left, right+1)
                if (sub.toSet().size == sub.length){
                    longest = max(longest, right + 1 - left)
                }
            }
        }
        return longest
    }
}

fun main() {
    val obj = BruteForce()
    println(obj.lengthOfLongestSubstring("abcbacbaccc"))
}