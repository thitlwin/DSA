package leetcode_problem_34_BinarySearch

import java.time.LocalTime
import java.time.temporal.ChronoUnit

class BestAnswer1 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(nums.indexOfFirst { it==target }, nums.indexOfLast { it==target })
    }
}


fun main() {
    val runningTimeInMs = kotlin.system.measureNanoTime {
        val obj = BestAnswer1()
//        val startTime = LocalTime.now()
//    println(obj.searchRange(intArrayOf(5,7,7,8,8,10),8).joinToString())
//    println(obj.searchRange(intArrayOf(0),0).joinToString())
//    println(obj.searchRange(intArrayOf(0,1),0).joinToString())
//    println(obj.searchRange(intArrayOf(0,1,2),2).joinToString())
        println(obj.searchRange(intArrayOf(0,1,2,2,2,2,2,3,4),2).joinToString())
//        val endTime = LocalTime.now()
//        val res = ChronoUnit.MICROS.between(startTime, endTime)
//        println("Running Time = $res ms")
    }
        println("Running Time = $runningTimeInMs ms")
}