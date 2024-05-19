package leetcode_problem_861_Score_After_Flipping_Matrix

class ScoreAfterFlippingMatrix {
    fun matrixScore(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        // set first column
        for (i in 0 until m) {
            if (grid[i][0] == 0) {
                for (j in 0 until n) {
                    grid[i][j] = 1 - grid[i][j]
                }
            }
        }

        // optimize columns excepts first column
        for (j in 1 until n) {
            var countZero = 0
            for (i in 0 until m) {
                if (grid[i][j] == 0) {
                    countZero++
                }
            }

            if (countZero > m - countZero) {
                for (i in 0 until m) {
                    grid[i][j] = 1 - grid[i][j]
                }
            }
        }

        var score = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                val columnScore = grid[i][j] shl (n - j - 1)
                score += columnScore
            }
        }

        return score
    }
}

fun main() {
    val obj = ScoreAfterFlippingMatrix()
    val res = obj.matrixScore(
        arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(1, 1, 0, 0)
        )
    )
    println(res)
}