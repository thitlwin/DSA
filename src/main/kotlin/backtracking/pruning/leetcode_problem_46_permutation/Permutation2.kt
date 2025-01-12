package backtracking.pruning.leetcode_problem_46_permutation

class Permutation2 {
    fun permute(nums: IntArray): List<List<Int>> {
        val result: ArrayList<ArrayList<Int>> = arrayListOf()
        dfs(nums, arrayListOf(), result, 0)
        return result
    }

    private fun dfs(nums: IntArray, path: ArrayList<Int>, result: ArrayList<ArrayList<Int>>, start: Int){
        if(start == nums.size) {
            result.add(ArrayList(path))
            return
        }
        for(i in nums.indices) {
            if(path.contains(nums[i]))
                continue
            path.add(nums[i])
            dfs(nums, path, result, start + 1)
            path.removeLast()
        }
    }
}

fun main() {
    val obj = Permutation2()
    val res = obj.permute(intArrayOf(1,2,3))
    println(res)
}