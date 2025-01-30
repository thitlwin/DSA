package graph.number_of_island

//https://leetcode.com/problems/number-of-islands/
class NumberOfIsland_2 {
    fun numIslands(grid: Array<CharArray>): Int {
        val noOfRows = grid.size
        val noOfCols = grid[0].size
        var count = 0
        for (r in 0 until noOfRows) {
            for (c in 0 until noOfCols) {
                if(grid[r][c] == '0') {
                    continue
                }
                bfs(grid, Pair(r, c), noOfRows, noOfCols)
                count++
            }
        }
        return count
    }

    private fun bfs(
        grid: Array<CharArray>,
        pair: Pair<Int, Int>,
        noOfRows: Int,
        noOfCols: Int,
    ) {
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        queue.add(pair)
        val (row, col) = pair
        grid[row][col] = '0'

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            for (neighbor in getNeighbors(node, noOfRows, noOfCols)) {
                val (r, c) = neighbor
                if (grid[r][c] == '0') {
                    continue
                }
                queue.add(neighbor)
                grid[r][c] = '0'
            }
        }
    }

    private fun getNeighbors(node: Pair<Int, Int>, noOfRows: Int, noOfCols: Int): List<Pair<Int, Int>> {
        val deltaRow = intArrayOf(-1, 0, 1, 0)
        val deltaCol = intArrayOf(0, 1, 0, -1)
        val (row, col) = node
        val neighbors = arrayListOf<Pair<Int, Int>>()
        for (i in deltaRow.indices) {
            val neighborRow = deltaRow[i] + row
            val neighborCol = deltaCol[i] + col
            if (neighborRow in 0 until noOfRows
                && neighborCol in 0 until noOfCols
            ) {
                neighbors.add(Pair(neighborRow, neighborCol))
            }
        }
        return neighbors
    }
}

fun main() {
    val obj = NumberOfIsland_2()

//    val grid = arrayOf(
//        charArrayOf('1', '1', '1', '1', '0'),
//        charArrayOf('1', '1', '0', '1', '0'),
//        charArrayOf('1', '1', '0', '0', '0'),
//        charArrayOf('0', '0', '0', '0', '0'),
//    ) // res = 1

    val grid = Array(2) {
        when (it) {
            0 -> charArrayOf('1', '0', '1')
            1 -> charArrayOf('0', '1', '0')
            else -> error("invalid index error")
        }
    } // res = 3
    val res = obj.numIslands(grid)
    println(res)
}