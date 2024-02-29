package leetcode_problem_120_triangle

class Triangle_BottomUp {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        val dp = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            dp[n - 1][i] = triangle[n - 1][i]
        }
        for (i in n - 2 downTo 0) {
            for (j in 0..i) {
                dp[i][j] = minOf(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
            }
        }
        return dp[0][0]
    }
}

fun main() {
    val obj = Triangle_BottomUp()
    val triangle = listOf(
        listOf(2), listOf(3, 4),
        listOf(6, 5, 7), listOf(4, 1, 8, 3)
    )
    println(obj.minimumTotal(triangle))
}