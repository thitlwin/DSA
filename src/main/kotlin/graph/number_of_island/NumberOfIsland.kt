package graph.number_of_island

import graph.Coordinate
import java.util.ArrayDeque

class NumberOfIsland {
    private fun getNeighbors(cell: Coordinate, numRows: Int, numCols: Int): List<Coordinate> {
        val neighbors = ArrayList<Coordinate>()
        val deltaRow = intArrayOf(-1, 0, 1, 0)
        val deltaCol = intArrayOf(0, 1, 0, -1)
        for (i in deltaCol.indices) {
            val neighborRow = cell.row + deltaRow[i]
            val neighborCol = cell.col + deltaCol[i]
            if (neighborRow in 0 until numRows &&
                0 <= neighborCol && neighborCol < numCols
            ) {
                neighbors.add(Coordinate(neighborRow, neighborCol))
            }
        }
        return neighbors
    }

    fun countNumberOfIslands(grid: Array<CharArray>): Int {
        val numRows = grid.size
        val numCols = grid[0].size
        var count = 0
        for (r in 0 until numRows) {
            for (c in 0 until numCols) {
                if (grid[r][c] == '0') continue
                bfs(grid, Coordinate(r, c), numRows, numCols)
                count++
            }
        }
        return count
    }

    private fun bfs(grid: Array<CharArray>, root: Coordinate, numRows: Int, numCols: Int) {
        val queue = ArrayDeque<Coordinate>()
        queue.add(root)
        grid[root.row][root.col] = '0'
        while (queue.size > 0) {
            val node = queue.pop()
            val neighbors = getNeighbors(node, numRows, numCols)
            for (neighbor in neighbors) {
                if (grid[neighbor.row][neighbor.col] == '0') continue
                queue.add(neighbor)
                grid[neighbor.row][neighbor.col] = '0'
            }
        }
    }
}

fun main() {
    val obj = NumberOfIsland()
//    val grid = Array(5) {
//        when(it) {
//            0 -> charArrayOf('1','1','1','0','0','0')
//            1 -> charArrayOf('1','1','1','1','0','0')
//            2 -> charArrayOf('1','1','1','0','0','0')
//            3 -> charArrayOf('0','1','0','0','0','0')
//            4 -> charArrayOf('0','0','0','0','1','0')
//            5 -> charArrayOf('0','0','0','0','0','0')
//            else -> error("invalid index error")
//        }
//    }// res = 2
    val grid = Array(2) {
        when (it) {
            0 -> charArrayOf('1', '0', '1')
            1 -> charArrayOf('0', '1', '0')
            else -> error("invalid index error")
        }
    } // res = 3
    println(obj.countNumberOfIslands(grid))
}