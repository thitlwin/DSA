package leetcode_problem_452_Min_Arrow

class MinArrow {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if(points.size == 0)
            return 0
        points.sortBy { it[1] }
        var arrows = 1
        var firstBallon = points[0]
        for (i in 1 until points.size) {
            val secondBallon = points[i]
            if(firstBallon[1] >= secondBallon[0]) {
                continue
            } else {
                firstBallon = secondBallon
                arrows++
            }
        }
        return arrows
    }
}

fun main() {
    val obj = MinArrow()
    val res = obj.findMinArrowShots(arrayOf(
        intArrayOf(3,9),
        intArrayOf(7,12),
        intArrayOf(3,8),
        intArrayOf(6,8),
        intArrayOf(9,10),
        intArrayOf(0,9),
        intArrayOf(3,9),
        intArrayOf(0,6),
        intArrayOf(2,8)
    ))
    println(res)
}