package backtracking.pruning

class GenerateAllPermutation {
    fun permutations(str: String): List<String> {
        val letters = str.toCharArray()
        val result = ArrayList<String>()
        dfs(letters, ArrayList(), result, 0, BooleanArray(letters.size))
        return result
    }

    private fun dfs(
        charArr: CharArray,
        path: ArrayList<Char>,
        res: ArrayList<String>,
        start: Int,
        used: BooleanArray,
    ) {
        if (start == used.size) {
            res.add(path.joinToString(""))
            return
        }
        for (i in used.indices) {
            if (used[i]) continue
            path.add(charArr[i])
            used[i] = true
            dfs(charArr, path,res, start + 1, used)
            path.removeLast()
            used[i] = false
        }
    }
}

fun main() {
    val obj = GenerateAllPermutation()
    val res = obj.permutations("abc")
    res.forEach { println(it) }
}