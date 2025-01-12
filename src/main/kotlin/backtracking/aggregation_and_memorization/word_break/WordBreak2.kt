package backtracking.aggregation_and_memorization.word_break
// This answer exceeds Time Limit.
class WordBreak2 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return dfs(s, wordDict, 0)
    }

    private fun dfs(s: String, wordDict: List<String>, startIndex: Int): Boolean {
        if (startIndex == s.length) {
            return true
        }

        var result = false
        for (word in wordDict) {
            if (s.substring(startIndex).startsWith(word)) {
                result = result || dfs(s, wordDict, startIndex + word.length)
            }
        }
        return result
    }
}

fun main() {
    val obj = WordBreak2()
    println(obj.wordBreak("applepenapple", listOf("apple", "pen")))
//    println(obj.wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))
}