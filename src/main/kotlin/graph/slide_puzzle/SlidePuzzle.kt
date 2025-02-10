package graph.slide_puzzle

import kotlin.math.pow

// Leetcode - 773
class SlidePuzzle {
    val rowDirections = listOf(-1, 0, 1, 0)
    val colDirections = listOf(0, 1, 0, -1)
    val targetState = 123450
    private fun serialize(position: Array<IntArray>): Int {
        var total = 0
        position.forEach { row ->
            row.forEach { col ->
                total *= 10
                total += col
            }
        }
        return total
    }

    private fun deserialize(state: Int): Array<IntArray> {
        val result = Array(2) {
            IntArray(3) { 0 }
        }

        for (i in 1 downTo 0) {
            for (j in 2 downTo 0) {
                val exponent = i * 3 + j
                val digit = state / 10.0.pow(exponent.toDouble()).toInt() % 10
                result[1 - i][2 - j] = digit
            }
        }
        return result
    }

    fun slidingPuzzle(board: Array<IntArray>): Int {
        val initialState = serialize(board)
        if (initialState == targetState) {
            return 0
        }
        val movesMap: HashMap<Int, Int> = HashMap()
        val queue: ArrayDeque<Int> = ArrayDeque()
        movesMap[initialState] = 0
        queue.add(initialState)

        while (queue.isNotEmpty()) {
            val topState = queue.removeFirst()
            var (row, col) = Pair(0, 0)
            val topPosition = deserialize(topState)
            for (i in 0 until 2) {
                for (j in 0 until 3) {
                    if (topPosition[i][j] == 0) {
                        row = i
                        col = j
                    }
                }
            }

            for (i in rowDirections.indices) {
                val deltaRow = rowDirections[i]
                val deltaCol = colDirections[i]
                val newRow = deltaRow + row
                val newCol = deltaCol + col
                if (newRow in 0..1 && newCol in 0..2) {
                    val newPosition = deserialize(topState)
                    // swap
                    newPosition[row][col] = topPosition[newRow][newCol]
                    newPosition[newRow][newCol] = topPosition[row][col]

                    val newState = serialize(newPosition)
                    if (!movesMap.containsKey(newState)) {
                        movesMap[newState] = movesMap[topState]?.plus(1) ?: 0
                        queue.add(newState)
                        if (newState == targetState) {
                            return movesMap[newState] ?: 0
                        }
                    }
                }
            }
        }
        return -1
    }
}

fun main() {
    val obj = SlidePuzzle()
    val res = obj.slidingPuzzle(arrayOf(intArrayOf(4, 1, 3), intArrayOf(2, 0, 5)))
    println(res)
}