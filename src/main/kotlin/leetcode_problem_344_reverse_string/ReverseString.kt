package leetcode_problem_344_reverse_string

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size - 1
        while(left < right) {
            var temp = s[right]
            s[right] = s[left]
            s[left] = temp
            left++
            right--
        }
    }
}