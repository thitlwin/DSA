package leetcode_problem_409_longest_palindrome

class UsingSet {
    fun longestPalindrome(s: String): Int {
        val hSet = hashSetOf<Char>()
        var result = 0
        for (chr in s) {
            if (hSet.contains(chr))
            {
                hSet.remove(chr)
                result += 2
            } else {
                hSet.add(chr)
            }
        }
        if (hSet.isNotEmpty())
            result += 1
        return result
    }
}

fun main() {
    val obj = UsingSet()
    println(obj.longestPalindrome("bananas"))
}