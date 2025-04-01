package two_pointers.leet_3_longest_substring

import kotlin.math.max

class LongestSubStrWithoutRepeating_2 {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var maxSoFar = 0
        val chrMap = HashMap<Char, Int>(26)
        for (right in s.indices){
            chrMap[s[right]] = chrMap.getOrDefault(s[right], 0) + 1
            while(chrMap[s[right]]!! > 1){
                chrMap[s[left]] = chrMap.getOrDefault(s[left] , 0) - 1
                left++
            }
            maxSoFar = max(maxSoFar, right - left + 1)
        }
        return maxSoFar
    }
}

fun main() {
    val obj = LongestSubStrWithoutRepeating_2()
//    println(obj.lengthOfLongestSubstring("abcabcbb"))
    println(obj.lengthOfLongestSubstring("tmmzuxt"))

}