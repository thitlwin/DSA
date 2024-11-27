package leetcode_problem_1091_short_path_in_grid

class ShortestPathInGrid {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) {
            return -1
        }
        val n = grid.size
        // mark the starting cell as visited by setting it to 1
        grid[0][0] = 1
        // initialize a queue to hold the cells to be visited
        val queue = ArrayDeque<Pair<Int, Int>>()
        // start from the top-left corner
        queue.add(Pair(0, 0))
        var steps = 1
        // variable to keep track of the number of steps taken
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                // poll the current cell from the queue
                val (row, col) = queue.removeFirst()

                // if we have reached to the bottom-right corner, return the number of steps
                if (row == n - 1 && col == n - 1) {
                    return steps
                }

                // explore all 8 directions from the current cell
                for (x in row - 1..row + 1) {
                    for (y in col - 1..col + 1) {
                        // check for valid cell coordinates and if the cell is not blocked
                        if (x in 0 until n && y in 0 until n && grid[x][y] == 0) {
                            // mark the cell as visited
                            grid[x][y] = 1
                            queue.add(Pair(x, y))
                        }
                    }
                }
            }
            steps++
        }
        return -1
    }
}

fun main() {
    val obj = ShortestPathInGrid()
    println(obj.shortestPathBinaryMatrix(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
    println(obj.shortestPathBinaryMatrix(arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 0))))
    println(obj.shortestPathBinaryMatrix(arrayOf(intArrayOf(1, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 0))))
}