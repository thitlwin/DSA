package leetcode_problem_120_triangle

import java.util.*

class Triangle_DFS_Memorization {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        val memo = Array<IntArray>(n) { IntArray(n) }
        for (i in 0 until n) {
            Arrays.fill(memo[i], Int.MAX_VALUE)
        }
        return dfs(triangle, 0,0,memo)
    }

//    fun dfs(triangle: List<List<Int>>, level: Int, column: Int, memo: Array<IntArray>): Int{
//        if (level == triangle.size) {
//            return 0
//        }
//        if (memo[level][column] != Int.MAX_VALUE) {
//            return memo[level][column]
//        }
//        val left = dfs(triangle, level+1, column, memo)
//        val right = dfs(triangle, level+1, column+1, memo)
//        memo[level][column] = Math.min(left, right) + triangle[level][column]
//        return memo[level][column]
//    }
    private fun dfs(triangle: List<List<Int>>, row: Int, col: Int, memo: Array<IntArray>): Int{
        if(row == triangle.size)
            return 0
        if(memo[row][col] != Int.MAX_VALUE)
            return memo[row][col]

        val left = dfs(triangle, row+1, col, memo)
        val right = dfs(triangle, row+1, col+1, memo)
        memo[row][col] = Math.min(left, right) + triangle[row][col]
        return memo[row][col]
    }
}

fun main() {
    val obj = Triangle_DFS_Memorization()
    val triangle = listOf(
        listOf(2), listOf(3, 4),
        listOf(6, 5, 7), listOf(4, 1, 8, 3)
    )
    println(obj.minimumTotal(triangle))
}