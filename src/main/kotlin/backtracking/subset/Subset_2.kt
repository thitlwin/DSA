package backtracking.subset

class Subset_2 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result: ArrayList<ArrayList<Int>> = arrayListOf()
        val path: ArrayList<Int> = arrayListOf()
        dfs(nums, path, result, start = 0)
        return result
    }

    private fun dfs(nums: IntArray, path: ArrayList<Int>, result: ArrayList<ArrayList<Int>>, start: Int) {
//        if (start == nums.size) {
//            result.add(ArrayList(path))
//            return
//        }
        result.add(ArrayList(path))
        for (i in start until  nums.size) {
            path.add(nums[i])
            dfs(nums, path, result, i + 1)
            path.removeLast()
        }
//        path.add(nums[start])
//        dfs(nums, path, result, start + 1)
//        path.removeLast()
//        dfs(nums, path, result, start + 1)
    }
}

fun main() {
    val obj = Subset_2()
    val res = obj.subsets(intArrayOf(1, 2, 3))
    println(res.joinToString())
}