package two_pointers

class LongestSubstringWithoutRepeatingCharacter {
    fun longestSubstringWithoutRepeatingCharacters(s: String): Int {
        var longest = 0
        var left = 0
        val window = HashMap<Char, Int>()
        for (right in s.indices) {
            window[s[right]] = window.getOrDefault(s[right],0) + 1
            while (window[s[right]]!! > 1){
                window[s[left]] = window[s[left]]!! - 1
                left++
            }
            longest = maxOf(longest, right - left + 1)
        }
        return longest
    }
}

fun main() {
    val obj = LongestSubstringWithoutRepeatingCharacter()
//    val res = obj.longestSubstringWithoutRepeatingCharacters("aaaabaaa")//2
    val res = obj.longestSubstringWithoutRepeatingCharacters("abccabcabcc")//3
//    val res = obj.longestSubstringWithoutRepeatingCharacters("aba")//2
//    val res = obj.longestSubstringWithoutRepeatingCharacters("abccabcabcc")//3
//    val res = obj.longestSubstringWithoutRepeatingCharacters("pwwkew")//3
    println(res)
}