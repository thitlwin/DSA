package backtracking.dedup.leet_39_combination_sum

class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result: ArrayList<ArrayList<Int>> = arrayListOf()
        val path: ArrayList<Int> = arrayListOf()
        candidates.sort()
        dfs(candidates, target, path, result, sum = 0, start = 0)
        return result
    }

    private fun dfs(
        candidates: IntArray,
        target: Int,
        path: java.util.ArrayList<Int>,
        result: java.util.ArrayList<java.util.ArrayList<Int>>,
        sum: Int,
        start: Int
    ) {
        if (sum == target) {
            result.add(ArrayList(path))
            return
        }

//        if (sum < target) {
            for (i in start until candidates.size) {
                if (sum + candidates[i] > target) break
                path.add(candidates[i])
                dfs(candidates, target, path, result, sum + candidates[i], i)
                path.removeLast()
            }
//        }
    }
}

fun main() {
    val obj = CombinationSum()
//    val res = obj.combinationSum(intArrayOf(2,3,6,7), 7)
    val res = obj.combinationSum(intArrayOf(2,3,5), 8)
//    val res = obj.combinationSum(intArrayOf(2), 1)
    println(res.joinToString())
}