package leetcode_problem_2849

import kotlin.math.abs
import kotlin.math.max

class BestAnswer {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val xDist = abs(fx - sx)
        val yDist = abs(fy - sy)
        if (xDist == 0 && yDist == 0 && t == 1)
            return false
        return max(xDist, yDist) <= t
    }

}