package backtracking.dedup.leet_39_combination_sum

class CombinationSum_MinusApproach {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result: ArrayList<ArrayList<Int>> = arrayListOf()
        val path: ArrayList<Int> = arrayListOf()
        candidates.sort()
        dfs(candidates, target, path, result, balance = target, start = 0)
        return result
    }

    private fun dfs(
        candidates: IntArray,
        target: Int,
        path: ArrayList<Int>,
        result: ArrayList<ArrayList<Int>>,
        balance: Int,
        start: Int
    ) {
        if (balance == 0) {
            result.add(ArrayList(path))
            return
        }
        for (i in start until candidates.size) {
            if (balance - candidates[i] < 0) break
            path.add(candidates[i])
            dfs(candidates, target, path, result, balance - candidates[i], i)
            path.removeLast()
        }
    }
}