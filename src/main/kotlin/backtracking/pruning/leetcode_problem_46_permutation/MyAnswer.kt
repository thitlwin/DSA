package backtracking.pruning.leetcode_problem_46_permutation

class MyAnswer {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val used = BooleanArray(nums.size)
        dfs(nums, ArrayList<Int>(), result, 0, used)
        return result
    }

    private fun dfs(nums: IntArray, path: ArrayList<Int>, result: ArrayList<List<Int>>,
                    start: Int, used: BooleanArray){
        if(start == nums.size) {
            result.add(ArrayList(path))
            return
        }

        for(i in nums.indices) {
            if(used[i]) continue
            path.add(nums[i])
            used[i] = true
            dfs(nums, path, result, start + 1, used)
            used[i] = false
            path.removeLast()
        }
    }
}


fun main() {
    val obj = MyAnswer()
    val res = obj.permute(intArrayOf(1,2,3))
    res.forEach { println(it) }
}