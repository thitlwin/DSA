package backtracking.combinatory_search.letter_combination

import kotlin.collections.ArrayList

class LetterCombination2 {
    fun letterCombination(n: Int, charArr: CharArray): ArrayList<String> {
        val result = ArrayList<String>()
        return dfs(n, charArr, startIndex = 0, path = arrayListOf(), result = result)
    }

    private fun dfs(
        n: Int,
        charArr: CharArray,
        startIndex: Int,
        path: ArrayList<Char>,
        result: ArrayList<String>
    ): java.util.ArrayList<String> {
        if (startIndex == n) {
            result.add(path.joinToString(""))
            return result
        }

        for (ch in charArr) {
            path.add(ch)
            dfs(n, charArr, startIndex + 1, path, result)
            path.removeLast()
        }
        return result
    }
}

fun main() {
    val obj = LetterCombination2()
    val res = obj.letterCombination(2, charArrayOf('a','b'))
    println(res.joinToString())
}