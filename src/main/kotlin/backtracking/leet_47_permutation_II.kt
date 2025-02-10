package backtracking

class leet_47_permutation_II {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result: ArrayList<ArrayList<Int>> = arrayListOf()
        val path: ArrayList<Int> = arrayListOf()
        val used = BooleanArray(nums.size)
        nums.sort()
        dfs(nums,  path, result, used)
        return result
    }

    private fun dfs(
        nums: IntArray, path: ArrayList<Int>,
        result: ArrayList<ArrayList<Int>>,
        used: BooleanArray
    ) {
        if (path.size == nums.size) {
            result.add(ArrayList(path))
            return
        }

        for (i in nums.indices) {
            if (used[i]) continue
//            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue  // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue
            path.add(nums[i])
            used[i] = true
            dfs(nums, path, result, used)
            path.removeLast()
            used[i] = false
        }
    }
}

fun main() {
    val obj = leet_47_permutation_II()
    val res = obj.permuteUnique(intArrayOf(1, 1, 6))
    res.forEach {
        println(it.joinToString())
    }
}