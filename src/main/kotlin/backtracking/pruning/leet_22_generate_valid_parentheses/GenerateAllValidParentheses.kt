package backtracking.pruning.leet_22_generate_valid_parentheses

class GenerateAllValidParentheses {
    fun generateParentheses(n: Int): List<String> {
        val res = ArrayList<String>()
        dfs(n, ArrayList(), res, 0, 0)
        return res
    }

    private fun dfs(
        n: Int,
        path: ArrayList<Char>,
        res: ArrayList<String>,
        openCount: Int,
        closeCount: Int,
    ) {
        if (path.size == 2 * n) {
            res.add(path.joinToString("") { it.toString() })
            return
        }

        if (openCount < n) {
            path.add('(')
            dfs(n, path, res, openCount + 1, closeCount)
            path.removeAt(path.size - 1)
        }

        if (closeCount < openCount) {
            path.add(')')
            dfs(n, path, res, openCount, closeCount + 1)
            path.removeAt(path.size - 1)
        }
    }
}

fun main() {
    val obj = GenerateAllValidParentheses()
    val res = obj.generateParentheses(2)
    res.forEach { println(it) }
    println(res.size)
}