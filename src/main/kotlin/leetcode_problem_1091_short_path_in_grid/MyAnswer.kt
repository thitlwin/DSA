package leetcode_problem_1091_short_path_in_grid

import java.util.LinkedList
import java.util.Queue

private fun <T> Array<T>.isIndexWithinGrid(newRow: Int, newCol: Int): Boolean {
    return newRow in indices && newCol in indices
}

class MyAnswer {
    private val directions = arrayOf(
        Pair(-1, 0),
        Pair(-1, 1),
        Pair(0, 1),
        Pair(1, 1),
        Pair(1, 0),
        Pair(1, -1),
        Pair(0, -1),
        Pair(-1, -1)
    )

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) {
            return -1
        }
        val n = grid.size
        // mark the starting cell as visited by setting it to 1
        grid[0][0] = 1
        // initialize a queue to hold the cells to be visited
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        // start from the top-left corner
        queue.offer(Pair(0, 0))
        var steps = 1
        // variable to keep track of the number of steps taken
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                // poll the current cell from the queue
                val (row, col) = queue.poll()

                // if we have reached to the bottom-right corner, return the number of steps
                if (row == n - 1 && col == n - 1) {
                    return steps
                }

                // explore all 8 directions from the current cell
                for (direction in directions) {
                    val (dRow, dCol) = direction
                    val newRow = row + dRow
                    val newCol = col + dCol

                    if (grid.isIndexWithinGrid(newRow, newCol) && grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 1
                        queue.offer(Pair(newRow, newCol))
                    }
                }
            }
            steps++
        }
        return -1
    }
}

fun main() {
    val obj = MyAnswer()
    println(obj.shortestPathBinaryMatrix(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
    println(obj.shortestPathBinaryMatrix(arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 1))))
    println(obj.shortestPathBinaryMatrix(arrayOf(intArrayOf(1, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 0))))

    println(obj.shortestPathBinaryMatrix(arrayOf(intArrayOf(0, 1, 0), intArrayOf(0,0,0))))

}