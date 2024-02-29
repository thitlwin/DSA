package DP

//fun maximalSquare(matrix: Array<CharArray>): Int {
//    if (matrix.isEmpty() || matrix[0].isEmpty()) {
//        return 0
//    }
//
//    val rows = matrix.size
//    val cols = matrix[0].size
//    val dp = Array(rows + 1) { IntArray(cols + 1) }
//    var maxSide = 0
//
//    for (i in 1..rows) {
//        for (j in 1..cols) {
//            if (matrix[i - 1][j - 1] == '1') {
//                dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
//                maxSide = maxOf(maxSide, dp[i][j])
//            }
//        }
//    }
//
//    return maxSide * maxSide
//}
//
//// Example usage:
//fun main() {
//    val binaryMatrix = arrayOf(
//        charArrayOf('1', '0', '1', '0', '0'),
//        charArrayOf('1', '0', '1', '1', '1'),
//        charArrayOf('1', '1', '1', '1', '1'),
//        charArrayOf('1', '0', '0', '1', '0')
//    )
//
//    val result = maximalSquare(binaryMatrix)
//    println(result)
//}
class MaximumSquare {
    fun maximalSquare(matrix: List<List<Int>>): Int {
        if (matrix.isEmpty()) {
            return 0
        }
        val rows = matrix.size
        val cols = matrix[0].size
        val dp = Array(rows + 1) { IntArray(cols + 1) }
        var best = 0
        for (i in 1..rows) {
            for (j in 1..cols) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1]) + 1
                    best = maxOf(best, dp[i][j])
                }
            }
        }
        return best * best
    }
}

fun main() {
    val obj = MaximumSquare()
//    val matrix = listOf(
//        listOf(1, 0, 0, 0, 1, 0),
//        listOf(0, 0, 1, 0, 1, 0),
//        listOf(0, 1, 0, 1, 0, 0),
//        listOf(0, 0, 1, 1, 1, 0),
//        listOf(0, 0, 1, 1, 0, 0),
//        listOf(1, 1, 1, 0, 0, 1)
//    )
    val matrix = listOf(
        listOf(1, 0, 1, 1, 1),
        listOf(0, 0, 1, 1, 1),
        listOf(0, 1, 1, 1, 1),
        listOf(1, 0, 0, 0, 1)
    )
    println(obj.maximalSquare(matrix))
}