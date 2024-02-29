package leetcode_problem_34_BinarySearch

import java.time.LocalTime
import java.time.temporal.ChronoUnit

class FindFirstAndLastPositionOfNumInArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.size - 1
        var firstIndex = -1
        var lastIndex = -1
        while(left <= right) {
            val mid = left + (right - left)/2
            if(nums[mid] == target) {
                firstIndex = mid
                right = mid - 1
            } else if(nums[mid] < target) {
                left = mid + 1
            } else
                right = mid - 1
        }

        left = 0
        right = nums.size - 1
        while(left <= right) {
            val mid = left + (right - left)/2
            if(nums[mid] == target) {
                lastIndex = mid
                left = mid + 1
            } else if(nums[mid] < target) {
                left = mid + 1
            } else
                right = mid - 1
        }
        return intArrayOf(firstIndex, lastIndex)
    }
}

fun main() {
    val obj = FindFirstAndLastPositionOfNumInArray()
    val startTime = LocalTime.now()
//    println(obj.searchRange(intArrayOf(5,7,7,8,8,10),8).joinToString())
//    println(obj.searchRange(intArrayOf(0),0).joinToString())
//    println(obj.searchRange(intArrayOf(0,1),0).joinToString())
//    println(obj.searchRange(intArrayOf(0,1,2),2).joinToString())
    println(obj.searchRange(intArrayOf(0,1,2,2,2,2,2,3,4),2).joinToString())
    val endTime = LocalTime.now()
    val res = ChronoUnit.MICROS.between(startTime, endTime)
    println("Running Time = $res ms")
}