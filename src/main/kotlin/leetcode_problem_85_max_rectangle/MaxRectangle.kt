package leetcode_problem_85_max_rectangle

import java.util.Stack
import kotlin.math.max

class MaxRectangle {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val numColumns = matrix[0].size
        val heights = IntArray(numColumns)
        var maxArea = 0
        for (row in matrix) {
            for (j in 0 until numColumns) {
                heights[j] = if (row[j] == '1') heights[j] + 1 else 0
            }
            maxArea = max(maxArea, largestRectangleArea(heights))
        }
        return maxArea
    }

    private fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val stack = Stack<Int>()
        val left = IntArray(heights.size)
        val right = IntArray(heights.size) { heights.size }
        for (i in heights.indices) {
            while (stack.isNotEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i
            }
            left[i] = if (stack.isEmpty()) -1 else stack.peek()
            stack.push(i)
        }

        for (i in heights.indices) {
            maxArea = max(maxArea, heights[i] * (right[i] - left[i] - 1))
        }
        return maxArea
    }
}

fun main() {
    val obj = MaxRectangle()
    val res = obj.maximalRectangle(
        arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0')
        )
    )
    println(res)
}