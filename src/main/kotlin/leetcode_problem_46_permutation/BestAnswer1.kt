package leetcode_problem_46_permutation

class BestAnswer1 {
    fun permute(nums: IntArray): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        backtracking(nums, list, mutableListOf<Int>())
        return list
    }

    private fun backtracking(nums: IntArray, list: MutableList<List<Int>>, path: MutableList<Int>) {
        if (path.size == nums.size) {
            list.add(path.toList())
            return
        }

        for (num in nums) {
            if (num in path) continue
            path.add(num)
            backtracking(nums, list, path)
            path.removeLast()
        }
    }
}

fun main() {
    val obj = BestAnswer1()
    val res = obj.permute(intArrayOf(1, 2, 3))
    res.forEach { println(it) }
}
