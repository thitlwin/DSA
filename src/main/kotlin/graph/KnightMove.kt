package graph

class KnightMove {
    private fun getNeighbors(coord: Coordinate): List<Coordinate> {
        val res = ArrayList<Coordinate>()
        val deltaRow = intArrayOf(-2, -2, -1, 1, 2, 2, 1, -1)
        val deltaCol = intArrayOf(-1, 1, 2, 2, 1, -1, -2, -2)
        for (i in deltaRow.indices) {
            val r = coord.row + deltaRow[i]
            val c = coord.col + deltaCol[i]
            res.add(Coordinate(r, c))
        }
        return res
    }

    private fun bfs(start: Coordinate, x: Int, y: Int): Int {
        val visited = HashSet<Coordinate>()
        visited.add(start)
        var steps = 0
        val queue = ArrayDeque<Coordinate>()
        queue.add(start)
        while (queue.size > 0) {
            val n = queue.size
            for (i in 0 until n) {
                val node = queue.removeFirst()
                if (node.col == x && node.row == y) {
                    return steps
                }
                val neighbors = getNeighbors(node)
                for (neighbor in neighbors) {
                    if (visited.contains(neighbor)) continue
                    queue.add(neighbor)
                    visited.add(neighbor)
                }
            }
            steps++
        }
        return steps
    }

    fun getKnightShortestPath(x: Int, y: Int): Int {
        return bfs(Coordinate(0, 0), x, y)
    }
}

fun main() {
    val obj = KnightMove()
//    println(obj.getKnightShortestPath(2,1))
//    println(obj.getKnightShortestPath(5,5))
    println(obj.getKnightShortestPath(1,1))
}