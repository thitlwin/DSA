package two_pointers

import kotlin.math.max
import kotlin.math.min

class LongestSubstring {
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        val lastOccurrence = HashMap<Char, Int>()
        var maxLen = 0
        var l = 0
        for (r in s.indices) {
            var right = r
            lastOccurrence[s[r]] = right
            right++
            if (lastOccurrence.size == 3) {
                l = lastOccurrence.values.min() + 1
                lastOccurrence.remove(s[l-1])
            }
            maxLen = max(maxLen, right-l)
        }
        return maxLen
    }
}

fun main() {
    val obj = LongestSubstring()
    println(obj.lengthOfLongestSubstringTwoDistinct("eceba"))
    println(obj.lengthOfLongestSubstringTwoDistinct("ccaabbb"))

}