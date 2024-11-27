package backtracking.pruning.leetcode_problem_46_permutation

class Permutation {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        dfs(0, ArrayList(), BooleanArray(nums.size), result, nums)
        return result
    }

    private fun dfs(
        start: Int,
        path: ArrayList<Int>,
        used: BooleanArray,
        result: ArrayList<List<Int>>,
        nums: IntArray) {
        if(start == used.size) {
            val res = ArrayList<Int>()
            res.addAll(path)
            result.add(res)
            return
        }

        for(i in nums.indices) {
            if(used[i]) continue
            path.add(nums[i])
            used[i] = true
            dfs(start + 1, path, used, result, nums)
            path.removeLast()
            used[i] = false
        }
    }
}

fun main() {
    val obj = Permutation()
    val res = obj.permute(intArrayOf(1,2,3))
    res.forEach { println(it) }
}