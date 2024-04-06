package leetcode_problem_2444_subarr_count_with_fixed_bounce

import kotlin.math.*

class AlgoAnswer {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var lastMinIndex = -1
        var lastMaxIndex = -1
        var lastOutOfRange = -1
        var result = 0L
        for(i in nums.indices) {
            if(nums[i] < minK || nums[i] > maxK) {
                lastOutOfRange = i
            }
            if(nums[i] == minK) {
                lastMinIndex = i
            }
            if(nums[i] == maxK) {
                lastMaxIndex = i
            }
            result += max(0, min(lastMinIndex, lastMaxIndex) - lastOutOfRange)
        }
        return result
    }
}

fun main() {
    val obj = AlgoAnswer()
//    println(obj.countSubarrays(intArrayOf(1,3,5,2,7,5), 1,5))
//    println(obj.countSubarrays(intArrayOf(1,3,5,2,7,5,1), 1,5))
    println(obj.countSubarrays(intArrayOf(1,1,1,1),1,1))

}