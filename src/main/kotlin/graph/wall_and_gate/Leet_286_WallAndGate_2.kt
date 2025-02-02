package graph.wall_and_gate

class Leet_286_WallAndGate_2 {
    fun wallsAndGates(dungeonMap: List<MutableList<Int>>): List<List<Int>> {
        if(dungeonMap.isEmpty()) {
            return dungeonMap
        }
        val queue: ArrayDeque<Pair<Int,Int>> = ArrayDeque()
        val rows = dungeonMap.size
        val cols = dungeonMap[0].size
        for (r in 0 until rows) {
            for(c in 0 until cols) {
                if (dungeonMap[r][c] == 0) {
                    queue.add(Pair(r,c))
                }
            }
        }

        val neighbors = arrayOf(Pair(-1,0), Pair(0,1), Pair(1,0), Pair(0,-1))

        while (queue.isNotEmpty()) {
            val currentCell = queue.removeFirst()
            for (neighbor in neighbors) {
                val dx = neighbor.first + currentCell.first
                val dy = neighbor.second  + currentCell.second
                if (dx in 0 until rows &&
                    dy in 0 until cols) { // neighbor is within the matrix
                    if (dungeonMap[dx][dy] == Int.MAX_VALUE) {
                        dungeonMap[dx][dy] = dungeonMap[currentCell.first][currentCell.second] + 1
                        queue.add(Pair(dx, dy))
                    }
                }
            }
        }

        return dungeonMap
    }
}

fun main() {

    val obj = Leet_286_WallAndGate_2()
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

    val res = obj.wallsAndGates(dungeonMap)
    println(res.toString())
}