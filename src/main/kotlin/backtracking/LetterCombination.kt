package backtracking

import java.util.ArrayList

class LetterCombination {
    fun letterCombination(n: Int): ArrayList<String> {
        val result = ArrayList<String>()
        dfs(n, 0, ArrayList<Char>(), result)
        return result;
    }

    private fun dfs(length: Int, level: Int, path: ArrayList<Char>, result: ArrayList<String>) {
        if(length == level) {
            result.add(path.joinToString(""))
            return
        }

        for (ch in listOf('a','b')){
            path.add(ch)
            dfs(length, level + 1, path, result)
            path.removeAt(level)
        }
    }
}

fun main() {
    val obj = LetterCombination()
    val res = obj.letterCombination(5)
    res.forEach {
        println(it)
    }
}