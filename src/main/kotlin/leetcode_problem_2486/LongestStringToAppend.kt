package leetcode_problem_2486

class LongestStringToAppend {
    fun appendCharacters(s: String, t: String): Int {
        var first = 0
        var longestPrefix = 0
        while(first < s.length && longestPrefix < t.length) {
            if(s[first] == t[longestPrefix]) {
                longestPrefix++
            }
            first++
        }
        return t.length - longestPrefix
    }
}

fun main() {
    val obj = LongestStringToAppend()
//    println(obj.appendCharacters("coaching", "coding"))
//    println(obj.appendCharacters("abcde", "a"))
    println(obj.appendCharacters("z", "abcde"))
}