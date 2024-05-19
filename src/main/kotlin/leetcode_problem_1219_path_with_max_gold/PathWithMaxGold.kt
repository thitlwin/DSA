package leetcode_problem_1219_path_with_max_gold

import kotlin.math.max

class PathWithMaxGold {

    private lateinit var grid: Array<IntArray>
    private var rows: Int = 0
    private var cols: Int = 0
    fun getMaximumGold(grid: Array<IntArray>): Int {
        rows = grid.size
        cols = grid[0].size
        this.grid = grid
        var maxGold = 0

        // iterate over all cells of the grid
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                maxGold = max(maxGold, dfs(i, j))
            }
        }
        return maxGold
    }

    private fun dfs(row: Int, col: Int): Int {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0
        }
        val gold = grid[row][col]
        grid[row][col] = 0
        // array to facilitate iteration over the adjacent cell (up, right, down, left)
        val directions = intArrayOf(-1, 0, 1, 0, -1)
        var maxGold = 0

        // iterate over all adjacent cells
        for (k in 0 until 4) {
            maxGold = max(maxGold, gold + dfs(row + directions[k], col + directions[k + 1]))
        }
        grid[row][col] = gold
        return maxGold
    }
}

fun main() {
    val obj = PathWithMaxGold()
    val grid = arrayOf(
        intArrayOf(0, 6, 0),
        intArrayOf(5, 8, 7),
        intArrayOf(0, 9, 0)
    )
    val res =obj.getMaximumGold(grid)
    println(res)
}