package leetcode_problem_120_triangle

class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        return minPathSum(triangle, 0, 0)
    }

    private fun minPathSum(triangle: List<List<Int>>, row: Int, col: Int): Int {
        if (triangle.size == row) {
            return 0
        }
        val leftSum = minPathSum(triangle, row + 1, col)
        val rightSum = minPathSum(triangle, row + 1, col + 1)
        return triangle[row][col] + leftSum.coerceAtMost(rightSum)
    }
}

fun main() {
    val obj = Triangle()
    val triangle = listOf(
        listOf(2), listOf(3, 4),
        listOf(6, 5, 7), listOf(4, 1, 8, 3)
    )
    println(obj.minimumTotal(triangle))
}