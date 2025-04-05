package leet_2873_3_pointers

import kotlin.math.max

class MaxValueOfTriplet {
    fun maximumTripletValue(nums: IntArray): Long {
        var max_i = nums[0].toLong()
        var maxDiff = Long.MIN_VALUE
        var maxAns = 0L
        for (j in 1 until nums.size - 1){
            maxDiff = max(maxDiff, max_i - nums[j])
            val k = j + 1
            maxAns = max(maxAns, maxDiff * nums[k])
            max_i = max(max_i, nums[j].toLong())
        }
        return maxAns
    }
}

fun main() {
    val obj = MaxValueOfTriplet()
    println(obj.maximumTripletValue(intArrayOf(2,3,1)))
}