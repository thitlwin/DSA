package leetcode_problem_41_find_missing_positive

class AlgoAnswer {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        for (i in nums.indices) {
            while (nums[i] in 1..n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1)
            }
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1) {
                return i + 1
            }
        }
        return n + 1
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

fun main() {
    val obj = AlgoAnswer()
//    println(obj.firstMissingPositive(intArrayOf(3,4,-1,1)))
//    println(obj.firstMissingPositive(intArrayOf(0,1,2)))
    println(obj.firstMissingPositive(intArrayOf(7,8,9,11,12)))
}