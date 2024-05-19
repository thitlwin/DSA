package leetcode_problem_2373_largest_value_in_grid

import kotlin.math.max

class LargestLocalValueInGrid {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val n = grid[0].size
        val result = Array(n - 2) { IntArray(n - 2) }
        for (row in result.indices) {
            for (col in 0 until result[0].size) {
                val maxVal = getLargest(grid, row, col)
                result[row][col] = maxVal
            }
        }
        return result
    }

    private fun getLargest(grid: Array<IntArray>, row: Int, col: Int): Int {
        var maxVal = 0
        // loop row until 3
        for (r in row until grid.size) {
            for (c in col until grid[0].size) {
                maxVal = max(maxVal, grid[r][c])
            }
        }
        return maxVal
    }
}

fun main() {
    val obj = LargestLocalValueInGrid()
//    val grid = arrayOf(
//        intArrayOf(9, 9, 8, 1),
//        intArrayOf(5, 6, 2, 6),
//        intArrayOf(8, 2, 6, 4),
//        intArrayOf(6, 2, 2, 2)
//    )

//    val grid = arrayOf(
//        intArrayOf(1, 1, 1, 1, 1),
//        intArrayOf(1, 1, 1, 1, 1),
//        intArrayOf(1, 1, 2, 1, 1),
//        intArrayOf(1, 1, 1, 1, 1),
//        intArrayOf(1, 1, 1, 1, 1)
//    )

    val grid = arrayOf(
        intArrayOf(20,8,20,6,16,16,7,16,8,10),
        intArrayOf(12,15,13,10,20,9,6,18,17,6),
        intArrayOf(12,4,10,13,20,11,15,5,17,1),
        intArrayOf(7,10,14,14,16,5,1,7,3,11),
        intArrayOf(16,2,9,15,9,8,6,1,7,15),
        intArrayOf(18,15,18,8,12,17,19,7,7,8),
        intArrayOf(19,11,15,16,1,3,7,4,7,11),
        intArrayOf(11,6,5,14,12,18,3,20,14,6),
        intArrayOf(4,4,19,6,17,12,8,8,18,8),
        intArrayOf(19,15,14,11,11,13,12,6,16,19)
    )

    val res = obj.largestLocal(grid)
    res.forEach {
        println(it.joinToString())
    }
}