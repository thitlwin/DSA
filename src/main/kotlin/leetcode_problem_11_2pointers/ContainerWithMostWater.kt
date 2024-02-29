package leetcode_problem_11_2pointers

import kotlin.math.max
import kotlin.math.min

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0
        while (left < right) {
            val w = right - left
            val h = min(height[left], height[right])
            maxArea = max(maxArea, w * h)
            if (height[left] < height[right])
                left += 1
            else
                right -= 1
        }
        return maxArea
    }
}

fun main() {
    val obj = ContainerWithMostWater()
//    println(obj.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))) // 49
//    println(obj.maxArea(intArrayOf(1,1))) // 1
    println(obj.maxArea(intArrayOf(9,8,6,2,5,4,8,3,7))) // 56

}