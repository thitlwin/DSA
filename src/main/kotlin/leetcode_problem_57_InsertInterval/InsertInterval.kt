package leetcode_problem_57_InsertInterval

import kotlin.math.max
import kotlin.math.min
// WRONG ANSWER
class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var toAddNewInterval = false
        if (intervals.isEmpty())
        {
            result.add(newInterval)
        } else {
            for(interval in intervals) {
                if(interval[0] >= newInterval[0]  && interval[0] <= newInterval[1] ||
                    interval[1] >= newInterval[0]  && interval[1] <= newInterval[1])
                {
                    toAddNewInterval = true
                    newInterval[0] = min(newInterval[0], interval[0])
                    newInterval[1] = max(newInterval[1], interval[1])
                    continue
                }
                if (toAddNewInterval)
                {
                    result.add(newInterval)
                    toAddNewInterval = false
                }
                result.add(interval)
            }
            if (toAddNewInterval)
            {
                result.add(newInterval)
            }
        }
        return result.toTypedArray()
    }
}

fun main() {
    val obj = InsertInterval()
//    val res = obj.insert(arrayOf(intArrayOf(1,3), intArrayOf(6,9)), intArrayOf(2,5));
//    val res = obj.insert(arrayOf(intArrayOf(1,2), intArrayOf(3,5), intArrayOf(6,7), intArrayOf(8,10), intArrayOf(12,16)), intArrayOf(4,8))
//    val res = obj.insert(arrayOf(intArrayOf(1,5)), intArrayOf(2,7));
    val res = obj.insert(arrayOf(intArrayOf(1,5)), intArrayOf(6,8));
    res.forEach {
        println(it.joinToString())
    }
}