package backtracking.pruning.leetcode_problem_46_permutation

class GenerateAllPermutation2 {
    fun permutations(str: String): List<String> {
        val result = ArrayList<String>()
        dfs(str, path = arrayListOf<Char>(), result = result)//, start = 0)
        return result
    }

    private fun dfs(
        str: String,
        path: ArrayList<Char>,
        result: java.util.ArrayList<String>,
//        start: Int,
    ) {
        if (path.size == str.length) {
            result.add(path.joinToString(""))
            return
        }
        for (i in str.indices) {
            if (path.contains(str[i]))
                continue
            path.add(str[i])
            dfs(str, path, result)//, start + 1)
            path.removeLast()
        }
    }


}

fun main() {
    val obj = GenerateAllPermutation2()
    val res = obj.permutations("abc")
    println(res)
}