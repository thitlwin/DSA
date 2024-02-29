package leetcode_problem_2357

class MakeArrayZero {
    fun minimumOperations(nums: IntArray): Int {
        var count = 0
        val sum = nums.sum()
        if (sum == 0) return 0
        while(true) {
            val x = nums.filter { it > 0 }.minOrNull() ?: break
            for (i in nums.indices) {
                if (nums[i] > 0)
                    nums[i] = nums[i] - x
            }
            count++
        }
        return count
    }
}

fun main() {
    val obj = MakeArrayZero()
    val res = obj.minimumOperations(intArrayOf(1,5,0,3,5))
    println(res)
}