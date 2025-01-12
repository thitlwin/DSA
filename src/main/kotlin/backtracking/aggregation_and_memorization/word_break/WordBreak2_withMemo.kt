package backtracking.aggregation_and_memorization.word_break
// This answer exceeds Time Limit.
class WordBreak2_withMemo {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return dfs(s, wordDict, 0, arrayOfNulls<Boolean?>(s.length))
    }

    private fun dfs(s: String, wordDict: List<String>, startIndex: Int, memo: Array<Boolean?>): Boolean {
        if (startIndex == s.length) {
            return true
        }
        if (memo[startIndex] != null) {
            return memo[startIndex]!!
        }

        var result = false
        for (word in wordDict) {
            if (s.substring(startIndex).startsWith(word)) {
                result = result || dfs(s, wordDict, startIndex + word.length, memo)
            }
        }
        memo[startIndex] = result
        return result
    }
}

fun main() {
    val obj = WordBreak2_withMemo()
    println(obj.wordBreak("applepenapple", listOf("apple", "pen")))
//    println(obj.wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))
}