package leetcode_problem_345_2pointers

class ReverseVowel {
    fun reverseVowels(s: String): String {
        val vowels = "aeiouAEIOU"
        val sb = StringBuilder(s)
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (s[l] !in vowels) {
                l++
            } else if (s[r] !in vowels) {
                r--
            } else {
                // swap
                sb.setCharAt(l, s[r])
                sb.setCharAt(r, s[l])
                l++
                r--
            }
        }
        return sb.toString()
    }
}

fun main() {
    val obj = ReverseVowel()
    val res = obj.reverseVowels("leetcode")
    println(res)
}