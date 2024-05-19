package leetcode_problem_861_Score_After_Flipping_Matrix

import kotlin.math.max

class Approach2WithoutModifyingInput {
    fun matrixScore(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var score = (1 shl (n-1)) * m

        // loop over all other columns
        for(j in 1 until n) {
            var countSameBits = 0
            for(i in 0 until m) {
                if(grid[i][j] == grid[i][0]) {
                    countSameBits++
                }
            }

            countSameBits = max(countSameBits, m - countSameBits)
            val columnScore = (1 shl (n-j-1)) * countSameBits
            score += columnScore
        }
        return score
    }
}

fun main() {
    val obj = Approach2WithoutModifyingInput()
    val res = obj.matrixScore(
        arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(1, 1, 0, 0)
        )
    )
    println(res)
}