package leetcode_problem_514_freedom_trail

import kotlin.math.min

class FreedomTrail {
    fun findRotateSteps(ring: String, key: String): Int {
        var count = 0
        for (k in key) {
            for (i in ring.indices) {
                count += min(clockwise(ring, k, i), anticlockwise(ring, k, i))
            }
        }
        return count
    }

    private fun clockwise(ring: String, k: Char, currIndex: Int): Int {
        var count = 0
        var idx = currIndex
        if (currIndex == ring.length)
            idx = 0
        while (true) {
            if (ring[idx] == k)
                return count + 1
            count++
            idx++
        }
    }

    private fun anticlockwise(ring: String, k: Char, currIndex: Int): Int {
        var count = 0
        var idx = currIndex - 1
//        if (currIndex == ring.length)
//            idx = 0
        while (true) {
            val i = ring.length + idx
            if (ring[i] == k)
                return count + 1
            count++
            idx--
        }
    }
}

fun main() {
    val obj = FreedomTrail()
    println(obj.findRotateSteps("godding", "godding"))
}