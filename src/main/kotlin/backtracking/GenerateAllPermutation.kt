package backtracking

class GenerateAllPermutation {
    fun permutations(str: String): List<String> {
        val letters = str.toCharArray()
        val result = ArrayList<String>()
        dfs(0, ArrayList(), BooleanArray(letters.size), result, letters)
        return result
    }

    private fun dfs(
        start: Int,
        path: ArrayList<Char>,
        used: BooleanArray,
        res: ArrayList<String>,
        charArr: CharArray
    ) {
        if (start == used.size){
            res.add(path.joinToString(""))
            return
        }
        for (i in used.indices) {
            if (used[i]) continue
            path.add(charArr[i])
            used[i] = true
            dfs(start+1, path, used, res, charArr)
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