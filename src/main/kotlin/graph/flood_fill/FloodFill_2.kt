package graph.flood_fill

class FloodFill_2 {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val rows = image.size
        val cols = image[0].size
        bfs(image, Pair(sr, sc), color, rows, cols)
        return image
    }

    private fun bfs(image: Array<IntArray>, source: Pair<Int, Int>, color: Int, rows: Int, cols: Int) {
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        val visited: HashSet<Pair<Int, Int>> = HashSet()
        queue.add(source)
        visited.add(source)
        val sourceColor = image[source.first][source.second]
        while (queue.isNotEmpty()) {
            val qSize = queue.size
            for (i in 0 until qSize) {
                val coordinate = queue.removeFirst()
                val (row, col) = coordinate
                if (image[row][col] == sourceColor) {
                    image[row][col] = color
                }
                for (n in neighbors(image, coordinate, rows, cols, sourceColor)) {
                    if (visited.contains(n)) continue
                    visited.add(n)
                    queue.add(n)
                }
            }
        }
    }

    private fun neighbors(
        image: Array<IntArray>,
        coordinate: Pair<Int, Int>,
        numberOfRows: Int,
        numberOfCols: Int,
        sourceColor: Int
    ): List<Pair<Int, Int>> {
        val (row, col) = coordinate
        val deltaRow = intArrayOf(-1, 0, 1, 0)
        val deltaCol = intArrayOf(0, 1, 0, -1)
        val result = arrayListOf<Pair<Int, Int>>()
        for (i in deltaRow.indices) {
            val neighborRow = row + deltaRow[i]
            val neighborCol = col + deltaCol[i]
            if (neighborRow in 0 until numberOfRows &&
                neighborCol in 0 until numberOfCols
            ) {
                if (image[neighborRow][neighborCol] == sourceColor)
                    result.add(Pair(neighborRow, neighborCol))
            }
        }
        return result
    }
}

fun main() {
    val obj = FloodFill_2()
//    [[1,1,1],[1,1,0],[1,0,1]]
    val input = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
    input.forEach {
        println(it.joinToString())
    }
    println("===>")
    val res = obj.floodFill(input, 1, 1, 2)
    res.forEach {
        println(it.joinToString())
    }
}