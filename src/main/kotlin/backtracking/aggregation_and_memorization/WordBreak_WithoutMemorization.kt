package backtracking.aggregation_and_memorization

class WordBreak_WithoutMemorization {
    fun wordBreak(s: String, words: List<String>): Boolean {
        return dfs(0, s, words)
    }

    private fun dfs(start: Int, inputStr: String, words: List<String>): Boolean {
        if (start == inputStr.length) {
            return true
        }
        var ans = false
        for (word in words) {
            val subStr = inputStr.substring(start)
            if (subStr.startsWith(word)) {
                ans = ans || dfs(start + word.length, inputStr, words)
            }
        }
        return ans
    }
}

fun main() {
    val obj = WordBreak_WithoutMemorization()
    println(obj.wordBreak("addidas", listOf("a" , "d","di", "as")))
//    println(
//        obj.wordBreak(
//            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//            listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
//        )
//    )
}