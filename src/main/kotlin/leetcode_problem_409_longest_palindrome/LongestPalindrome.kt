package leetcode_problem_409_longest_palindrome

class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val hm = mutableMapOf<Char, Int>()
        var result = 0
        for (chr in s) {
            hm[chr] = hm.getOrDefault(chr, 0) + 1
        }
        var hasOddFrequency = false
        hm.forEach { (c, i) ->
            if (i % 2 == 0)
                result += i
            else {
                result += i - 1
                hasOddFrequency = true
            }
        }
        if (hasOddFrequency)
            result += 1
        return result
    }
}

fun main() {
    val obj = LongestPalindrome()
    println(obj.longestPalindrome("bananas"))
}
