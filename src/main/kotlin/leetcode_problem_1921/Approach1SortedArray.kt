package leetcode_problem_1921

class Approach1SortedArray {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val arrival = DoubleArray(dist.size) { dist[it].toDouble() / speed[it] }
        var result = 0
        arrival.sort()
        for (i in arrival.indices) {
            if (arrival[i] <= i)
                break
            result++
        }
        return result
    }
}

fun main() {
    val obj = Approach1SortedArray()
    val dist = intArrayOf(3,2,4)
    val speed = intArrayOf(5,3,2)
    println(obj.eliminateMaximum(dist, speed))
}