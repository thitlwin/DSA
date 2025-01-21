package backtracking.subset

class Subset {
    fun subsets(nums: List<Int>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        dfs(0, mutableListOf(), nums, result)
        return result
    }

    private fun dfs(
        start: Int,
        path: MutableList<Int>,
        nums: List<Int>,
        result: MutableList<List<Int>>
    ) {
        result.add(path.toList())
        for (i in start until nums.size) {
            path.add(nums[i])
            dfs(i + 1, path, nums, result)
            path.removeLast()
        }
    }
}

fun main() {
    val obj = Subset()
    val res = obj.subsets(listOf(1,2,3))
    res.forEach { println(it) }
}