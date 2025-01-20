package backtracking.aggregation_and_memorization.word_break

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val memo = BooleanArray(s.length)
        return dfs(0, s, wordDict, memo)
    }

    private fun dfs(start: Int, s: String, wordDict: List<String>, memo: BooleanArray): Boolean {
        if(start == s.length) return true
        if(memo[start]) return true
        var ans = false
        for(w in wordDict) {
            val subStr = s.substring(start)
            if(subStr.startsWith(w)){
                ans = ans || dfs(start + w.length, s, wordDict, memo)
            }
        }
        memo[start] = ans
        return ans
    }

//    fun wordBreak(s: String, words: List<String>): Boolean {
//        return dfs(0, s, words, BooleanArray(s.length))
//    }
//
//    private fun dfs(start: Int, targetStr: String, words: List<String>, memo: BooleanArray): Boolean {
//        if (start == targetStr.length) return true
//        if(memo[start]) return true
//        var ans = false
//        for (word in words) {
//            if (targetStr.substring(start).startsWith(word)) {
//                ans = ans || (dfs(start + word.length, targetStr, words, memo))
//            }
//        }
//        memo[start] = ans
//        return ans
//    }
}

//fun main() {
//    val obj = WordBreak()
////    println(obj.wordBreak("leetcode", listOf("leet","code")))
//    println(obj.wordBreak("applepenapple", listOf("apple","pen")))
//
////    println(obj.wordBreak("addidas", listOf("a" , "d","di", "as")))
////    println(obj.wordBreak("aab", listOf("a", "c")))
////    println(obj.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
////        listOf("a" ,"aa" ,"aaa" ,"aaaa" ,"aaaaa" ,"aaaaaa" ,"aaaaaaa" ,"aaaaaaaa" ,"aaaaaaaaa" ,"aaaaaaaaaa")
////    ))
//}