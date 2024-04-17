package leetcode_problem_42_trapping_rain_water

import kotlin.math.max
import kotlin.math.min

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        val length = height.size
        val maxLeft = IntArray(length)
        val maxRight = IntArray(length)

        maxLeft[0] = height[0]
        maxRight[length - 1] = height[length - 1]

        for (i in 1 until  length) {
            maxLeft[i] = max(maxLeft[i-1], height[i])
        }

        for (i in length - 2 downTo 0){
            maxRight[i] = max(maxRight[i+1], height[i])
        }

        var totalWater = 0
        for (i in 0 until length) {
            totalWater += min(maxLeft[i], maxRight[i]) - height[i]
        }

        return totalWater
    }
}

fun main() {
    val obj = TrappingRainWater()
//    println(obj.trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
    println(obj.trap(intArrayOf(4,2,0,3,2,5)))
}