package backtracking.leet_140_workbreak_II
//  def dfs(start_index, path):
//        if start_index == len(s):
//            ans.append(" ".join(path))
//            return
//        for end_index in range(start_index, len(s)):
//            w = s[start_index:end_index+1]
//            if w in wordDict:
//                path.append(w)
//                dfs(end_index+1, path)
//                path.pop()
//    ans = []
//    dfs(0, [])
//    return ans

class leet_140_work_break_II_AlgoAnswer {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val result: ArrayList<String> = arrayListOf()
        dfs(s, wordDict, path = arrayListOf(), result, start=0)
        return result
    }

    private fun dfs(s: String, wordDict: List<String>, path: ArrayList<String>, result: java.util.ArrayList<String>, start: Int) {
        if (start == s.length) {
            result.add(path.joinToString(" "))
            return
        }
        for (end in start until s.length) {
            val word = s.substring(start, end + 1)
            if (wordDict.contains(word)) {
                path.add(word)
                dfs(s, wordDict, path, result, start + word.length)
                path.removeLast()
            }
        }
    }
}

fun main() {
    val obj = leet_140_work_break_II_AlgoAnswer()
    val res = obj.wordBreak("catsanddog", listOf("cat","cats","and","sand","dog"))
    println(res)
}