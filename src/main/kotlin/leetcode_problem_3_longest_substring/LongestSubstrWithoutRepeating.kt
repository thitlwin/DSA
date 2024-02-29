package leetcode_problem_3_longest_substring

class LongestSubstrWithoutRepeating {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var longest = 0
        val window = HashMap<Char,Int>()
        for(right in s.indices) {
            window[s[right]] = window.getOrDefault(s[right],0) + 1
            while(window[s[right]]!! > 1){
                window[s[left]] = window[s[left]]!! - 1
                left++
            }
            longest = maxOf(longest, right-left+1)
        }
        return longest
    }
}

fun main() {
    val obj = LongestSubstrWithoutRepeating()
    println(obj.lengthOfLongestSubstring("egg"))
}
