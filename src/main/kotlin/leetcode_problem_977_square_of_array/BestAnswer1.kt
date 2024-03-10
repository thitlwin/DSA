package leetcode_problem_977_square_of_array

import kotlin.math.abs

class BestAnswer1 {
    fun sortedSquares(nums: IntArray): IntArray {
        var l = 0
        var r = nums.size - 1
        val resultArr = IntArray(nums.size)
        for (i in nums.size - 1 downTo 0) {
//        for (i in 0 until nums.size) {
            if (abs(nums[l]) > abs(nums[r])) {
                resultArr[i] = nums[l] * nums[l]
                l++
            } else {
                resultArr[i] = nums[r] * nums[r]
                r--
            }
        }
        return resultArr
    }
}

fun main() {
    val obj = BestAnswer1()
    println(obj.sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).joinToString())
    println(obj.sortedSquares(intArrayOf(-10000, -1, 0, 3, 10000)).joinToString())
    println(obj.sortedSquares(intArrayOf(-4, -4, -3)).joinToString())
}