package graph.knight_move

import kotlin.math.abs
class KnightMove_DeepSeek_Answer {
    fun minKnightMoves(x: Int, y: Int): Int {
        // Work in the first quadrant for symmetry
        val targetX = abs(x)
        val targetY = abs(y)

        // Use a visited set and BFS
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()
        queue.add(Pair(0, 0))
        visited.add(Pair(0, 0))
        var steps = 0

        val directions = listOf(
            Pair(2, 1), Pair(1, 2),
            Pair(-1, 2), Pair(-2, 1),
            Pair(-2, -1), Pair(-1, -2),
            Pair(1, -2), Pair(2, -1)
        )

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val (currentX, currentY) = queue.removeFirst()
                if (currentX == targetX && currentY == targetY) return steps

                for ((dx, dy) in directions) {
                    val newX = currentX + dx
                    val newY = currentY + dy
                    // Prune moves that go too far from the target
                    if (newX >= -2 && newY >= -2 && !visited.contains(Pair(newX, newY))) {
                        visited.add(Pair(newX, newY))
                        queue.add(Pair(newX, newY))
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

    val solver = KnightMove_DeepSeek_Answer()

    for ((input, expected) in testCases) {
        val (x, y) = input
        val result = solver.minKnightMoves(x, y)
        println("Input: ($x, $y) -> Output: $result (Expected: $expected)")
    }
}
