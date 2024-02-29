package leetcode_problem_2357

class BestAnswer1 {
    fun minimumOperations(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (num > 0)
                set.add(num)
        }
        return set.size
    }
}

fun main() {
    val obj = BestAnswer1()
    val res = obj.minimumOperations(intArrayOf(1, 5, 0, 3, 5))
    println(res)
}