package DP

import java.util.*
import kotlin.collections.ArrayList

class LongestDivisibleSubset {
    fun findLargestSubset(nums: List<Int>): List<Int> {
        Collections.sort(nums)
        val dp = IntArray(nums.size){1}
        var maxIndex = 0
        for (i in nums.indices) {
            for (j in 0 until i) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1)
                }
            }
            if(dp[maxIndex] < dp[i]){
                maxIndex = i
            }
        }

        var subsetSize = dp[maxIndex]
        val result = ArrayList<Int>()
        for (i in maxIndex downTo 0){
            if (nums[maxIndex] % nums[i] == 0 && dp[i] == subsetSize){
                result.add(nums[i])
                maxIndex = i
                --subsetSize
            }
        }
        return result
    }
}

fun main() {
    val obj = LongestDivisibleSubset()
//    println(obj.findLargestSubset(listOf(1,2,3)))//2
//    println(obj.findLargestSubset(listOf(1,2,3,4)))//3
    println(obj.findLargestSubset(listOf(3,4,8,16)))//3
//    println(obj.findLargestSubset(listOf(2,3,4)))//2
//    println(obj.findLargestSubset(listOf(8, 9, 4, 2, 12, 1, 3)))//4
//    println(obj.findLargestSubset(listOf(125, 1, 8, 3, 24, 9, 18, 2, 4, 25, 12, 72)))//6
//    println(obj.findLargestSubset(listOf(4, 1, 108, 3, 9 ,36, 360, 225, 72, 420)))//6
}