package backtracking

class GenerateAllValidParentheses {
    fun generateParentheses(n: Int): List<String> {
        val res = ArrayList<String>()
        dfs(0, ArrayList(), 0, 0, res, n)
        return res
    }

    private fun dfs(
        start: Int,
        path: ArrayList<Char>,
        openCount: Int,
        closeCount: Int,
        res: ArrayList<String>,
        n: Int
    ) {
        if (path.size == 2 * n) {
            res.add(path.joinToString("") { it.toString() })
            return
        }

        if (openCount < n) {
            path.add('(')
            dfs(start, path, openCount+1, closeCount, res, n)
            path.removeAt(path.size-1)
        }

        if (closeCount < openCount) {
            path.add(')')
            dfs(start, path, openCount, closeCount+1, res, n)
            path.removeAt(path.size - 1)
        }
    }
}

fun main() {
    val obj = GenerateAllValidParentheses()
    val res = obj.generateParentheses(3)
    res.forEach { println(it) }
    println(res.size)
}