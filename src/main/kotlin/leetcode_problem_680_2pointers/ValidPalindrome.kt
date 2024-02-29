package leetcode_problem_680_2pointers

class ValidPalindrome {

    fun validPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (s[l] != s[r]){
                return isPalindrome(s.substring(l + 1, r + 1)) or isPalindrome(s.substring(l, r))
//                return isPalindrome(s.substring(l, r))
            }
            l += 1
            r -= 1
        }
        return true
    }

    private fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (!s[l].equals(s[r], ignoreCase = true)) return false
            l++
            r--
        }
        return true
    }
}

fun main() {
    val obj = ValidPalindrome()
//    val res = obj.validPalindrome("cbbcc") // true

    val res = obj.validPalindrome("deeee") // true
//    val res = obj.validPalindrome("aba") // true
//    val res = obj.validPalindrome("gas54tsag")// false
//    val res = obj.validPalindrome("abca") // true
//    val res = obj.validPalindrome("abc") // false
    println(res)
}