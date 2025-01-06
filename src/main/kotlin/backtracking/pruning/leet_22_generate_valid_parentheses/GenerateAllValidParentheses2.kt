package backtracking.pruning.leet_22_generate_valid_parentheses

import java.util.ArrayList

class GenerateAllValidParentheses2 {
    fun generateParenthesis(n: Int): List<String> {
        val result: ArrayList<String> = arrayListOf()
        dfs(n, result, path = arrayListOf<String>(), openCount = 0, closeCount = 0)
        return result
    }

    private fun dfs(n: Int, result: ArrayList<String>, path: ArrayList<String>, openCount: Int, closeCount: Int) {
        if (path.size == 2 * n) {
            result.add(path.joinToString(""))
            return
        }
        if (openCount < n) {
            path.add("(")
            dfs(n, result, path, openCount + 1, closeCount)
            path.removeLast()
        }

        if (closeCount < openCount) {
            path.add(")")
            dfs(n, result, path, openCount, closeCount + 1)
            path.removeLast()
        }
    }
}

fun main() {
    val obj = GenerateAllValidParentheses2()
    val res = obj.generateParenthesis(2)
    println(res.joinToString())
}