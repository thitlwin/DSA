package graph.knight_move

import kotlin.math.abs

class KnightMove_2 {
    fun getKnightShortestPath(x: Int, y: Int): Int {
        val targetX = abs(x)
        val targetY = abs(y)
        return bfs(Pair(0, 0), targetX, targetY)
    }

    private fun bfs(coordinate: Pair<Int, Int>, x: Int, y: Int): Int {
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        val visited: HashSet<Pair<Int, Int>> = HashSet()
        queue.add(coordinate)
        visited.add(coordinate)
        var steps = 0
        val directions = listOf(
            Pair(-2, -1),
            Pair(-2, 1),
            Pair(-1, 2),
            Pair(1, 2),
            Pair(2, 1),
            Pair(2, -1),
            Pair(1, -2),
            Pair(-1, -2)
        )

        while (queue.isNotEmpty()) {
            val n = queue.size
            for (i in 0 until n) {
                val (currentX, currentY) = queue.removeFirst()
                if (currentX == x && currentY == y) {
                    return steps
                }

                for ((dx, dy) in directions) {
                    val newX = currentX + dx
                    val newY = currentY + dy
                    val newCoord = Pair(newX, newY)
                    if (newX >= -2 && newY >= -2 && !visited.contains(newCoord)){
                        queue.add(newCoord)
                        visited.add(newCoord)
                    }
                }
            }
            steps++
        }
        return -1
    }
}

fun main() {
    val testCases = listOf(
        Pair(2, 1) to 1,  // Basic move
        Pair(5, 5) to 4,  // More steps required
        Pair(0, 0) to 0,  // Already at destination
        Pair(1, 1) to 2,  // Needs at least two moves
        Pair(-2, -1) to 1,  // Negative coordinates
        Pair(-5, -5) to 4,  // Larger negative case
        Pair(299, 299) to 200, // Near boundary, but still valid
        Pair(300, 300) to 200, // Exceeds limit, should return -1
        Pair(-300, -300) to 200,// Exceeds limit, should return -1
        Pair(300, 0) to 150, // Exceeds limit, should return -1
        Pair(150, 150) to 100, // Exceeds limit, should return -1
    )

    val solver = KnightMove_2()

    for ((input, expected) in testCases) {
        val (x, y) = input
        val result = solver.getKnightShortestPath(x, y)
        println("Input: ($x, $y) -> Output: $result (Expected: $expected)")
    }
}
