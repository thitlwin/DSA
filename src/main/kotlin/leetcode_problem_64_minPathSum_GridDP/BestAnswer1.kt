package leetcode_problem_64_minPathSum_GridDP

import kotlin.math.min

class BestAnswer1 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val row = grid.size
        val col = grid[0].size
        for (c in 1 until col)
            grid[0][c] += grid[0][c-1]
        for (r in 1 until row) {
            grid[r][0] += grid[r-1][0]
            for (c in 1 until col) {
                grid[r][c] += min(grid[r][c-1], grid[r-1][c])
            }
        }
        return grid[row-1][col-1]
    }
}

fun main() {
    val obj = BestAnswer1()
    val grid = arrayOf(intArrayOf(1,3,1), intArrayOf(1,5,1), intArrayOf(4,2,1))
    println(obj.minPathSum(grid))
}