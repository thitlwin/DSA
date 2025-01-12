package backtracking.pruning.leet_22_generate_valid_parentheses

class GenerateAllValidParentheses3 {
    fun generateParenthesis(n: Int): List<String> {
        val result = ArrayList<String>()
        dfs(n, path = arrayListOf<Char>(), result = result, openCount = 0, closeCount = 0)
        return result
    }

    private fun dfs(
        n: Int,
        path: ArrayList<Char>,
        result: java.util.ArrayList<String>,
        openCount: Int,
        closeCount: Int
    ) {
        if (path.size == 2 * n) {
            val l = ArrayList(path)
            result.add(l.joinToString(""))
            return
        }

        if (openCount < n) {
            path.add('(')
            dfs(n, path, result, openCount + 1, closeCount)
            path.removeLast()
        }
        if (closeCount < openCount) {
            path.add(')')
            dfs(n, path, result, openCount , closeCount + 1)
            path.removeLast()
        }

    }
}

fun main() {
    val obj = GenerateAllValidParentheses3()
    val res = obj.generateParenthesis(2)
    println(res)
}