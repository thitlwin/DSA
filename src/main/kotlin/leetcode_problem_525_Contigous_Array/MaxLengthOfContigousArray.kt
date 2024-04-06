package leetcode_problem_525_Contigous_Array

import kotlin.math.max

class MaxLengthOfContigousArray {
    fun findMaxLength(nums: IntArray): Int {
        var maxLen = 0
        for(start in nums.indices) {
            var oneCount = 0
            var zeroCount = 0
            for(end in start until nums.size) {
                if(nums[end] == 0)
                    zeroCount++
                else
                    oneCount++
                if(zeroCount == oneCount){
                    maxLen = max(maxLen, end - start + 1)
                }
            }
        }
        return maxLen
    }
}

fun main() {
    val obj = MaxLengthOfContigousArray()
    println(obj.findMaxLength(intArrayOf(1,0,1,0,1)))
}