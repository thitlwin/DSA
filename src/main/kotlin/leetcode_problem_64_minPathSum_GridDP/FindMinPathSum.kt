package leetcode_problem_64_minPathSum_GridDP

class FindMinPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        val row = grid.size
        val col = grid[0].size
        val dp = Array<IntArray>(row) { IntArray(col) }
        dp[0][0] = grid[0][0]
        for (c in 1 until col) {
            dp[0][c] = dp[0][c - 1] + grid[0][c]
        }
        for (r in 1 until row) {
            dp[r][0] = dp[r - 1][0] + grid[r][0]
        }
        for (r in 1 until row) {
            for (c in 1 until col) {
                dp[r][c] = minOf(dp[r - 1][c], dp[r][c - 1]) + grid[r][c]
            }
        }
        return dp[row - 1][col - 1]
    }
}

fun main() {
    val obj = FindMinPathSum()
    val grid = arrayOf(intArrayOf(1,3,1), intArrayOf(1,5,1), intArrayOf(4,2,1))
    println(obj.minPathSum(grid))
}