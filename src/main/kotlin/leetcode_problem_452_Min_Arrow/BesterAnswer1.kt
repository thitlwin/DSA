package leetcode_problem_452_Min_Arrow

class BesterAnswer1 {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }
        var arrows = 0
        var lastArrowPosition = Long.MIN_VALUE
        points.forEach {
            val start = it[0]
            val end = it[1]
            if (start > lastArrowPosition) {
                arrows++
                lastArrowPosition = end.toLong()
            }
        }
        return arrows
    }
}

fun main() {
    val obj = BesterAnswer1()
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