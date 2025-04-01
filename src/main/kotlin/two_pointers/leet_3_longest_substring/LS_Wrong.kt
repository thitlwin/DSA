package two_pointers.leet_3_longest_substring

class LS_Wrong {
    fun lengthOfLongestSubstring(s: String): Int {
        var len = 0
        val sb = StringBuilder()
        for(ch in s){
            if(sb.contains(ch)){
                sb.clear()
                sb.append(ch)
            } else {
                sb.append(ch)
            }
            len = maxOf(len, sb.length)
        }
        return len
    }
}

fun main() {
    val obj = LS_Wrong()
    println(obj.lengthOfLongestSubstring("abcabcbb"))
}