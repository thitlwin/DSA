package leetcode_problem_287_DuplicateNumber

import kotlin.math.pow

class BestAnswer1 {
    fun findDuplicate(nums: IntArray): Int {
        val solArr = BooleanArray(10.0.pow(5).toInt() + 1)
        nums.forEach {
            if (solArr[it])
                return it
            else
                solArr[it] = true
        }
        return 0
    }
}
fun main() {
    val obj = BestAnswer1()
//    println(obj.findDuplicate(intArrayOf(1,3,4,2,2)))
    println(obj.findDuplicate(intArrayOf(3,3,3,3)))
}