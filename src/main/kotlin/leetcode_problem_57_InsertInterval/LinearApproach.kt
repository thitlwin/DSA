package leetcode_problem_57_InsertInterval

import kotlin.math.max
import kotlin.math.min

class LinearApproach {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        val n = intervals.size
        var i = 0
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i])
            i++
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i++
        }
        result.add(newInterval)

        while(i< n) {
            result.add(intervals[i])
            i++
        }
        return result.toTypedArray()
    }
}