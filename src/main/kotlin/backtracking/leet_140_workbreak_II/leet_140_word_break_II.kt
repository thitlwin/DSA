package backtracking.leet_140_workbreak_II

class leet_140_word_break_II {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val result: ArrayList<String> = arrayListOf()
        val path: ArrayList<String> = arrayListOf()
        dfs(s, wordDict, path, result, start=0)
        return result
    }

    private fun dfs(s: String,
                    wordDict: List<String>,
                    path: ArrayList<String>,
                    result: ArrayList<String>,
                    start: Int) {
        if(start == s.length) {
            result.add(path.joinToString(" "))
            return
        }

        for(word in wordDict) {
            if(s.substring(start).startsWith(word)) {
                path.add(word)
                dfs(s, wordDict, path, result, start + word.length)
                path.removeLast()
            }
        }
    }
}

fun main() {
    val obj = leet_140_word_break_II()
    val res = obj.wordBreak("catsanddog", listOf("cat","cats","and","sand","dog"))
    println(res)
}