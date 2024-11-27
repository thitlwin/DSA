package backtracking.aggregation_and_memorization

import java.util.LinkedList

// answer of leetcode editor => https://leetcode.com/problems/word-break/
class WordBreak_BFS {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val words = HashSet<String>(wordDict)
        val queue = LinkedList<Int>()
        val seen = BooleanArray(s.length + 1)
        queue.add(0)

        while (queue.isNotEmpty()) {
            val start = queue.remove()
            if (start == s.length) {
                return true
            }

            for (end in start + 1..s.length) {
                if (seen[end]) continue
                val subStr = s.substring(start, end)
                if (words.contains(subStr)) {
                    queue.add(end)
                    seen[end] = true
                }
            }
        }
        return false
    }
}

fun main() {
    val obj = WordBreak_BFS()
//    println(obj.wordBreak("leetcode", listOf("leet", "code")))
    println(obj.wordBreak("addidas", listOf("a" , "d","di", "as")))
//    println(
//        obj.wordBreak(
//            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//            listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
//        )
//    )
}