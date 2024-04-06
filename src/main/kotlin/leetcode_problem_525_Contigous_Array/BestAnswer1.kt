package leetcode_problem_525_Contigous_Array

import kotlin.math.max

class BestAnswer1 {
    fun findMaxLength(nums: IntArray): Int {
        val map = hashMapOf(0 to -1)
        var balance = 0
        var maxLength = 0
        for (i in nums.indices) {
            balance += if(nums[i] == 1) 1 else -1
            if(map.containsKey(balance)) {
                maxLength = max(maxLength, i - map[balance]!!)
            } else {
                map[balance] = i
            }
        }
        return maxLength
    }
}

fun main() {
    val obj = BestAnswer1()
    println(obj.findMaxLength(intArrayOf(1,0,1,0,0,0)));
}