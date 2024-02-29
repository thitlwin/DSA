package graph

class WallAndGate {
    private val directions = listOf(
        Coordinate(0, 1), Coordinate(1, 0),
        Coordinate(0, -1), Coordinate(-1, 0)
    )

    fun mapGateDistances(dungeonMap: List<MutableList<Int>>): List<List<Int>> {
        val deque = ArrayDeque<Coordinate>()
        val rows = dungeonMap.size
        val cols = dungeonMap[0].size
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (dungeonMap[row][col] == 0) {
                    deque.add(Coordinate(row, col))
                }
            }
        }
        while (deque.isNotEmpty()) {
            val currentPos = deque.removeFirst()
            for (delta in directions) {
                val newPos = currentPos.add(delta)
                if (newPos.row in 0 until rows &&
                    newPos.col in 0 until cols
                ) {
                    if (dungeonMap[newPos.row][newPos.col] == Int.MAX_VALUE) {
                        dungeonMap[newPos.row][newPos.col] = 1 + dungeonMap[currentPos.row][currentPos.col]
                        deque.add(newPos)
                    }
                }
            }
        }
        return dungeonMap
    }
}

fun main() {
    val obj = WallAndGate()
//    val dungeonMap = List(2) {
//        when(it) {
//            0 -> mutableListOf(0, -1)
//            else -> mutableListOf(Int.MAX_VALUE, Int.MAX_VALUE)
//        }
//    }
    val dungeonMap = List(4) {
        when (it) {
            0 -> mutableListOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE)
            1 -> mutableListOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, -1)
            2 -> mutableListOf(Int.MAX_VALUE, -1, Int.MAX_VALUE, -1)
            else -> mutableListOf(0, -1, Int.MAX_VALUE, Int.MAX_VALUE)
        }
    }

    val res = obj.mapGateDistances(dungeonMap)
    println(res.toString())
}