package leetcode_problem_15_2pointers

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = ArrayList<List<Int>>()
        for (i in nums.indices) {
            if (nums[i] > 0 || i > 0 && nums[i] == nums[i - 1]) continue
            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val total = nums[i] + nums[l] + nums[r]
                if (total == 0) {
                    result.add(listOf(nums[i], nums[l], nums[r]))
                    l++
                    r--
                    while (l < nums.size - 1 && nums[l] == nums[l - 1]) {
                        l++
                    }
                } else if (total > 0) {
                    r--
                } else {
                    l++
                }
            }
        }
        return result
    }
}

fun main() {
    val obj = ThreeSum()
//    val res = obj.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)) // 2lists
//    val res = obj.threeSum(intArrayOf(0,1,1)) // empty
    val res = obj.threeSum(intArrayOf(0,0,0)) // empty
    res.forEach { println(it.joinToString()) }
}