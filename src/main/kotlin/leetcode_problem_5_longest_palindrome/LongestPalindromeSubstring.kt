package leetcode_problem_5_longest_palindrome

class LongestPalindromeSubstring {
    fun longestPalindrome(s: String): String {
        for (length in s.length downTo 0) {
            for (start in 0..s.length - length) {
                if (check(start, length + start, s)) {
                    return s.substring(start, length + start)
                }
            }
        }
        return ""
    }

    private fun check(start: Int, length: Int, s: String): Boolean {
        var left = start
        var right = length - 1
        while (left < right) {
            if (s[left] != s[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }
}

fun main() {
    val obj = LongestPalindromeSubstring()
    println(obj.longestPalindrome("bbbanana"))
}