package graph
class FloodFill {

    fun floodFill(
        row: Int,
        col: Int,
        replacement: Int,
        image: List<MutableList<Int>>
    ): List<List<Int>> {
        val numRows = image.size
        val numCols = image[0].size
        bfs(image, Coordinate(row, col), replacement)//, numRows, numCols)
        return image
    }

    private fun bfs(
        image: List<MutableList<Int>>, root: Coordinate, replacement: Int,
//        numRows: Int, numCols: Int
    ) {
        val numRows = image.size
        val numCols = image[0].size

        val queue = ArrayDeque<Coordinate>()
        queue.add(root)
        val visited = Array(numRows) {
            BooleanArray(numCols)
        }
        val rootColor = image[root.row][root.col]
        image[root.row][root.col] = replacement
        visited[root.row][root.col] = true
        while (queue.size > 0) {
            val node = queue.removeFirst()
            val neighbors = getNeighbors(image, node, rootColor, numRows, numCols)
            for (neighbor in neighbors) {
                if (visited[neighbor.row][neighbor.col]) continue
                image[neighbor.row][neighbor.col] = replacement
                queue.add(neighbor)
                visited[neighbor.row][neighbor.col] = true
            }
        }
    }

    private fun getNeighbors(
        image: List<List<Int>>,
        node: Coordinate,
        rootColor: Int,
        numRows: Int,
        numCols: Int
    ): List<Coordinate> {
        val neighbors = ArrayList<Coordinate>()
        val deltaRow = arrayListOf(-1, 0, 1, 0)
        val deltaCol = arrayListOf(0, 1, 0, -1)
        for (i in 0 until deltaRow.size) {
            val neighborRow = node.row + deltaRow[i]
            val neighborCol = node.col + deltaCol[i]
            if (neighborRow in 0 until numRows &&
                0 <= neighborCol && neighborCol < numCols) {
                if (image[neighborRow][neighborCol] == rootColor) {
                    neighbors.add(Coordinate(neighborRow, neighborCol))
                }
            }
        }
        return neighbors
    }
}

fun main() {
    val obj = FloodFill()
    val image = List(5){
        when(it) {
            0 -> mutableListOf(0,1,3,4,1)
            1 -> mutableListOf(3,8,8,3,3)
            2 -> mutableListOf(6,7,8,8,3)
            3 -> mutableListOf(12,2,8,9,1)
            4 -> mutableListOf(12,3,1,3,2)
            else -> error("Invalid row index")
        }
    }
    val res = obj.floodFill(2,2,9, image)
    res.forEach { println(it.joinToString(" ")) }
}